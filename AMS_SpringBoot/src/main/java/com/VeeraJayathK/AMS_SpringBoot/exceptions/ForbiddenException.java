package com.VeeraJayathK.AMS_SpringBoot.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.web.server.ResponseStatusException;

public class ForbiddenException extends ResponseStatusException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForbiddenException(String reason) {
		super(HttpStatus.FORBIDDEN, reason);
	}
}