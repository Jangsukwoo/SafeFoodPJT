package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.QnADto;


@Repository
public class QnADAO {	
	@Autowired
	private SqlSession sqlSession;
	
	public List<QnADto> entireList() {
		return sqlSession.selectList("qna.entireList");
	}

	public int deleteQnA(int qno) {
		return sqlSession.delete("qna.deleteQnA",qno);
	}

	public int addQnA(QnADto dto) {
		return sqlSession.insert("qna.insertQuestion",dto);
	}

	public QnADto getQnA(int qno){
		return sqlSession.selectOne("qna.getQnA", qno);
	}

	public int addAnswer(QnADto dto) {
		return sqlSession.update("qna.addAnswer", dto);
	}

}
