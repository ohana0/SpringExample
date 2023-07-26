package com.ohana0.spring.ex.jpa.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor//생성자 기본설정
@AllArgsConstructor//모든 멤버변수를 변수로 받음
@Builder(toBuilder=true)
@Getter
@Table(name="new_student")//어떤DB랑 연결되는지
@Entity//entity class
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="phoneNumber")//멤버변수에 camel case가 적용되어있는 경우 변수이름과 매칭 
	private String phoneNumber;
	
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp//자동으로 현재시간이 입력된다.
	@Column(name="createdAt", updatable=false)//updatable=false: 최초에 생성될때 이후에 업데이트되지않음.
	private ZonedDateTime createdAt; //ZonedDateTime: 시차개념을 탑재한 시간 클래스
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private ZonedDateTime updatedAt;

}
