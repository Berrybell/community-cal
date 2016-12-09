package com.example.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Event> events;
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category() {
		
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long id) {
		this.categoryid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setBooks(List<Event> books) {
		this.events = books;
	}

	@Override
	public String toString() {
		return "Category [id=" + categoryid + ", type=" + name + "]";
	}

}
