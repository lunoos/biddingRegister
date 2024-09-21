package com.bidding.register.exception;

public class UserAlreadyExistsException extends RuntimeException {

	public UserAlreadyExistsException(String errorMssg) {
		super(errorMssg);
	}
}
