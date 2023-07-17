package com.ohana0.spring.ex.jsp.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ohana0.spring.ex.jsp.domain.User;

@Repository
public interface UserRepository {
	
	//사용자 정보 전달받고 insert
	public int insertUser(
			@Param("name") String name
			,@Param("birthday") String birthday
			,@Param("email") String email
			,@Param("introduce") String introduce);
	
	public User selectLastUser();
	public int  insertUserByObject(User user);

}
