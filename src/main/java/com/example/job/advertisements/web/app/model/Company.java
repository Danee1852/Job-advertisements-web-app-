package com.example.job.advertisements.web.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Company {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String description;
	
	private int size; 
	
	private String location;

	private boolean deleted;
	
	
	public Company() {
		
		
	}

	public Company(String name, String description, int size, String location, boolean deleted) {
		super();
		this.name = name;
		this.description = description;
		this.size = size;
		this.location = location;
		this.deleted= deleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
