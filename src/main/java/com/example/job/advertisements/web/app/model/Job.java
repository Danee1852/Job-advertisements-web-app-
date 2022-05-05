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

	@NotEmpty(message = "You must enter the title.")
	@Size(min=2, max = 30, message = "You must add a description with length beetwen 2 and 30 letters.")
	@Column(name = "title")
	private String title;

	@NotEmpty(message = "You must enter the description.")
	@Size(min=10, max = 150, message = "You must add a description with length beetwen 10 and 150 letters.")
	@Column(name = "description")
	private String description;

	
	@Column(name = "profession")
	private String profession;

	
	@Column(name = "status")
	private String status;

	
	@Column(name = "location")
	private String location;

	@Column(name = "publishDate")
	private String publishDate;

	public Job() {

	}
	// ,

	public Job(String title, String description, String location, String profession, String status,
			String publishDate) {

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
