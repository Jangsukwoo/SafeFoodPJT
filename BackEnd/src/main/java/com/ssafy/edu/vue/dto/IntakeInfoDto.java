package com.ssafy.edu.vue.dto;

import java.util.List;

public class IntakeInfoDto {
	private  String id;
	private  int fno;
	private  int quantity;
	private  String date;

	public IntakeInfoDto() {}
	
	
	public IntakeInfoDto(String id, String date){
		this.id = id;
		this.date = date;
	}
	
	//아이디 식품번호 수량 
	public IntakeInfoDto(String id, int fno, int quantity) {
		this.id = id;
		this.fno = fno;
		this.quantity = quantity;
	}
	
	public IntakeInfoDto(String id, int fno, int quantity, String date) {
		super();
		this.id = id;
		this.fno = fno;
		this.quantity = quantity;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "IntakeInfoDto [id=" + id + ", fno=" + fno + ", quantity=" + quantity + ", date=" + date + "]";
	}


}
