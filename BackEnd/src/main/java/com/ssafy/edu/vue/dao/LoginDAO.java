package com.ssafy.edu.vue.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.MemberDto;

@Repository
public class LoginDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int login(MemberDto idpw) {
		// TODO Auto-generated method stub
		String tmp = sqlSession.selectOne("member.login",idpw);
		System.out.println(tmp);
		if(tmp!=null) {
			System.out.println("있음");
			return 1;
		}
		return 0;
	}

	public String findPassword(MemberDto trydata) {
		String password = sqlSession.selectOne("member.findpassword",trydata);
		if(password==null) return null;
		else return password;
	}

}
