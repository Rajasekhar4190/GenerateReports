package com.app.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.CitizenPlan;
import com.app.entity.SearchPlan;
import com.app.service.CitizenService;
import com.lowagie.text.DocumentException;

@RestController
public class CitizenController {
	@Autowired
	private CitizenService service;
	@GetMapping("/planname")
	public List<String> getplanName(){
		return service.getcitizenPlanNames();
		
	}
	@GetMapping("/planstatus")
	public List<String> getplastatus(){
		return service.getCitizenStatus();
		
	}
	@GetMapping("/getall")
	public List<CitizenPlan>  getSearchPlanNameAndStatus(SearchPlan plan){
		return service.getCitizenPlan(plan);
		
	}
	@GetMapping("/export")
	public void generateExportExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey="content-Disposition";
		String headerValue="attachment;filename=citizen.xls";
		response.setHeader(headerKey, headerValue);
		service.getExcepExport(response);
		
		
	}
	@GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
 
        service.getPdfExport(response);
         
    }

}
