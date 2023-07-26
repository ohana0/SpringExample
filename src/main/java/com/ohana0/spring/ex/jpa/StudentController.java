package com.ohana0.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohana0.spring.ex.jpa.domain.Student;
import com.ohana0.spring.ex.jpa.service.StudentService;
@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {
		
		String name="김인규";
		String phoneNumber = "010-1234-5678";
		String email = "lecture@hagulu.com";
		String dreamJob = "개발자";
		
		Student student = studentService.addStudent(name, phoneNumber, email, dreamJob);
		
		return student;
	}

	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		// id가 3인 데이터의 장래희망을 강사로 변경
		Student student = studentService.updateStudentDreamJob(3,"강사");
		return student;
		
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent() {
		//id가 3인 데이터를 삭제
		studentService.deleteStudent(3);
		return "삭제 성공";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@ResponseBody
	@GetMapping("/lombok/test")
	public void test() {
		Student student = Student.builder()
				.name("김인규")
				.dreamJob("개발자")
				.phoneNumber("010-111-222")
				.build();
		System.out.println(student);
	}
		
	
}
