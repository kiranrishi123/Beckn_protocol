package com.BeckenGateway.Fegin;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.BeckenGateway.DTO.ProductDto;
import com.BeckenGateway.DTO.SearchRequest;
import com.BeckenGateway.DTO.SearchResponse;


@FeignClient(name="seller-app")
public interface SellerFeignClient 
{
	@GetMapping("/seller/v1/getProductByName")
    List<ProductDto> getProductByName(@RequestParam("itemName") String itemName);

}
