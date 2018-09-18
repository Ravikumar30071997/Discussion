package com.sdet.entities;

public class Report 
{
	String name;
	int cost;
	public Report(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
