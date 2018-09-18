package com.sdet.entities;

public class InvalidTestNameException extends Exception
{  
	public InvalidTestNameException(String s)
	{  
		super(s);
	}
	
	public String MyException()
	{
		return "IS it not an emailID";
		
	}
}