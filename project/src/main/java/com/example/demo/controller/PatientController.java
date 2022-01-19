package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
@RestController
@RequestMapping("/vs/api/patient")
public class PatientController {
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	// create doc build api 
		@PostMapping()
		public ResponseEntity<Patient> savepatient(@RequestBody Patient patient){
			return new ResponseEntity<Patient>(patientService.savepatient(patient), HttpStatus.CREATED);
		}
		//get all rest api
		@GetMapping
		public List<Patient> getallPatient(){
			return patientService.getallPatients();
			
		}
		//get doctor by id
		@GetMapping("{id}")
		public ResponseEntity<Patient> getpatientbyid(@PathVariable("id")int patid){
			return new ResponseEntity<Patient>(patientService.getpatientbyid(patid),HttpStatus.OK);    
			
		}
		
		//update doc id
		@PutMapping("{id}")
		public ResponseEntity<Patient> updatepatient(@PathVariable("id")int id       ,@RequestBody Patient patient ){
			return new ResponseEntity<Patient>(patientService.updatepatient(patient, id), HttpStatus.OK);
		}
		
		//delete doc
		@DeleteMapping("{id}")
		public ResponseEntity<String> deletepatient(@PathVariable("id")int id ){
			patientService.deletepatient(id);
			return new ResponseEntity<String>("deleted success", HttpStatus.OK);
		}

}
