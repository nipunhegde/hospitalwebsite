package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Patient;


import com.example.demo.repo.PatientRepo;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;





@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ProjectApplicationTests {

	@Autowired
	PatientRepo pRepo;
	
	
	
	@Test
	@Order(1)
	public void testCreate () {
		Patient d = new Patient();
		d.setId(1);
		d.setFirst_Name("ajay");
		d.setGender("male");
		d.setAge(34);
		d.setLast_Name("sharma");
		pRepo.save(d);
		assertNotNull(( pRepo).findById(1).get());
	}
		
	

	private void assertNotNull(Patient patient) {
		// TODO Auto-generated method stub
		
	}



	@Test
	@Order(2)
	public void testReadAll () {
		List<Patient> list = pRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
		
	@Test
	@Order(3)
	public void testRead () {
		Patient doc = pRepo.findById(1).get();
		assertEquals("ajay",doc.getFirst_Name());
	}
		
	private void assertEquals(String string, String First_name) {
		// TODO Auto-generated method stub
		
	}

	@Test
	@Order(4)
	public void testUpdate () {
		Patient p = pRepo.findById(1).get();
		p.setAge(32);
		pRepo.save(p);
		assertNotEquals(30, pRepo.findById(1).get().getAge());
	}
		
	private void assertNotEquals(int i, int age) {
		// TODO Auto-generated method stub
		
	}

	@Test
	@Order(5)
	public void testDelete () {
		pRepo.deleteById(1);
		assertThat(pRepo.existsById(1)).isFalse();
	}
}



