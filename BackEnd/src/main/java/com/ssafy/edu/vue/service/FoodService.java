package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.FoodDAO;
import com.ssafy.edu.vue.dto.FoodDto;

@Service
public class FoodService {
	
	@Autowired
	FoodDAO foodDao;

	@Transactional(readOnly=true)
	public List<FoodDto> searchAll() {
		return foodDao.searchAll();
	}
	@Transactional(readOnly=true)
	public List<FoodDto> findLikeFoods(String name) {
		return foodDao.findLikeFoods(name);
	}
	@Transactional(readOnly=true)
	public FoodDto getFood(int fno,String id) {
		return foodDao.getFood(fno,id);
	}
	@Transactional(readOnly=true)
	public List<FoodDto> getSafeFood(String id) {
		return foodDao.getSafeFood(id);
	}

}
