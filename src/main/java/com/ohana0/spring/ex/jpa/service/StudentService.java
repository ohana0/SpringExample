package com.ohana0.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohana0.spring.ex.jpa.domain.Student;
import com.ohana0.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public Student addStudent(String name, String phoneNumber,String email,String dreamJob) {
		
		Student student = Student.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build();
		student = studentRepository.save(student);
		return student;
	}
	
	public Student updateStudentDreamJob(int id,String dreamJob){
		//update대상이되는 행을 조회한다
		//조회된 객체에서 필요한 멤버변수를 수정한다.
		//해당 객체를 저장한다
		
		//findBy@@ : Optional<Student>이 리턴되는데, null일수도 있는 객체를 리턴할때 사용함
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		Student student = optionalStudent.orElse(null);//null이면 괄호안의것을 리턴하게됨.
		
		if(student != null) {
			student.toBuilder()
			.dreamJob(dreamJob)
			.build();
			
			student = studentRepository.save(student);
		}
		
		return student;

	}
	
	public void deleteStudent(int id) {
		//삭제대상의 객체를 얻어오고, 삭제한다
		Optional<Student> optionalStudent = studentRepository.findById(id);
		//람다식 문법
		optionalStudent.ifPresent(student -> studentRepository.delete(student));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
