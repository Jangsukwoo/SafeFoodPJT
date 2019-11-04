package com.ssafy.edu.vue.controller;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.EmployeeDto;
import com.ssafy.edu.vue.dto.FoodDto;
import com.ssafy.edu.vue.service.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/ssafyvue/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)             // 크로싱 브라우져,... 
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")		//스웨거
public class FoodController {
	@Autowired
	private FoodService foodService;
	
	
	public static final Logger logger = LoggerFactory.getLogger(FoodController.class);
	
	@ApiOperation(value = "모든 식품 리스트", response = List.class)
	@RequestMapping(value="/getFoodList", method = RequestMethod.GET)
	public ResponseEntity<List<FoodDto>> getFoodList() {
		logger.info("-------------entireFoodList-----------------------------");
		List<FoodDto> foodlist = foodService.searchAll();
		if (foodlist.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		ResponseEntity re=new ResponseEntity<List<FoodDto>>(foodlist, HttpStatus.OK);
		System.out.println("re");
		System.out.println(re);
		return re;
	}
	@ApiOperation(value = "검색 식품을 반환 (keyUP)", response = List.class)
	@RequestMapping(value = "/findLikeFoods/{key}", method = RequestMethod.GET)
	public ResponseEntity<List<FoodDto>> findLikeFoods(@PathVariable String key) throws Exception {
		logger.info("-------------findLikeEmployees-----------------------------");
		List<FoodDto> findfoodlist = foodService.findLikeFoods(key);
		System.out.println(findfoodlist.toString());
		System.out.println(findfoodlist.size());
		if (findfoodlist.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FoodDto>>(findfoodlist, HttpStatus.OK);
	}
	
	@ApiOperation(value = "상품상세보기", response = List.class)
	@RequestMapping(value = "/getFood/{fno}/{id}", method = RequestMethod.GET)
	public ResponseEntity<FoodDto> getFood(@PathVariable int fno,@PathVariable String id) throws Exception {
		logger.info("-------------getFood-----------------------------");
		System.out.println(fno +" "+id+"도착~~~~~~~~~~~~~~~~~~~~");//로그인 안했으면 -1
		FoodDto food = foodService.getFood(fno,id);
		return new ResponseEntity<FoodDto>(food, HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원에게 안전한 먹거리 리스트", response = List.class)
	@RequestMapping(value = "/getSafeFood/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<FoodDto>> getSafeFood(@PathVariable String id) throws Exception {
		logger.info("-------------getSafeFood-----------------------------");
		List<FoodDto> Safefood = foodService.getSafeFood(id);
		System.out.println(Safefood);
		return new ResponseEntity<List<FoodDto>>(Safefood, HttpStatus.OK);
	}
	
	
	
	
}
