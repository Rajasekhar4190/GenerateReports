package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="citizens_plans_info")
public class CitizenPlan {
	@Id
	@GeneratedValue
private Integer cid;
private String cname;
private String email;
private Long phNo;
private String gender;
private Integer ssn;
private String planName;
private String planStatus;
}
