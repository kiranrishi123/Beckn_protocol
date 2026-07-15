package com.BeckenGateway.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Context {
	
	private String domain;

	@JsonProperty("transaction_id")
	private String transactionId;

	@JsonProperty("message_id")
	private String messageId;

	@JsonProperty("bap_id")
	private String bapId;
	
	private String action;

	@JsonProperty("bap_uri")
	private String bapUri;

	@JsonProperty("bpp_id")
	private String bppId;

	@JsonProperty("bpp_uri")
	private String bppUri;
    private String timestamp;
    private String ttl;

}
