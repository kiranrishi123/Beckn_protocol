package com.BeckenGateway.Service;

import com.BeckenGateway.DTO.SearchRequest;
import com.BeckenGateway.DTO.SearchResponse;

public interface GatewayService 
{
	
	SearchResponse search(SearchRequest request);
}
