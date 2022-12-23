package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.app.entity.CitizenPlan;
import com.app.repo.CitizenPlanrepo;

@SpringBootApplication
public class GenerateReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerateReportsApplication.class, args);
//		ConfigurableApplicationContext cat=SpringApplication.run(GenerateReportsApplication.class, args);
//		CitizenPlanrepo bean=cat.getBean(CitizenPlanrepo.class);
//		CitizenPlan ctxt=new CitizenPlan();
//		//ctxt.setCid(101);
//		ctxt.setCname("Sourav");
//		ctxt.setEmail("Sourav@gmail.com");
//		ctxt.setGender("male");
//		ctxt.setPlanName("JFST");
//		ctxt.setPlanStatus("Active");
//		ctxt.setSsn(12);
//		ctxt.setPhNo((long)9000613);
//		bean.save(ctxt);
		
		
		
		
		
	}

}
