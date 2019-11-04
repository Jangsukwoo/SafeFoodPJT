package com.ssafy.edu.vue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.LoginDAO;
import com.ssafy.edu.vue.dto.MemberDto;
@Service
public class LoginService {

	@Autowired
	LoginDAO loginDao;
	
	@Transactional(readOnly=true)
	public int login(MemberDto idpw) {
		return loginDao.login(idpw);
	}

	@Transactional(readOnly=true)
	public String findPassword(MemberDto trydata) {
		return loginDao.findPassword(trydata);
	}

}
