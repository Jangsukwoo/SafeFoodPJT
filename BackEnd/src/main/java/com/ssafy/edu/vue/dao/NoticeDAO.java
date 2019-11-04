package com.ssafy.edu.vue.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.NoticeDto;
@Repository
public class NoticeDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public List<NoticeDto> entireList() {
		return sqlSession.selectList("notice.entireList");
	}
	public int insertNotice(NoticeDto newNotice) {
		return sqlSession.insert("notice.insertNotice",newNotice);
	}
	public NoticeDto getNotice(int noticeNO) {
		return sqlSession.selectOne("notice.getNotice",noticeNO);
	}
	public int updateNotice(NoticeDto newNotice) {
		return sqlSession.update("notice.updateNotice",newNotice);
	}
	public int deleteNotice(int noticeNO) {
		return sqlSession.delete("notice.deleteNotice", noticeNO);
	}

}
