package com.ctg.mvnbook.account.persist;

public class AccountPersistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8780719290638193659L;

	public AccountPersistException(String message){
		super(message);
	}
	
	public AccountPersistException(String message,Throwable throwable){
		super(message,throwable);
	}
}
