package com.BeckenGateway.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.BeckenGateway.DTO.AckResponse;
import com.BeckenGateway.DTO.SearchRequest;
import com.BeckenGateway.DTO.SearchResponse;
import com.BeckenGateway.Service.GatewayService;
import com.BeckenGateway.validation.RequestValidator;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class GatewayController 
{
	private final GatewayService _gatewayService;
	 private final RequestValidator requestValidator;


	@PostMapping("/search")
    public AckResponse search(@RequestBody SearchRequest request) 
	{
		requestValidator.validate(request);

        return _gatewayService.search(request);

    }
}
