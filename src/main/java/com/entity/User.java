package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "XUser")
public class User {

	@Column(name="ID")
    @Id       
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@Column(name = "Name")
	private String name;
	
	public User(String name) {
		this.name = name;
	}

	public User() {	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
