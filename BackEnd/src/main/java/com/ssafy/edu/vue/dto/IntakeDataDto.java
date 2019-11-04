package com.ssafy.edu.vue.dto;

import java.util.List;

public class IntakeDataDto {
	private  double calory;
	private  double carbo;	
	private  double protein;
	private  double fat;
	private  double sugar;
	private  double natrium;	
	private  double chole;
	private  double fattyacid;	
	private  double transfat;
	private  String date;
	private List<IntakeFoodDto> intakefood;

	public IntakeDataDto() {}
	public IntakeDataDto(double calory, double carbo, double protein, double fat, double sugar, double natrium,
			double chole, double fattyacid, double transfat,String date) {
		this.calory = calory;
		this.carbo = carbo;
		this.protein = protein;
		this.fat = fat;
		this.sugar = sugar;
		this.natrium = natrium;
		this.chole = chole;
		this.fattyacid = fattyacid;
		this.transfat = transfat;
		this.date = date;
	}
	

	public IntakeDataDto(double calory, double carbo, double protein, double fat, double sugar, double natrium,
			double chole, double fattyacid, double transfat) {
		this.calory = calory;
		this.carbo = carbo;
		this.protein = protein;
		this.fat = fat;
		this.sugar = sugar;
		this.natrium = natrium;
		this.chole = chole;
		this.fattyacid = fattyacid;
		this.transfat = transfat;
	}
	public double getCalory() {
		return calory;
	}
	public void setCalory(double calory) {
		this.calory = calory;
	}
	public double getCarbo() {
		return carbo;
	}
	public void setCarbo(double carbo) {
		this.carbo = carbo;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	public double getNatrium() {
		return natrium;
	}
	public void setNatrium(double natrium) {
		this.natrium = natrium;
	}
	public double getChole() {
		return chole;
	}
	public void setChole(double chole) {
		this.chole = chole;
	}
	public double getFattyacid() {
		return fattyacid;
	}
	public void setFattyacid(double fattyacid) {
		this.fattyacid = fattyacid;
	}
	public double getTransfat() {
		return transfat;
	}
	public void setTransfat(double transfat) {
		this.transfat = transfat;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public List<IntakeFoodDto> getIntakefood() {
		return intakefood;
	}
	public void setIntakefood(List<IntakeFoodDto> intakefood) {
		this.intakefood = intakefood;
	}
	@Override
	public String toString() {
		return "IntakeDataDto [calory=" + calory + ", carbo=" + carbo + ", protein=" + protein + ", fat=" + fat
				+ ", sugar=" + sugar + ", natrium=" + natrium + ", chole=" + chole + ", fattyacid=" + fattyacid
				+ ", transfat=" + transfat + ", date=" + date + "]";
	}
	
	
}
