package com.app.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.CitizenPlan;

public interface CitizenPlanrepo extends JpaRepository<CitizenPlan, Serializable> {
	@Query( "select distinct(planName) from com.app.entity.CitizenPlan")
	public List<String> findByPlanName();
	@Query( "select distinct(planStatus) from com.app.entity.CitizenPlan")
	public List<String> findPlanStatus();
	
	

}
