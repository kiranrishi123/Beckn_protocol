package com.BeckenGateway.validation;

public enum ErrorCode 
{
    INVALID_REQUEST("30001", "Invalid Request"),
    MISSING_CONTEXT("30002", "Context is missing"),
    MISSING_MESSAGE("30003", "Message is missing"),
    INVALID_ACTION("30004", "Invalid Action"),
    MISSING_DOMAIN("30005", "Domain is missing"),
    MISSING_BAP_ID("30006", "BAP ID is missing"),
    MISSING_BAP_URI("30007", "BAP URI is missing"),
    MISSING_TRANSACTION_ID("30008", "Transaction ID is missing"),
    MISSING_MESSAGE_ID("30009", "Message ID is missing"),
    MISSING_TIMESTAMP("30010", "Timestamp is missing"),
    MISSING_TTL("30011", "TTL is missing");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
