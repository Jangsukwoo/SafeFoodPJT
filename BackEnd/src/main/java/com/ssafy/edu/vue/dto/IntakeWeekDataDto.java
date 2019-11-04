package com.ssafy.edu.vue.dto;

public class IntakeWeekDataDto {	
	private String id;
	
	private  double sundaycalory;
	private  double mondaycalory;
	private  double tuesdaycalory;
	private  double wednesdaycalory;
	private  double Thursdaycalory;
	private  double Fridaycalory;
	private  double Saturdaycalory;
	private  double todaycalory;
	
	private  String sunday;
	private  String monday;
	private  String tuesday;
	private  String wednesday;
	private  String thursday;
	private  String friday;
	private  String saturday;
	
	public IntakeWeekDataDto(double sundaycalory, double mondaycalory, double tuesdaycalory, double wednesdaycalory,
			double thursdaycalory, double fridaycalory, double saturdaycalory) {
		this.sundaycalory = sundaycalory;
		this.mondaycalory = mondaycalory;
		this.tuesdaycalory = tuesdaycalory;
		this.wednesdaycalory = wednesdaycalory;
		this.Thursdaycalory = thursdaycalory;
		this.Fridaycalory = fridaycalory;
		this.Saturdaycalory = saturdaycalory;
	}
	public IntakeWeekDataDto(String sunday, String monday, String tuesday, String wednesday, String thursday,
			String friday, String saturday) {
		this.sunday = sunday;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
	}
	public String getId() {
		return id;
	}

	public double getTodaycalory() {
		return todaycalory;
	}
	public void setTodaycalory(double todaycalory) {
		this.todaycalory = todaycalory;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getSundaycalory() {
		return sundaycalory;
	}
	public void setSundaycalory(double sundaycalory) {
		this.sundaycalory = sundaycalory;
	}
	public double getMondaycalory() {
		return mondaycalory;
	}
	public void setMondaycalory(double mondaycalory) {
		this.mondaycalory = mondaycalory;
	}
	public double getTuesdaycalory() {
		return tuesdaycalory;
	}
	public void setTuesdaycalory(double tuesdaycalory) {
		this.tuesdaycalory = tuesdaycalory;
	}
	public double getWednesdaycalory() {
		return wednesdaycalory;
	}
	public void setWednesdaycalory(double wednesdaycalory) {
		this.wednesdaycalory = wednesdaycalory;
	}
	public double getThursdaycalory() {
		return Thursdaycalory;
	}
	public void setThursdaycalory(double thursdaycalory) {
		Thursdaycalory = thursdaycalory;
	}
	public double getFridaycalory() {
		return Fridaycalory;
	}
	public void setFridaycalory(double fridaycalory) {
		Fridaycalory = fridaycalory;
	}
	public double getSaturdaycalory() {
		return Saturdaycalory;
	}
	public void setSaturdaycalory(double saturdaycalory) {
		Saturdaycalory = saturdaycalory;
	}
	public String getSunday() {
		return sunday;
	}
	public void setSunday(String sunday) {
		
		this.sunday = sunday;
	}
	public String getMonday() {
		return monday;
	}
	public void setMonday(String monday) {
	
		this.monday = monday;
	}
	public String getTuesday() {
		return tuesday;
	}
	public void setTuesday(String tuesday) {
		
		this.tuesday = tuesday;
	}
	public String getWednesday() {
		return wednesday;
	}
	public void setWednesday(String wednesday) {
		
		this.wednesday = wednesday;
	}
	public String getThursday() {
		return thursday;
	}
	public void setThursday(String thursday) {
		
		this.thursday = thursday;
	}
	public String getFriday() {
		return friday;
	}
	public void setFriday(String friday) {
		
		this.friday = friday;
	}
	public String getSaturday() {
		return saturday;
	}
	public void setSaturday(String saturday) {
		
		this.saturday = saturday;
	}
	@Override
	public String toString() {
		return "IntakeWeekData [sundaycalory=" + sundaycalory + ", mondaycalory=" + mondaycalory + ", tuesdaycalory="
				+ tuesdaycalory + ", wednesdaycalory=" + wednesdaycalory + ", Thursdaycalory=" + Thursdaycalory
				+ ", Fridaycalory=" + Fridaycalory + ", Saturdaycalory=" + Saturdaycalory + ", sunday=" + sunday
				+ ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday=" + thursday
				+ ", friday=" + friday + ", saturday=" + saturday + "]";
	}

	
	
}
