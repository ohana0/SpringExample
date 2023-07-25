package com.ohana0.spring.ex.jpa.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Student {
	
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String dreamJob;
	private Date createdAt;
	private Date updatedAt;

}
