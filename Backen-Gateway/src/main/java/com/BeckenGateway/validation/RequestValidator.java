package com.BeckenGateway.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.BeckenGateway.DTO.Context;
import com.BeckenGateway.DTO.SearchRequest;

@Component
public class RequestValidator 
{
	
    public void validate(SearchRequest request) {

        if (request == null) {
            throw new ValidationException(ErrorCode.INVALID_REQUEST);
        }

        if (request.getContext() == null) {
            throw new ValidationException(ErrorCode.MISSING_CONTEXT);
        }

        if (request.getMessage() == null) {
            throw new ValidationException(ErrorCode.MISSING_MESSAGE);
        }

        Context context = request.getContext();

        if (isBlank(context.getAction())) {
            throw new ValidationException(ErrorCode.INVALID_ACTION);
        }

        if (!"search".equalsIgnoreCase(context.getAction())) {
            throw new ValidationException(ErrorCode.INVALID_ACTION);
        }

        if (isBlank(context.getDomain())) {
            throw new ValidationException(ErrorCode.MISSING_DOMAIN);
        }

        if (isBlank(context.getBapId())) {
            throw new ValidationException(ErrorCode.MISSING_BAP_ID);
        }

        if (isBlank(context.getBapUri())) {
            throw new ValidationException(ErrorCode.MISSING_BAP_URI);
        }

        if (isBlank(context.getTransactionId())) {
            throw new ValidationException(ErrorCode.MISSING_TRANSACTION_ID);
        }

        if (isBlank(context.getMessageId())) {
            throw new ValidationException(ErrorCode.MISSING_MESSAGE_ID);
        }

        if (isBlank(context.getTimestamp())) {
            throw new ValidationException(ErrorCode.MISSING_TIMESTAMP);
        }

        if (isBlank(context.getTtl())) {
            throw new ValidationException(ErrorCode.MISSING_TTL);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

}
