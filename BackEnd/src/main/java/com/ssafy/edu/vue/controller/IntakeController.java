package com.ssafy.edu.vue.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.BestFoodDto;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.EmployeeDto;
import com.ssafy.edu.vue.dto.IntakeDataDto;
import com.ssafy.edu.vue.dto.IntakeInfoDto;
import com.ssafy.edu.vue.dto.IntakeWeekDataDto;
import com.ssafy.edu.vue.dto.MemberDto;
import com.ssafy.edu.vue.dto.QnADto;
import com.ssafy.edu.vue.help.BoolResult;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.EmployeeService;
import com.ssafy.edu.vue.service.IntakeService;
import com.ssafy.edu.vue.service.MemberService;
import com.ssafy.edu.vue.service.WishProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/ssafyvue/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)             // 크로싱 브라우져,... 
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")		//스웨거
public class IntakeController {
	
	public static final Logger logger = LoggerFactory.getLogger(IntakeController.class);
	
	@Autowired
	private IntakeService  intakeService; 

    @ApiOperation(value = "섭취식품등록", response = NumberResult.class)
	@RequestMapping(value = "/insertIntakeInfo", method = RequestMethod.POST)
	public ResponseEntity<NumberResult> insertIntakeInfo(@RequestBody IntakeInfoDto newIntakeInfo) throws Exception {
		logger.info("-------------섭취식품등록-----------------------------");
		int total = intakeService.insertIntakeInfo(newIntakeInfo);
		NumberResult nr=new NumberResult();
		nr.setCount(total);
		nr.setName("insertIntakeInformation");
		nr.setState("succ");
		if (total==0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
    
    
    @ApiOperation(value = "섭취량정보", response = NumberResult.class)
	@RequestMapping(value = "/getIntakeData", method = RequestMethod.POST)
	public ResponseEntity<IntakeDataDto> getIntakeData(@RequestBody IntakeInfoDto IntakeInfo) throws Exception {
		logger.info("------------섭취량정보데이터호출-----------------------------");
		IntakeDataDto Intakedata = intakeService.getIntakeData(IntakeInfo);
		ResponseEntity<IntakeDataDto> re=new ResponseEntity<IntakeDataDto>(Intakedata, HttpStatus.OK);
		return re;
	}
    @ApiOperation(value = "주간섭취량정보", response = NumberResult.class)
	@RequestMapping(value = "/getIntakeWeekData/{id}", method = RequestMethod.GET)
	public ResponseEntity<IntakeWeekDataDto> getIntakeWeekData(@PathVariable String id) throws Exception {
		logger.info("------------주간섭취량정보-----------------------------");
		IntakeWeekDataDto IntakeWeekdata = intakeService.getIntakeWeekData(id);
		System.out.println(IntakeWeekdata.toString());
		ResponseEntity<IntakeWeekDataDto> re=new ResponseEntity<IntakeWeekDataDto>(IntakeWeekdata, HttpStatus.OK);
		return re;
	}
    
    @ApiOperation(value = "베스트섭취량리스트", response = List.class)
	@RequestMapping(value = "/getBestFoodlist", method = RequestMethod.GET)
	public ResponseEntity<List<BestFoodDto>> getBestFoodlist() throws Exception {
		logger.info("------------베스트섭취량리스트-----------------------------");
		List<BestFoodDto> bestFoodlist = intakeService.getBestFoodlist();
		ResponseEntity<List<BestFoodDto>> re=new ResponseEntity<List<BestFoodDto>>(bestFoodlist, HttpStatus.OK);
		return re;
	}
    
    
    /*
    /*@ApiOperation(value = "회원보기", response = NumberResult.class)
	@RequestMapping(value = "/getMember/{id}", method = RequestMethod.GET)
	public ResponseEntity<MemberDto> getMember(@PathVariable String id) throws Exception {
		logger.info("-------------회원정보보기-----------------------------");
		MemberDto member = memberService.getMember(id);
		System.out.println(member.toString());
		ResponseEntity<MemberDto> re=new ResponseEntity<MemberDto>(member, HttpStatus.OK);
		return re;
	}
    
    @ApiOperation(value = "회원수정", response = NumberResult.class)
	@RequestMapping(value = "/updateMember", method = RequestMethod.POST)
	public ResponseEntity<NumberResult> updateMember(@RequestBody MemberDto newmember) throws Exception {
		logger.info("-------------회원정보수정-----------------------------");
		int total = memberService.updateMember(newmember);
		NumberResult nr=new NumberResult();
		nr.setCount(total);
		nr.setName("updateMember");
		nr.setState("succ");
		if (total==0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
	
    @ApiOperation(value = "회원삭제", response = NumberResult.class)
	@RequestMapping(value = "/deleteMember/{id}", method = RequestMethod.POST)
	public ResponseEntity<NumberResult> deleteMember(@PathVariable String id) throws Exception {
    	int total = memberService.deleteMember(id);
		NumberResult nr=new NumberResult();
		nr.setCount(total);
		nr.setName("deleteMember");
		nr.setState("succ");
		if (total==0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
    
    @ApiOperation(value = "회원존재체크", response = NumberResult.class)
	@RequestMapping(value = "/checkID/{id}", method = RequestMethod.GET)
	public ResponseEntity<BoolResult> checkID(@PathVariable String id) throws Exception {
    	boolean checkResult = memberService.checkID(id);
    	System.out.println(id);
    	System.out.println(checkResult);
		BoolResult br=new BoolResult();
		br.setCount(checkResult);
		br.setName("EXIST ID");
		br.setState("succ");
		if (!checkResult) {
			System.out.println("if안쪽");
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(br, HttpStatus.OK);
	}*/
    
}
