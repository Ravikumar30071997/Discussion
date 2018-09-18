package com.sdet.entities;

public class InvalidDateException extends Exception
{  
	public InvalidDateException()
	{  
		super();  
	}
	
	public String toString()
	{
		return "Enter a valid Date.";
	}
}
