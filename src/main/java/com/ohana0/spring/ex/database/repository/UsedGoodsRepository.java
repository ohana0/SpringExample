package com.ohana0.spring.ex.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ohana0.spring.ex.database.domain.UsedGoods;

//MyBatis Framework
//데이터베이스 쿼리 수행
@Repository
public interface UsedGoodsRepository {

	// used_goods 테이블 데이터 조회 리턴		
	public List<UsedGoods> selectUsedGoodsList();
	
}
