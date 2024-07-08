package com.VeeraJayathK.AMS_SpringBoot.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ManagerIsNotApprovedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManagerIsNotApprovedException() {
		super("Manager is not approved");
	}
}