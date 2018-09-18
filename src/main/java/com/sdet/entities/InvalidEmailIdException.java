package com.sdet.entities;

public class InvalidEmailIdException extends Exception
{  
	public InvalidEmailIdException(String a)
	{  
		super(a);  
	}
	
	public String toString()
	{
		return "Enter a valid Email.";
	}
}
