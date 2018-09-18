package com.sdet.dao;

import java.util.ArrayList;
import com.sdet.entities.Patient;
import com.sdet.entities.Report;
import com.sdet.entities.Test;

public interface DiagnosticDao 
{
	Patient fetchByEmail(String email);
	Patient fetchByPhone(long phone);
	Test fetchByTest(String Name);
	void putPatientTests(int P_ID,int t_Id);
	ArrayList<Report> fetchCost(int P_ID,String date);
}
