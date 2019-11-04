package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.LoginDAO;
import com.ssafy.edu.vue.dao.MemberDAO;
import com.ssafy.edu.vue.dto.MemberDto;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDao;
	
	public int signUP(MemberDto newmember) {
		return memberDao.signUP(newmember);
	}

	public int updateMember(MemberDto newmember) {
		return memberDao.updateMember(newmember);
	}

	@Transactional(readOnly=true)
	public MemberDto getMember(String id) {
		return memberDao.getMember(id);
	}

	@Transactional(readOnly=true)
	public int deleteMember(String id) {
		return memberDao.deleteMember(id);
	}

	@Transactional(readOnly=true)
	public boolean checkID(String id) {
		return memberDao.checkID(id);
	}

	public List<String> getRno(List<String> allergyList) {
		return memberDao.getRno(allergyList);
	}

	public void addAllergy(MemberDto newmember) {
		memberDao.addAllergy(newmember);
		return;
	}

	public void deleteAllergy(String id) {
		memberDao.deleteAllergy(id);
		return ;
	}

}
