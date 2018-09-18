package com.sdet.service;

import com.sdet.client.DiagnosticSystemClient;
import com.sdet.dao.*;
import com.sdet.entities.Patient;
import com.sdet.entities.Report;
import com.sdet.entities.Test;
import java.util.ArrayList;
import java.util.Scanner;
public class DiagnosticServiceImplementations implements DiagnosticService 
{
	Scanner sc=new Scanner(System.in);

	@Override
	public void AddDiagnosticTests(int choice) 
	{
		DiagnosticDaoImplementations obj=new DiagnosticDaoImplementations();

		switch(choice)
		{
		case 1:
			addTests(obj.fetchByEmail(DiagnosticSystemClient.enterEmail()));
			break;
		case 2:
			addTests(obj.fetchByPhone(DiagnosticSystemClient.enterNumber()));
			break;
		}

	}

	@Override
	public void GenerateReports(int choice) 
	{
		ArrayList<Report> r=new ArrayList<Report>();
		DiagnosticDaoImplementations obj=new DiagnosticDaoImplementations();

		switch(choice)
		{
		case 1:
			Patient p1=obj.fetchByEmail(DiagnosticSystemClient.enterEmail());
			r=getReports(p1);
			DiagnosticSystemClient.printReport(p1,r);
			break;
		case 2:
			Patient p2=obj.fetchByPhone(DiagnosticSystemClient.enterNumber());
			r=getReports(p2);
			DiagnosticSystemClient.printReport(p2,r);
			break;
		}

	}

	public static void addTests(Patient p)
	{
		ArrayList<Test> arr=new ArrayList<Test>();
		Test t;
		DiagnosticDaoImplementations obj=new DiagnosticDaoImplementations();
		String exit="YES";
		while(exit.equalsIgnoreCase("YES"))
		{
			t=obj.fetchByTest(DiagnosticSystemClient.enterTestName());
			arr.add(t);
			exit=DiagnosticSystemClient.status();
		}
		for(int i=0;i<arr.size();i++)
		{
			Test temp=arr.get(i);
			//System.out.println(temp.gettId()+"  "+p.getpId());
			obj.putPatientTests(p.getpId(),temp.gettId());
		}
		DiagnosticSystemClient.successMessage();
	}

	public ArrayList<Report> getReports(Patient p)
	{
		ArrayList<Report> report=new ArrayList<Report>();

		DiagnosticDaoImplementations obj=new DiagnosticDaoImplementations();

		//System.out.println("Enter Test Date [YYYY-MM-DD]: ");
		//String date=sc.next();
		try{
			report=obj.fetchCost(p.getpId(),DiagnosticSystemClient.enterDate());
		}catch(Exception e){System.out.println(e);}
		return report;
	}

}

