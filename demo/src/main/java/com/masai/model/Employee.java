package com.masai.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	private String firstName;
	private String lastName;
	
	private String emil;
	private String phoneNumebr;
	
	private String type;
	

	private Integer salary;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Reportingmanager manager;
	

}
