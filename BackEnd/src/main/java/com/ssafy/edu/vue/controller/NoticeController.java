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
import com.ssafy.edu.vue.dto.NoticeDto;
import com.ssafy.edu.vue.dto.QnADto;
import com.ssafy.edu.vue.help.BoolResult;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.EmployeeService;
import com.ssafy.edu.vue.service.NoticeService;
import com.ssafy.edu.vue.service.QnAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/ssafyvue/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)             // 크로싱 브라우져,... 
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")		//스웨거
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	
	public static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@ApiOperation(value = "모든 공지사항 정보를 반환한다.", response = List.class)
	@RequestMapping(value="/entireNoticelist", method = RequestMethod.GET)
	public ResponseEntity<List<NoticeDto>> getNoticeList() {
		logger.info("-------------entireNoticeList-----------------------------");
		List<NoticeDto> noticelist = noticeService.entireList();
		if (noticelist.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		ResponseEntity<List<NoticeDto>> re=new ResponseEntity<List<NoticeDto>>(noticelist, HttpStatus.OK);
		return re;
	}
	
	   @ApiOperation(value = "공지사항등록", response = NumberResult.class)
		@RequestMapping(value = "/insertNotice", method = RequestMethod.POST)
		public ResponseEntity<NumberResult> insertNotice(@RequestBody NoticeDto newNotice) throws Exception {
			logger.info("-------------공지사항등록-----------------------------");
			int total = noticeService.insertNotice(newNotice);
			NumberResult nr=new NumberResult();
			nr.setCount(total);
			nr.setName("noticeInsert");
			nr.setState("succ");
			if (total==0) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
		}
	   
	    @ApiOperation(value = "공지사항보기", response = NumberResult.class)
		@RequestMapping(value = "/getNotice/{noticeNO}", method = RequestMethod.GET)
		public ResponseEntity<NoticeDto> getNotice(@PathVariable int noticeNO) throws Exception {
			logger.info("-------------공지사항보기-----------------------------");
			NoticeDto notcie = noticeService.getNotice(noticeNO);
			ResponseEntity<NoticeDto> re=new ResponseEntity<NoticeDto>(notcie, HttpStatus.OK);
			return re;
		}
	    
		   
	    @ApiOperation(value = "공지사항수정", response = NumberResult.class)
		@RequestMapping(value = "/updateNotice", method = RequestMethod.POST)
		public ResponseEntity<NumberResult> updateNotice(@RequestBody NoticeDto newNotice) throws Exception {
			logger.info("-------------공지사항수정-----------------------------");
			int total = noticeService.updateNotice(newNotice);
			NumberResult nr=new NumberResult();
			nr.setCount(total);
			nr.setName("updateNotice");
			nr.setState("succ");
			if (total==0) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
		}
	    
	    @ApiOperation(value = "공지사항삭제", response = NumberResult.class)
		@RequestMapping(value = "/deleteNotice/{id}", method = RequestMethod.POST)
		public ResponseEntity<NumberResult> deleteNotice(@PathVariable int noticeNO) throws Exception {
	    	logger.info("-------------공지사항삭제-----------------------------");
	    	int total = noticeService.deleteNotice(noticeNO);
			NumberResult nr=new NumberResult();
			nr.setCount(total);
			nr.setName("deleteNotice");
			nr.setState("succ");
			if (total==0) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
		}
	   
	
}
