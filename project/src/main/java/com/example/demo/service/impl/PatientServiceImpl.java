package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exeception.ResourceNotFoundExeception;

import com.example.demo.model.Patient;

import com.example.demo.repo.PatientRepo;
import com.example.demo.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService {
	private PatientRepo patientrepo;

	public PatientServiceImpl(PatientRepo patientrepo) {
		super();
		this.patientrepo = patientrepo;
	}

	@Override
	public Patient savepatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientrepo.save(patient);
		
	}

	@Override
	public List<Patient> getallPatients() {
		// TODO Auto-generated method stub
		return patientrepo.findAll();
	}

	@Override
	public Patient getpatientbyid(int id) {
		// TODO Auto-generated method stub
		return patientrepo.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("patient", "id",id));
	}

	@Override
	public Patient updatepatient(Patient patient, int id) {
		// TODO Auto-generated method stub
		Patient existingpatient=patientrepo.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("patient", "id",id));
		existingpatient.setFirst_Name(patient.getFirst_Name() );
		existingpatient.setLast_Name(patient.getLast_Name());
		existingpatient.setGender(patient.getGender());
		existingpatient.setAge(patient.getAge());
		patientrepo.save(existingpatient);
		return existingpatient;
	}

	@Override
	public void deletepatient(int id) {
		// TODO Auto-generated method stub
	patientrepo.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("patient", "id",id));
		
		patientrepo.deleteById(id);
		
		
	}

	
}
