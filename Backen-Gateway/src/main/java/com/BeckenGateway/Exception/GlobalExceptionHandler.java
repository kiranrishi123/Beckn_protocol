package com.BeckenGateway.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.BeckenGateway.DTO.Ack;
import com.BeckenGateway.DTO.AckMessage;
import com.BeckenGateway.DTO.ErrorDTO;
import com.BeckenGateway.DTO.ErrorResponse;
import com.BeckenGateway.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex)
	{
        Ack ack = new Ack();
        ack.setStatus("NACK");

        AckMessage ackMessage = new AckMessage();
        ackMessage.setAck(ack);

        ErrorDTO error = new ErrorDTO();
        error.setCode(ex.getErrorCode().getCode());
        error.setMessage(ex.getErrorCode().getMessage());

        ErrorResponse response = new ErrorResponse();
        response.setMessage(ackMessage);
        response.setError(error);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
	}

}
