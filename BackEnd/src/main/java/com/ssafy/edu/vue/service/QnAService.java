package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.QnADAO;
import com.ssafy.edu.vue.dto.QnADto;

@Service
public class QnAService {
	@Autowired
	private QnADAO qnaDao;

	@Transactional(readOnly=true)
	public List<QnADto> entireList() {
		return qnaDao.entireList();
	}

	public int deleteQnA(int qno) {
		return qnaDao.deleteQnA(qno);
	}

	public int addQnA(QnADto dto) {
		return qnaDao.addQnA(dto);
	}
	@Transactional(readOnly=true)
	public QnADto getQnA(int qno) {
		return qnaDao.getQnA(qno);
	}

	public int addAnswer(QnADto dto) {
		return qnaDao.addAnswer(dto);
	}
}
