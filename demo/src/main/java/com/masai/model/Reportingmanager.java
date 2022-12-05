package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reportingmanager {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer managerid;
	private String name;
	private String type;
	@JsonIgnore
	@OneToOne
	private Employee emp;
	
   
	
	
	

}
