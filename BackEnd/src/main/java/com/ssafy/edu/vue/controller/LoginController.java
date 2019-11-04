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
import com.ssafy.edu.vue.service.LoginService;
import com.ssafy.edu.vue.service.QnAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/ssafyvue/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)             // 크로싱 브라우져,... 
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")		//스웨거
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	 @ApiOperation(value = "로그인시도", response = NumberResult.class)
		@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
		public ResponseEntity<NumberResult> loginAction(@RequestBody MemberDto idpw) throws Exception {
			logger.info("1-------------LoginAction-----------------------------");
			NumberResult nr = new NumberResult();
			System.out.println("로그인시도");
			System.out.println(idpw.toString());
			int tryResult = loginService.login(idpw);
			nr.setCount(tryResult);
			nr.setName(idpw.getId());
			nr.setState("succ");
			if (tryResult==0) {	
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
		}
	 
	 @ApiOperation(value = "비밀번호찾기", response = NumberResult.class)
		@RequestMapping(value = "/findPassword", method = RequestMethod.POST)
		public ResponseEntity<String> findPassword(@RequestBody MemberDto trydata) throws Exception {
			logger.info("-------------비밀번호찾기-----------------------------");
			System.out.println("비번찾기");
			String getPassword = loginService.findPassword(trydata);
			System.out.println(getPassword);
			if (getPassword==null){
				//패스워드 못받음 
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<String>(getPassword, HttpStatus.OK);
		}
	 
	 
}
