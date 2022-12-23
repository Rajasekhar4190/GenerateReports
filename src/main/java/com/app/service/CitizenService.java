package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.app.entity.CitizenPlan;
import com.app.entity.SearchPlan;
import com.lowagie.text.DocumentException;

public interface CitizenService {

	List<String> getcitizenPlanNames();
	List<String> getCitizenStatus();
	List<CitizenPlan> getCitizenPlan(SearchPlan plan);
	void getExcepExport(HttpServletResponse response) throws IOException;
	void getPdfExport(HttpServletResponse response) throws DocumentException, IOException;
}
