package com.BeckenGateway.ServiceImp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.BeckenGateway.DTO.Catalog;
import com.BeckenGateway.DTO.Context;
import com.BeckenGateway.DTO.Descriptor;
import com.BeckenGateway.DTO.Item;
import com.BeckenGateway.DTO.MessageResponse;
import com.BeckenGateway.DTO.Price;
import com.BeckenGateway.DTO.ProductDto;
import com.BeckenGateway.DTO.Provider;
import com.BeckenGateway.DTO.SearchRequest;
import com.BeckenGateway.DTO.SearchResponse;
import com.BeckenGateway.Fegin.SellerFeignClient;
import com.BeckenGateway.Service.SearchProcessorService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchProcessorServiceImpl implements SearchProcessorService {

    private final RestTemplate restTemplate;
    private final SellerFeignClient sellerFeignClient;

    @Value("${beckn.bpp.id}")
    private String bppId;

    @Value("${beckn.bpp.uri}")
    private String bppUri;

    @Async
    @Override
    public void processSearch(SearchRequest request) {

        try {

            String itemName = request.getMessage()
                    .getIntent()
                    .getItem()
                    .getDescriptor()
                    .getName();

            List<ProductDto> products =
                    sellerFeignClient.getProductByName(itemName);

            List<Item> becknItems = new ArrayList<>();

            for (ProductDto product : products) {

                Descriptor itemDescriptor = new Descriptor();
                itemDescriptor.setName(product.getItemName());

                Price price = new Price();
                price.setCurrency("INR");
                price.setValue(String.valueOf(product.getPrice()));

                Item item = new Item();
                item.setId(product.getId());
                item.setDescriptor(itemDescriptor);
                item.setPrice(price);

                becknItems.add(item);
            }

            Provider provider = new Provider();

            if (!products.isEmpty()) {

                Descriptor providerDescriptor = new Descriptor();
                providerDescriptor.setName(products.get(0).getSellerName());

                provider.setId(products.get(0).getSellerId());
                provider.setDescriptor(providerDescriptor);
            }

            provider.setItems(becknItems);

            List<Provider> providers = new ArrayList<>();
            providers.add(provider);

            Catalog catalog = new Catalog();
            catalog.setProviders(providers);

            MessageResponse messageResponse = new MessageResponse();
            messageResponse.setCatalog(catalog);

            Context responseContext = new Context();

            responseContext.setDomain(request.getContext().getDomain());
            responseContext.setTransactionId(request.getContext().getTransactionId());
            responseContext.setMessageId(request.getContext().getMessageId());
            responseContext.setBapId(request.getContext().getBapId());
            responseContext.setBapUri(request.getContext().getBapUri());
            responseContext.setAction("on_search");
            responseContext.setTimestamp(Instant.now().toString());
            responseContext.setBppId(bppId);
            responseContext.setBppUri(bppUri);


            responseContext.setTtl(request.getContext().getTtl());

            SearchResponse response = new SearchResponse();
            response.setContext(responseContext);
            response.setMessage(messageResponse);

          
            String callbackUrl =
                    request.getContext().getBapUri() + "/on_search";

            restTemplate.postForEntity(
                    callbackUrl,
                    response,
                    Void.class
            );


        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}