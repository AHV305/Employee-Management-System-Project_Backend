package com.ahv.emsp.dto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	//parameterized constructor
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
