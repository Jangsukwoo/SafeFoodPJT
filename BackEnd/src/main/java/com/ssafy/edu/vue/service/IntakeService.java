package com.ssafy.edu.vue.service;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.IntakeDAO;
import com.ssafy.edu.vue.dto.BestFoodDto;
import com.ssafy.edu.vue.dto.IntakeDataDto;
import com.ssafy.edu.vue.dto.IntakeInfoDto;
import com.ssafy.edu.vue.dto.IntakeWeekDataDto;
import com.ssafy.edu.vue.dto.MemberDto;

@Service
public class IntakeService {

	@Autowired
	IntakeDAO intakeDao;

	public int insertIntakeInfo(IntakeInfoDto newIntakeInfo) {
		return intakeDao.insertIntakeInfo(newIntakeInfo);
	}

	@Transactional(readOnly =true)
	public IntakeDataDto getIntakeData(IntakeInfoDto IntakeInfo) {
		return intakeDao.getIntakeData(IntakeInfo);
	}

	public IntakeWeekDataDto getIntakeWeekData(String id) {
		System.out.println("서비스~~~~~~~~~~");
		return intakeDao.getIntakeWeekData(id);
	}

	public List<BestFoodDto> getBestFoodlist() {
		return intakeDao.getBestFoodlist();
	}
}
