package com.ssafy.edu.vue.dto;

public class IntakeFoodDto {
	private String imagePath;
	private String fname;
	private int intakequantity;
	private double calory;
	public IntakeFoodDto() {}
	public IntakeFoodDto(String imagePath, String fname, int intakequantity, double calory) {
		this.imagePath = imagePath;
		this.fname = fname;
		this.intakequantity = intakequantity;
		this.calory = calory;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getIntakequantity() {
		return intakequantity;
	}
	public void setIntakequantity(int intakequantity) {
		this.intakequantity = intakequantity;
	}
	public double getCalory() {
		return calory;
	}
	public void setCalory(double calory) {
		this.calory = calory;
	}
	@Override
	public String toString() {
		return "IntakeFoodDto [imagePath=" + imagePath + ", fname=" + fname + ", intakequantity=" + intakequantity
				+ ", calory=" + calory + "]";
	}
	
	
}
