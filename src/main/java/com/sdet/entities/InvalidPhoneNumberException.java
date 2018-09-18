package com.sdet.entities;

public class InvalidPhoneNumberException extends Exception
{  
	public InvalidPhoneNumberException(String s)
	{  
		System.out.println(s);  
	}
	
}