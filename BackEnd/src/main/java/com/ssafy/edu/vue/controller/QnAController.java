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
import com.ssafy.edu.vue.dto.QnADto;
import com.ssafy.edu.vue.help.BoolResult;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.EmployeeService;
import com.ssafy.edu.vue.service.QnAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/ssafyvue/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)             // 크로싱 브라우져,... 
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")		//스웨거
public class QnAController {
	@Autowired
	private QnAService qnaService;
	public static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	
	@ApiOperation(value = "모든 QnA 정보를 반환한다.", response = List.class)
	@RequestMapping(value="/getQnAList", method = RequestMethod.GET)
	public ResponseEntity<List<QnADto>> getQnAList() {
		logger.info("-------------entireQnAList-----------------------------"+new Date());
		List<QnADto> qnas = qnaService.entireList();
		System.out.println(qnas);
		if (qnas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		ResponseEntity re=new ResponseEntity<List<QnADto>>(qnas, HttpStatus.OK);
		System.out.println("re");
		System.out.println(re);
		return re;
	}
	
	
	@ApiOperation(value = "QnA 질문등록하기", response = NumberResult.class)
   	@RequestMapping(value = "/AddQnA", method = RequestMethod.POST)
   	public ResponseEntity<NumberResult> addQnA(@RequestBody QnADto dto) throws Exception {
   		logger.info("-------------QnA 질문 등록-----------------------------");
   		NumberResult nr=new NumberResult();
   		nr.setName("addQuestion");
   		nr.setState("succ");
   		if (qnaService.addQnA(dto)==0) {
   	   		nr.setName("addQuestion");
   	   		nr.setState("fail");
   			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   		}
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   	}
	
	
	@ApiOperation(value = "QnA 답글등록하기", response = NumberResult.class)
   	@RequestMapping(value = "/AddAnswer", method = RequestMethod.POST)
   	public ResponseEntity<NumberResult> addAnswer(@RequestBody QnADto dto) throws Exception {
   		logger.info("-------------QnA 답글 등록-----------------------------");
   		NumberResult nr=new NumberResult();
   		nr.setName("addAnswer");
   		nr.setState("succ");
   		if (qnaService.addAnswer(dto)==0) {
   	   		nr.setState("fail");
   			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   		}
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   	}
	
	  @ApiOperation(value = "QnA상세보기", response = NumberResult.class)
		@RequestMapping(value = "/getQnA/{qno}", method = RequestMethod.GET)
		public ResponseEntity<QnADto> getQnA(@PathVariable int qno) throws Exception {
			logger.info("-------------getQnA-----------------------------"+new Date());
			QnADto qna = qnaService.getQnA(qno);
			if (qna==null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			System.out.println("상세보기결과 공지사항객체"+qna);
			return new ResponseEntity<QnADto>(qna, HttpStatus.OK);
		}
	  
	  @ApiOperation(value = "QnA 삭제", response = NumberResult.class)
		@RequestMapping(value = "/deleteQnA/{qno}", method = RequestMethod.GET)
		public ResponseEntity<NumberResult> deleteQnA(@PathVariable int qno) throws Exception {
			logger.info("1-------------deleteQnA-----------------------------");
			NumberResult nr = new NumberResult();
			int deleteResult = qnaService.deleteQnA(qno);
			nr.setCount(deleteResult);
			nr.setName("deleteEmployee");
			nr.setState("succ");
			
			if (deleteResult==0) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
		}
	
}
