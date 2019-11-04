package com.ssafy.edu.vue.dto;



public class NoticeDto {
	private int noticeNO; //PK
	private String title;
	private String content;
	private String time;
	private String id; //FK
	
	public NoticeDto() {}
	public NoticeDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public NoticeDto(String title, String content, String id) {
		this.title = title;
		this.content = content;
		this.id = id;
	}
	
	public NoticeDto(int noticeNO, String title, String content, String time, String id) {
		this.noticeNO = noticeNO;
		this.title = title;
		this.content = content;
		this.time = time;
		this.id = id;
	}


	public int getNoticeNO() {
		return noticeNO;
	}

	public void setNoticeNO(int noticeNO) {
		this.noticeNO = noticeNO;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "NoticeDto [noticeNO=" + noticeNO + ", title=" + title + ", content=" + content + ", time=" + time
				+ ", id=" + id + "]";
	}

	
}

