package com.niit.ekartback.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity // to map the data base table
@Table(name = "user") // if the table name and domain class name is different
@Component // context.scan("com.niit") --will scan the pacakge and create
			// singleton instances
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true, nullable = false)
	private String username;
	@NotEmpty
	private String password;
	private boolean enabled;
	@OneToOne(mappedBy = "user")
	private Customer customer;
	
	
	
	
	
}
