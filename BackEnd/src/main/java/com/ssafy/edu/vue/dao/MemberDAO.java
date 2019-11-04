package com.ssafy.edu.vue.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.MemberDto;

@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int signUP(MemberDto newmember) {
		System.out.println(newmember.toString());
		return sqlSession.insert("member.signup",newmember);
	}

	public int updateMember(MemberDto newmember) {
		return sqlSession.update("member.update",newmember);
	}

	public MemberDto getMember(String id) {
		return sqlSession.selectOne("member.getmember",id);
	}

	public int deleteMember(String id) {
		return sqlSession.delete("member.delete",id);
	}

	public boolean checkID(String id) {
		String queryResult = sqlSession.selectOne("member.checkID",id);
		if(queryResult==null) return false;
		else return true;//DB 아이디 있으면 트루
	}

	public List<String> getRno(List<String> allergyList) {
		List<String> ret = new ArrayList<>();
		for(String rname : allergyList) {
			List<String> list = sqlSession.selectList("member.getRno", rname);
			for(String str : list) {
				ret.add(str);
			}
		}
		return ret;
	}

	public void addAllergy(MemberDto newmember) {
		for(String rno : newmember.getAllergylist()) {
			newmember.setTmp(rno);
			sqlSession.insert("member.addtmpallergy", newmember);			
		}
		
		//원래 테이블에 distinct해서 넣고
		sqlSession.insert("member.addallergy");
		sqlSession.delete("member.deletetmpallergy");
		//tmp테이블 지우고
		return ;
	}

	public void deleteAllergy(String id) {
		int deleterrr = sqlSession.delete("member.deleteAllergy",id);
		return;
	}
}
