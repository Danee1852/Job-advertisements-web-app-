package com.example.job.advertisements.web.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	@Size(max=20)
	@Column(name = "title")
	private String title;
	
	@NotEmpty
	@Size(max=200)
	@Column(name = "description")
	private String description;
	
	@NotEmpty
	@Column(name = "profession")
	private String profession;
	
	@NotEmpty
	@Column(name = "status")
	private String status;
	
	@NotEmpty
	@Column(name = "location")
	private String location;
	
	@Column(name = "publishDate")
	private String publishDate;
	
	public Job() {
		
	}
	

	public Job(String title, String description, String profession, String status, String location, String publishDate) {
		
		this.title = title;
		this.description = description;
		this.profession = profession;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
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
