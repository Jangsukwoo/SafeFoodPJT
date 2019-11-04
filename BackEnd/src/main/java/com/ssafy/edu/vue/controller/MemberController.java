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
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.EmployeeDto;
import com.ssafy.edu.vue.dto.MemberDto;
import com.ssafy.edu.vue.dto.QnADto;
import com.ssafy.edu.vue.help.BoolResult;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.EmployeeService;
import com.ssafy.edu.vue.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/ssafyvue/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)             // 크로싱 브라우져,... 
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")		//스웨거
public class MemberController {
	
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService  memberService; 

    @ApiOperation(value = "회원가입", response = NumberResult.class)
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<NumberResult> signUP(@RequestBody MemberDto newmember) throws Exception {
		logger.info("-------------회원가입-----------------------------");
		int total = memberService.signUP(newmember);
		NumberResult nr=new NumberResult();
		nr.setCount(total);
		nr.setName("signUP");
		nr.setState("succ");
		if (total==0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//알러지에 해당하는 원재료 번호 가져오고 
		//멤버 알러지 테이블에 인써트 
		//get rno => 대두 ,
		List<String> rnoList = memberService.getRno(newmember.getAllergylist());
		// rnoList에 있는 원재료 번호를 멤버 알러지 테이블에 인서트
		newmember.setAllergylist(rnoList);
		memberService.addAllergy(newmember);
		
		//성공여부 판단
		
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
    
    @ApiOperation(value = "회원보기", response = NumberResult.class)
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
		for(String str : newmember.getAllergylist()) {
			System.out.println(str + " ");
			System.out.println();
		}
		
		int total = memberService.updateMember(newmember);
		NumberResult nr=new NumberResult();
		nr.setCount(total);
		nr.setName("updateMember");
		nr.setState("succ");
		if (total==0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		List<String> rnoList = memberService.getRno(newmember.getAllergylist());
		// rnoList에 있는 원재료 번호를 멤버 알러지 테이블에 인서트
		newmember.setAllergylist(rnoList);
		memberService.deleteAllergy(newmember.getId());
		memberService.addAllergy(newmember);
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
		BoolResult br=new BoolResult();
		br.setCount(checkResult);
		br.setName("EXIST ID");
		br.setState("succ");
		if (!checkResult) {
			System.out.println("디비에 없는아이디");
			br.setName("possible");
			br.setState("fail");
			return new ResponseEntity<BoolResult>(br,HttpStatus.NO_CONTENT);
		}
		System.out.println("디비에 있는아이디");
		return new ResponseEntity<BoolResult>(br, HttpStatus.OK);
	}
    
}
