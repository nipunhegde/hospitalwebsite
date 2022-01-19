package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;


@RestController
@RequestMapping("/vs/api/doctor")
@CrossOrigin(origins="*")
public class DoctorController {


	private DoctorService doctorService;
	
	
public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}


// create doc build api 
	@PostMapping()
	public ResponseEntity<Doctor> savedoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.savedoctor(doctor), HttpStatus.CREATED);
	}
	//get all rest api
	@GetMapping
	public List<Doctor> getallDoctor(){
		return doctorService.getallDoctors();
		
	}
	//get doctor by id
	@GetMapping("{id}")
	public ResponseEntity<Doctor> getdoctorbyid(@PathVariable("id")int docid){
		return new ResponseEntity<Doctor>(doctorService.getdoctorbyid(docid),HttpStatus.OK);    
		
	}
	
	//update doc id
	@PutMapping("{id}")
	public ResponseEntity<Doctor> updatedoctor(@PathVariable("id")int id       ,@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.updatedoctor(doctor, id), HttpStatus.OK);
	}
	
	//delete doc
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletedoctor(@PathVariable("id")int id ){
		doctorService.deletedoctor(id);
		return new ResponseEntity<String>("deleted success", HttpStatus.OK);
	}

}