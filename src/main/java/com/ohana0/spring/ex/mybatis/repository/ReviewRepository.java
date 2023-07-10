package com.ohana0.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ohana0.spring.ex.mybatis.domain.Review;

@Repository
public interface ReviewRepository {
	public Review selectReview(@Param("id") int id);
	
	//storeId,menu,userName,point,review전달받고 저장
	public int insertReview(
			@Param("storeId") int storeId
			,@Param("menu") String menu
			,@Param("userName") String userName
			,@Param("point") double point
			,@Param("review") String review);
	
	public int insertReviewByObject(Review review);
	

}
