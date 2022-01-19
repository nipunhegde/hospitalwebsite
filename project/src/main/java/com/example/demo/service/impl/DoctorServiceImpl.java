package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exeception.ResourceNotFoundExeception;
import com.example.demo.model.Doctor;
import com.example.demo.repo.DoctorRepo;
import com.example.demo.service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService{
	
	private DoctorRepo doctorrepo;
	

	public DoctorServiceImpl(DoctorRepo doctorrepo) {
		super();
		this.doctorrepo = doctorrepo;
	}


	@Override
	public Doctor savedoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorrepo.save(doctor);
	}


	@Override
	public List<Doctor> getallDoctors() {
		// TODO Auto-generated method stub
		return doctorrepo.findAll();
	}


	@Override
	public Doctor getdoctorbyid(int id) {
		// TODO Auto-generated method stub
		Optional<Doctor> doctor=doctorrepo.findById(id);
		if(doctor.isPresent()) {
			return doctor.get();
		}
		else
		{
			throw new ResourceNotFoundExeception("doctor", "id", id);
		}
		//return doctorrepo.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("doctor", "id",id));
	}


	@Override
	public Doctor updatedoctor(Doctor doctor, int id) {
		// TODO Auto-generated method stub
		Doctor existingdoctor=doctorrepo.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("doctor", "id",id));
		existingdoctor.setName(doctor.getName());
		existingdoctor.setAge(doctor.getAge());
		existingdoctor.setGender(doctor.getGender());
		existingdoctor.setSpecialistfield(doctor.getSpecialistfield());
		doctorrepo.save(existingdoctor);
		return existingdoctor;
	}


	

	@Override
	public void deletedoctor(int id) {
		// TODO Auto-generated method stub
		doctorrepo.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("doctor", "id",id));
		
		doctorrepo.deleteById(id);
		
	}

}
