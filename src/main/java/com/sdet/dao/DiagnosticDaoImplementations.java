package com.sdet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import com.sdet.entities.InvalidEmailIdException;
import com.sdet.entities.Patient;
import com.sdet.entities.Report;
import com.sdet.entities.Test;
import com.sdet.util.DBUtil;

public class DiagnosticDaoImplementations implements DiagnosticDao {

	@Override
	public Patient fetchByEmail(String email) 
	{
		Patient p = null;
		try {
			DBUtil obj = new DBUtil();
			Connection con = obj.getConnection();
			
			String query = "select * from patient where email='"+ email + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next())
				p = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		} catch (Exception e) {
			System.out.println(e);
		}
		return p;
	}

	@Override
	public Patient fetchByPhone(long phone) {
		Patient p = null;
		try {
			DBUtil obj = new DBUtil();
			Connection con = obj.getConnection();

			String query = "select * from patient where phone=?;";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setLong(1, phone);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next())
				p = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		} catch (Exception e) {
			System.out.println(e);
		}
		return p;

	}

	@Override
	public Test fetchByTest(String Name) {
		Test t = null;
		try {
			DBUtil obj = new DBUtil();
			Connection con = obj.getConnection();

			String query = "select * from test where name=?;";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, Name);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next())
				t = new Test(rs.getInt(1), rs.getString(2), rs.getInt(3));
		} catch (Exception e) {
			System.out.println(e);
		}
		return t;
	}

	@Override
	public void putPatientTests(int P_ID, int t_Id) {
		try {
			DBUtil obj = new DBUtil();
			Connection con = obj.getConnection();
			String query = " insert into patient_test(P_ID,T_ID,DATE)" + " values (?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, P_ID);
			preparedStmt.setInt(2, t_Id);
			preparedStmt.setString(3, LocalDate.now().toString().trim());

			preparedStmt.execute();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public ArrayList<Report> fetchCost(int P_ID, String date) {
		ArrayList<Report> r = new ArrayList<Report>();
		Report report = null;
		try {
			DBUtil obj = new DBUtil();
			Connection con = obj.getConnection();

			String query = "select test.name,test.cost from test inner join patient_test on test.t_id = patient_test.t_id where patient_test.date='"
					+ date + "' and patient_test.p_id=" + P_ID;

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				report = new Report(rs.getString(1), rs.getInt(2));
				r.add(report);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}
}
