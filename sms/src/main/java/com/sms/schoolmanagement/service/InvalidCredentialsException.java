package com.sms.schoolmanagement.service;

public class InvalidCredentialsException extends RuntimeException {
	public InvalidCredentialsException(String message) {
        super(message);
    }
}
