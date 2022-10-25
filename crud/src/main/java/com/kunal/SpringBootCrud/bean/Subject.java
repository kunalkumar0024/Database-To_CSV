package com.kunal.SpringBootCrud.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	@Id
	private String id;
	private String name;
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}
	public Subject() {
		super();
	}
	public Subject(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
