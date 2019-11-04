package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.NoticeDAO;
import com.ssafy.edu.vue.dto.NoticeDto;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDao;

	@Transactional(readOnly=true)
	public List<NoticeDto> entireList(){
		return noticeDao.entireList();
	}

	public int insertNotice(NoticeDto newNotice) {
		return noticeDao.insertNotice(newNotice);
	}

	@Transactional(readOnly=true)
	public NoticeDto getNotice(int noticeNO) {
		return noticeDao.getNotice(noticeNO);
	}

	@Transactional(readOnly=true)
	public int updateNotice(NoticeDto newNotice) {
		return noticeDao.updateNotice(newNotice);
	}
	@Transactional(readOnly=true)
	public int deleteNotice(int noticeNO) {
		return noticeDao.deleteNotice(noticeNO);
	}
}
