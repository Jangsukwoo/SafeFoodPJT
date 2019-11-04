package com.ssafy.edu.vue.dto;

public class BestFoodDto {
	String img;
	String fname;
	int quantity;
	
	
	
	public BestFoodDto() {}
	public BestFoodDto(String img,String fname, int quantity) {
		super();
		this.img = img;
		this.fname = fname;
		this.quantity = quantity;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "BestFoodDto [fname=" + fname + ", quantity=" + quantity + "]";
	}

}
