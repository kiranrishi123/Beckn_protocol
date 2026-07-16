	package com.BeckenGateway.ServiceImp;
	
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.BeckenGateway.DTO.Ack;
import com.BeckenGateway.DTO.AckMessage;
import com.BeckenGateway.DTO.AckResponse;
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
import com.BeckenGateway.Service.GatewayService;
import com.BeckenGateway.Service.SearchProcessorService;

import lombok.RequiredArgsConstructor;
	
	
	
@Service
@RequiredArgsConstructor
public class GatewayServiceImp implements GatewayService
{	
	
	  private final SearchProcessorService searchProcessorService;
	
	@Override
	public AckResponse search(SearchRequest request) {
		
		
        searchProcessorService.processSearch(request);

        Ack ack = new Ack();
        ack.setStatus("ACK");

        AckMessage ackMessage = new AckMessage();
        ackMessage.setAck(ack);

        AckResponse ackResponse = new AckResponse();
        ackResponse.setAckMessage(ackMessage);

        return ackResponse;
	}
	
		
}
