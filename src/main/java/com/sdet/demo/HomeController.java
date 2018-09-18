package com.sdet.demo;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sdet.client.DiagnosticSystemClient;
import com.sdet.dao.DiagnosticDaoImplementations;
import com.sdet.entities.InvalidDateException;
import com.sdet.entities.Patient;
import com.sdet.entities.Report;
import com.sdet.service.DiagnosticServiceImplementations;


@EnableAutoConfiguration
@Controller
public class HomeController implements ErrorController {

	private static final String PATH = "/error";

	public HomeController() {

	}

	@RequestMapping(value = PATH)
	public String error() {
		return "Error handling";
	}

	@Override
	public String getErrorPath() {

		System.out.println("error path ");
		return PATH;
	}

	@RequestMapping(value = "/dianosticdb",method= {RequestMethod.POST,RequestMethod.GET})
	public void addTestE(@RequestParam("1000") String email)
	{
		DiagnosticDaoImplementations obj=new DiagnosticDaoImplementations();
		DiagnosticServiceImplementations.addTests(obj.fetchByEmail(email));

	}
	@RequestMapping(value = "/dianosticd",method= {RequestMethod.POST,RequestMethod.GET})
	public void addTestP(@RequestParam("1001") String phone)
	{
		DiagnosticDaoImplementations obj=new DiagnosticDaoImplementations();
		DiagnosticServiceImplementations.addTests(obj.fetchByPhone(Integer.parseInt(phone)));

	}
	
	@RequestMapping(value = "/dianostic",method= {RequestMethod.POST,RequestMethod.GET})
	public void GenerateReports(@RequestParam("1000")String email)
	{
		ArrayList<Report> r=new ArrayList<Report>();
		DiagnosticDaoImplementations obj=new DiagnosticDaoImplementations();
		Patient p1=obj.fetchByEmail(DiagnosticSystemClient.enterEmail());
		
		DiagnosticSystemClient.printReport(p1,r);
	}
	
		
		@RequestMapping(value = "/dianosti",method= {RequestMethod.POST,RequestMethod.GET})
		public void GenerateReportsP(@RequestParam("1001")String Date) throws InvalidDateException
		{
			ArrayList<Report> r=new ArrayList<Report>();
			DiagnosticDaoImplementations obj=new DiagnosticDaoImplementations();
			Patient p1=obj.fetchByEmail(DiagnosticSystemClient.enterDate());
			
			DiagnosticSystemClient.printReport(p1,r);
		}
		
	}

