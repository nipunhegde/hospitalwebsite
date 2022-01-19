package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String gender;
	private int age;
	private String specialistfield;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getSpecialistfield() {
		return specialistfield;
	}
	public void setSpecialistfield(String specialistfield) {
		this.specialistfield = specialistfield;
	}
	public Doctor() {}
	public Doctor(String name, String gender, int age, String specialistfield) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.specialistfield = specialistfield;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", specialistfield="
				+ specialistfield + "]";
	}
	

}
