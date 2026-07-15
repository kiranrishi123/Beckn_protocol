package com.BeckenGateway.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BeckenGateway.DTO.SearchRequest;
import com.BeckenGateway.DTO.SearchResponse;
import com.BeckenGateway.Service.GatewayService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class GatewayController 
{
	private final GatewayService _gatewayService;

	@PostMapping("/search")
    public SearchResponse search(@RequestBody SearchRequest request) {

        return _gatewayService.search(request);

    }
}
