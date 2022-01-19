package com.example.demo.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Patient {
	@Id
	
	private int id;
	private String First_Name;
	private String Last_Name;
	private String gender;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Patient() {
		
	}
	public Patient(String first_Name, String last_Name, String gender, int age) {
		super();
		First_Name = first_Name;
		Last_Name = last_Name;
		this.gender = gender;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", gender=" + gender
				+ ", age=" + age + "]";
	}

}
