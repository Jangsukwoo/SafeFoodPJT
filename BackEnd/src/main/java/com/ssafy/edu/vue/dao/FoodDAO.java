package com.ssafy.edu.vue.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.FoodDto;


@Repository
public class FoodDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<FoodDto> searchAll() {
		List<FoodDto> list = sqlSession.selectList("food.AllFood");
		for(FoodDto food : list) {
			food.setMaterialList(getMatrial(food.getCode()));
		}
		return list;
	}

	public List<FoodDto> findLikeFoods(String name) {
		if(name == "" || name == null) { //찾는 이름이 없으면
			List<FoodDto> list = searchAll();
			for(FoodDto food : list) {
				food.setMaterialList(getMatrial(food.getCode()));
			}
			return list;
		}
		else { //찾는 이름이 있으면 해당 리스트를 반환해준다.
			List<FoodDto> list = sqlSession.selectList("food.search", name);
			for(FoodDto food : list) {
				food.setMaterialList(getMatrial(food.getCode()));
			}
			return list;
		}
	}
	
	public List<String> getMatrial(int fno){//fno(식품번호)에 해당하는 원재료들 반환
		return sqlSession.selectList("food.getMetrial", fno);
	}

	public FoodDto getFood(int fno,String id) {//식품가져오기
		
		
		boolean flag = true;
		FoodDto resultFood = sqlSession.selectOne("food.getFood",fno);
		List<String> rnoList1 = sqlSession.selectList("food.getRno1", fno);//식품에 해당하는 원재료번호 = rnoList1
		List<String> rnoList2 = sqlSession.selectList("food.getRno2",id);//회원아이디에 해당하는 원재료번호 = rnoList2
		List<String> materialList = new ArrayList<>(); //현재 식품의 모든 원재료 정보
		List<String> allergyList = new ArrayList<>(); //알러지에 해당하는 원재료 정보
		List<String> noneallergyList = new ArrayList<>();//알러지에 해당하지않는 원재료 정보
		
		for (String rno : rnoList1) { //식품의 전체 원재료
			String material = sqlSession.selectOne("food.getRname",rno);
			materialList.add(material);
		}			
		
		//rnoList1,rnoList2 교집합은 알러지에 해당하는 원재료임
		for(String rno1 : rnoList1) {
			flag = true;
			for(String rno2 : rnoList2){
				if(rno1.equals(rno2)) {
					//회원이 보유한 알러지가 포함된 식품 원재료 리스트에 추가
					flag = false;
					allergyList.add(sqlSession.selectOne("food.getRname",rno1));
					break;
				}
			}
			if(flag) noneallergyList.add(sqlSession.selectOne("food.getRname",rno1));
		}
		//회원이 보유한 알러지가 미포함된 식품 원재료 리스트 

		resultFood.setMaterialList(materialList);
		resultFood.setAllergyList(allergyList);
		resultFood.setNoneallergyList(noneallergyList);
		
		return resultFood;
	}

	public List<FoodDto> getSafeFood(String id) {
		return sqlSession.selectList("food.getSafeFoodlist",id);
	}
}
