package com.example.job.advertisements.web.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "publishDate")
	private String publishDate;
	
	public Job() {
		
	}
	

	public Job(String title, String description, String category, String status, String location, String publishDate) {
		
		this.title = title;
		this.description = description;
		this.category = category;
		this.status = status;
		this.location = location;
		this.publishDate = publishDate;
	}



	public long getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	} 
	

}
