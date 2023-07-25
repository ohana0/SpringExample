package com.ohana0.spring.ex.jpa;

import org.springframework.stereotype.Controller;

import com.ohana0.spring.ex.jpa.domain.Student;

@Controller
public class StudentController {
	
	public void test() {
		Student student = Student.builder()
				.name("김인규")
				.phoneNumber("010-111-222")
				.build();
		student.getName();
	}
	
	
}
