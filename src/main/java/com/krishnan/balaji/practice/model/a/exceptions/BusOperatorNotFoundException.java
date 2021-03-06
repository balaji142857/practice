package com.krishnan.balaji.practice.model.a.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Order")
public class BusOperatorNotFoundException extends RuntimeException {

	public BusOperatorNotFoundException(String message) {
		super(message);
	}

}
