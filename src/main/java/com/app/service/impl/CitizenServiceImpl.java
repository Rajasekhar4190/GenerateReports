package com.app.service.impl;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.entity.CitizenPlan;
import com.app.entity.SearchPlan;
import com.app.repo.CitizenPlanrepo;
import com.app.service.CitizenService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
@Service
public class CitizenServiceImpl implements CitizenService {
	@Autowired 
	private CitizenPlanrepo repo;

	@Override
	public List<String> getcitizenPlanNames() {
		// TODO Auto-generated method stub
		List<String> lis=repo.findByPlanName();
		
		
		return lis;
	}

	@Override
	public List<String> getCitizenStatus() {
		// TODO Auto-generated method stub
		List<String> lis=repo.findPlanStatus();

		return lis;
	}

	@Override
	public List<CitizenPlan> getCitizenPlan(SearchPlan plan) {
		// TODO Auto-generated method stub
		CitizenPlan c=new CitizenPlan();
		if(c.getPlanName()!=null&&!c.getPlanName().equals("")) {
			c.setPlanName(plan.getPlanName());
		}
		if(c.getPlanStatus()!=null&&!c.getPlanName().equals("")) {
			c.setPlanStatus(plan.getPlanStatus());
		}
		Example<CitizenPlan> example=Example.of(c);
		List<CitizenPlan> result=repo.findAll(example);
		
	
		
		
		return result;
	}

	@Override
	public void getExcepExport(HttpServletResponse response) throws IOException  {
		// TODO Auto-generated method stub
		List<CitizenPlan> ct=repo.findAll();
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet();
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("cid");
		row.createCell(1).setCellValue("cname");
		row.createCell(2).setCellValue("email");
		row.createCell(3).setCellValue("phNo");
		row.createCell(4).setCellValue("gender");
		row.createCell(5).setCellValue("ssn");
		row.createCell(6).setCellValue("planName");
		row.createCell(7).setCellValue("status");
		
		int row1=1;
		for(CitizenPlan c:ct) {
			//HSSFSheet sheet1= workbook.createSheet();
			HSSFRow row2=sheet.createRow(row1);
			row2.createCell(0).setCellValue(c.getCid());
			row2.createCell(1).setCellValue(c.getCname());
			row2.createCell(2).setCellValue(c.getEmail());
			row2.createCell(3).setCellValue(c.getPhNo());
			row2.createCell(4).setCellValue(c.getGender());
			row2.createCell(5).setCellValue(c.getSsn());
			row2.createCell(6).setCellValue(c.getPlanName());
			row2.createCell(7).setCellValue(c.getPlanStatus());
			row1++;
		}
		
			ServletOutputStream stream=response.getOutputStream();
			workbook.write(stream);
			workbook.close();
			stream.close();
		
		
		
		
		

	}

	@Override
	public void getPdfExport(HttpServletResponse response) throws DocumentException, IOException {
          // TODO Auto-generated method stub
		List<CitizenPlan> plan=repo.findAll();
		
		Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 2.0f, 3.0f, 2.0f, 1.5f,1.5f,1.5f,1.5f});
        table.setSpacingBefore(10);
        
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
        font1.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("CID", font1));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("CName", font1));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Email", font1));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("PhNO", font1));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Gender", font1));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("SSN", font1));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("PlanName", font1));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("PlanStatus", font1));
        table.addCell(cell);   
        
        for(CitizenPlan pn:plan) {
        	table.addCell(String.valueOf(pn.getCid()));
        	table.addCell(pn.getCname());
        	table.addCell(pn.getEmail());
        	table.addCell(String.valueOf(pn.getPhNo()));
        	table.addCell(pn.getGender());
        	table.addCell(String.valueOf(pn.getSsn()));
        	table.addCell(pn.getPlanName());
        	table.addCell(pn.getPlanStatus());
        	
        }
    
   
        document.add(table);
        document.close();
         

	}

}
