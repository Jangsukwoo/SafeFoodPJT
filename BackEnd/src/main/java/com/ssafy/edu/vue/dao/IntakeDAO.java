package com.ssafy.edu.vue.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.BestFoodDto;
import com.ssafy.edu.vue.dto.IntakeDataDto;
import com.ssafy.edu.vue.dto.IntakeFoodDto;
import com.ssafy.edu.vue.dto.IntakeInfoDto;
import com.ssafy.edu.vue.dto.IntakeWeekDataDto;

@Repository
public class IntakeDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	public int insertIntakeInfo(IntakeInfoDto newIntakeInfo) {
		return sqlSession.insert("intake.insertIntakeInfo",newIntakeInfo);
	}

	public IntakeDataDto getIntakeData(IntakeInfoDto IntakeInfo) {
		IntakeDataDto resultData = sqlSession.selectOne("intake.getIntakeData",IntakeInfo);
		 System.out.println(resultData.toString());
		 List<IntakeFoodDto> intakefoodlist = sqlSession.selectList("intake.getIntakeFoodlist",IntakeInfo);
		 resultData.setIntakefood(intakefoodlist);
		return resultData;
	}

	public IntakeWeekDataDto getIntakeWeekData(String id) {
		sqlSession.update("intake.updateday");//오늘날짜로 갱신하고
	
		IntakeWeekDataDto ret= sqlSession.selectOne("intake.getweek");//주 날짜 
		
		ret.setId(id);	
		ret.setSunday(ret.getSunday().replace('/', '-'));
		ret.setMonday(ret.getMonday().replace('/', '-'));
		ret.setTuesday(ret.getTuesday().replace('/', '-'));
		ret.setWednesday(ret.getWednesday().replace('/', '-'));
		ret.setThursday(ret.getThursday().replace('/', '-'));
		ret.setFriday(ret.getFriday().replace('/', '-'));
		ret.setSaturday(ret.getSaturday().replace('/', '-'));
		
		String today = sqlSession.selectOne("intake.getTodayCalory",ret);
		String sunday = sqlSession.selectOne("intake.getSundayCalory", ret);
		String monday = sqlSession.selectOne("intake.getMondayCalory", ret);
		String tuesday=sqlSession.selectOne("intake.getTuesdayCalory", ret);
		String wednesday=sqlSession.selectOne("intake.getWednesdayCalory", ret);
		String thursday=sqlSession.selectOne("intake.getThursdayCalory", ret);
		String friday=sqlSession.selectOne("intake.getFridayCalory", ret);
		String saturday=sqlSession.selectOne("intake.getSaturdayCalory", ret);

		if(today!=null) ret.setTodaycalory(Double.parseDouble(today));
		else ret.setTodaycalory(0.0);
		
		if(sunday!=null) ret.setSundaycalory(Double.parseDouble(sunday));
		else ret.setSundaycalory(0.0);
		
		if(monday!=null) ret.setMondaycalory(Double.parseDouble(monday));
		else ret.setMondaycalory(0.0);
		
		if(tuesday!=null) ret.setTuesdaycalory(Double.parseDouble(tuesday));
		else ret.setTuesdaycalory(0.0);
		
		if(wednesday!=null) ret.setWednesdaycalory(Double.parseDouble(wednesday));
		else ret.setWednesdaycalory(0.0);
		
		if(thursday!=null) ret.setThursdaycalory(Double.parseDouble(thursday));
		else ret.setThursdaycalory(0.0);
		
		if(friday!=null) ret.setFridaycalory(Double.parseDouble(friday));
		else ret.setFridaycalory(0.0);
		
		if(saturday!=null) ret.setSaturdaycalory(Double.parseDouble(saturday));
		else ret.setFridaycalory(0.0);
		
		return ret;
	}

	public List<BestFoodDto> getBestFoodlist() {
		return sqlSession.selectList("intake.getBestFoodList");
	}

}
