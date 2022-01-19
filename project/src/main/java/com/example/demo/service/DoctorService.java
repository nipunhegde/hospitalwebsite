package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Doctor;

public interface DoctorService {
	Doctor savedoctor (Doctor doctor);
	List<Doctor> getallDoctors();
	Doctor getdoctorbyid(int id);
	Doctor updatedoctor(Doctor doctor,int id);
	void deletedoctor(int id);

}
