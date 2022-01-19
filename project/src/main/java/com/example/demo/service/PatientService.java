package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Patient;

public interface PatientService {
	Patient savepatient (Patient patient);
	List<Patient> getallPatients();
	Patient getpatientbyid(int id);
	Patient updatepatient(Patient patient,int id);
	void deletepatient(int id);

}
