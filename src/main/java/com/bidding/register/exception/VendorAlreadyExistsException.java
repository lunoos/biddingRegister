package com.bidding.register.exception;

public class VendorAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VendorAlreadyExistsException(String errorMssg) {
		super(errorMssg);
	}
}
