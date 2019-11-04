package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class QnADto {
	private int qno;
	private String title;
	private String content;
	private String writer;
	private String date;
	private String answer;
	private boolean answerflag;
	


	@Override
	public String toString() {
		return "QnADto [qno=" + qno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", date="
				+ date + "]";
	}
	
	
	public QnADto() {}
	
	
	public QnADto(int qno, String title, String content, String writer, String date, String answer,
			boolean answerflag) {
		super();
		this.qno = qno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.answer = answer;
		this.answerflag = answerflag;
	}


	public QnADto(int qno, String title, String writer, String date) {
		super();
		this.qno = qno;
		this.title = title;
		this.writer = writer;
		this.date = date;
	}
	
	public QnADto(int qno, String title, String content, String writer, String date) {
		super();
		this.qno = qno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}	
	
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isAnswerflag() {
		return answerflag;
	}

	public void setAnswerflag(boolean answerflag) {
		this.answerflag = answerflag;
	}
}


