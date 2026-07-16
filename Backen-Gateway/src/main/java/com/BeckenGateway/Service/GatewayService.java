package com.BeckenGateway.Service;

import com.BeckenGateway.DTO.AckResponse;
import com.BeckenGateway.DTO.SearchRequest;
import com.BeckenGateway.DTO.SearchResponse;

public interface GatewayService 
{
	
	AckResponse search(SearchRequest request);
}