package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {
	//Basic event info. For this demo, store info as strings
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String host;
	private String location;
	private String date;
	private String time;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Event(String name, String host, String location, String date, String time, Category category) {
		this.name = name;
		this.host = host;
		this.location = location;
		this.date = date;
		this.time = time;
		this.category = category;
	}
	
	public Event() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		if (this.category != null) 
			return "Event [id=" + id + ", name=" + name + ", host=" + host + ", location=" + location + ", date=" + date
					+ ", time=" + time + ", category=" + category + "]";
		
		else 
			return "Event [id=" + id + ", name=" + name + ", host=" + host + ", location=" + location + ", date=" + date
					+ ", time=" + time + "]";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}	

}


