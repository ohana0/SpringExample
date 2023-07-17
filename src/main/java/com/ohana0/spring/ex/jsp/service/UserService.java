package com.ohana0.spring.ex.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohana0.spring.ex.jsp.domain.User;
import com.ohana0.spring.ex.jsp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public int addUser(String name,String birthday,String email,String introduce){
		int count = userRepository.insertUser(name, birthday, email, introduce);
		 
		return count;
	}
	
	//가장 최근 등록된 사용자정보 얻기
	public User getLastUser() {
		User user = userRepository.selectLastUser();
		return user;
	}
	public int addUserByObject(User user) {
		int count = userRepository.insertUserByObject(user);
		
		return count;
	}
	
	
	
}
