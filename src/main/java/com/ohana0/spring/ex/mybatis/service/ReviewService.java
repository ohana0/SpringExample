package com.ohana0.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohana0.spring.ex.mybatis.domain.Review;
import com.ohana0.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review getReview() {
		
		Review review = reviewRepository.selectReview(3);
		
		return review;
		
		
	}
	
	//storeId,menu,userName,point,review전달받고 저장
	
	public int addReview(int storeId
			,String menu
			,String userName
			,double point
			,String review) {
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		return count;
		
	}
	
	public int addReviewByObject(Review review) {
		
		int count = reviewRepository.insertReviewByObject(review);
		return count;
	}
	
	
}
