package com.example.job.advertisements.web.app.DTO;

public class CompanyDto {

	private Long id;
	private String name;
	private String description;
	private int size;
	private String location;
	private boolean deleted;
	
	
	
	public CompanyDto() {
	
		
	}
	
	public Long getId() {
		
		return id;
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
	
	public void setDeeted(boolean deleted) {
		this.deleted=deleted;
	}
	
	

}
