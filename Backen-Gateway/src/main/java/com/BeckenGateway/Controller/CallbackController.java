package com.BeckenGateway.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BeckenGateway.DTO.SearchResponse;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class CallbackController
{

	 @PostMapping("/on_search")
	    public ResponseEntity<Void> onSearch(
	            @RequestBody String body) {

	        System.out.println(body);

	        return ResponseEntity.ok().build();
	    }


}
