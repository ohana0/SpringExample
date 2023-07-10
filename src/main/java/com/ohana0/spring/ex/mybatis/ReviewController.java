package com.ohana0.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohana0.spring.ex.mybatis.domain.Review;
import com.ohana0.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@ResponseBody
	@RequestMapping("/review")
	public Review review() {
		Review review = reviewService.getReview();
		
		return review;
	}
	//새로운 리뷰를 등록하는 기능
	@ResponseBody
	@RequestMapping("/ex02")
	public String createReview() {
		//4,콤비네이션 피자,김인규,4.5,할인도 많이 받고 잘 먹었어요.
		//2,뿌링클,김인규,4.0,역시 뿌링클은 진리입니다.
		int count =reviewService.addReview(4, "콤비네이션 피자", "김인규", 4.5, "할인도 많이 받고 잘 먹었어요,");
		return "입력 성공:" + count;
	}
	@ResponseBody
	@RequestMapping("/ex03")
	public String createReviewByObject() {
		//2,뿌링클,김인규,4.0,역시 뿌링클은 진리입니다.
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.5);
		review.setReview("역시 뿌링클은 진리입니다.");
		int count = reviewService.addReviewByObject(review);
		return "입력성공: " + count;
	}

	
	
	
	
}
