package com.ctg.mvnbook.account.email;

public class AccountEmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8639020976149682503L;

	public AccountEmailException(String message){
		super(message);
	}
	
	public AccountEmailException(String message,Throwable throwable){
		super(message, throwable);
	}
	
}
