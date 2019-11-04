package com.ssafy.edu.vue.dto;

import java.util.ArrayList;
import java.util.List;


public class FoodDto {
	
	private  int code;
	private  String name;
	private  double supportpereat;
	private  double calory;
	private  double carbo;
	private  double protein;
	private  double fat;
	private  double sugar;
	private  double natrium;	
	private  double chole;
	private  double fattyacid;	
	private  double transfat;
	private  String maker;
	private  String material;
	private  List<String> materialList;
	private  List<String> allergyList; //교집합
	private  List<String> noneallergyList; //차집합
	
	public List<String> getNoneallergyList() {
		return noneallergyList;
	}
	public void setNoneallergyList(List<String> noneallergyList) {
		this.noneallergyList = noneallergyList;
	}
	protected String img;
	public List<String> getAllergyList() {
		return allergyList;
	}
	public void setAllergyList(List<String> allergyList) {
		this.allergyList = allergyList;
	}
	protected String allergy;
	public FoodDto() {
	}
	public FoodDto(int code) {
		super();
		this.code = code;
	}
	
	public FoodDto(int code, String name, double supportpereat, double calory, double carbo, double protein, double fat,
			double sugar, double natrium, double chole, double fattyacid, double transfat, String maker, String img) {
		super();
		this.code = code;
		this.name = name;
		this.supportpereat = supportpereat;
		this.calory = calory;
		this.carbo = carbo;
		this.protein = protein;
		this.fat = fat;
		this.sugar = sugar;
		this.natrium = natrium;
		this.chole = chole;
		this.fattyacid = fattyacid;
		this.transfat = transfat;
		this.maker = maker;
		this.img = img;
	}
	public List<String> getMaterialList() {
		return materialList;
	}
	public void setMaterialList(List<String> materialList) {
		this.materialList = materialList;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSupportpereat() {
		return supportpereat;
	}
	public void setSupportpereat(double supportpereat) {
		this.supportpereat = supportpereat;
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
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	@Override
	public String toString() {
		return "Food [code=" + code + ", name=" + name + ", supportpereat=" + supportpereat + ", calory=" + calory
				+ ", carbo=" + carbo + ", protein=" + protein + ", fat=" + fat + ", sugar=" + sugar + ", natrium="
				+ natrium + ", chole=" + chole + ", fattyacid=" + fattyacid + ", transfat=" + transfat + ", maker="
				+ maker + ", material=" + material + ", img=" + img + "]";
	}
	
}
