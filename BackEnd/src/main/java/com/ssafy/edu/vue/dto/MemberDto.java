package com.ssafy.edu.vue.dto;

import java.util.ArrayList;
import java.util.List;

public class MemberDto {
	private String mname;
	private int mage;
	private String mphone;
	private boolean mgr;
	private String id;
	private String pw;
	private List<String> allergylist;
	private String tmp;
	
	//알러지 리스트 정보 멤버 추가
	
	
	public String getTmp() {
		return tmp;
	}

	public void setTmp(String tmp) {
		this.tmp = tmp;
	}

	public MemberDto() {};

	public MemberDto(String id, String pw) {
		super();
		setId(id);
		setPw(pw);
	}
	public MemberDto(String mname, boolean mgr) {
		super();
		setMname(mname);
		setMgr(mgr);
	}

	public MemberDto(String mname, int mage, String mphone, String id, String pw) {
		super();
		setMname(mname);
		setMage(mage);
		setMphone(mphone);
		setId(id);
		setPw(pw);
	}
	public MemberDto(String mname, int mage, String mphone, boolean mgr, String id, String pw) {
		this.mname = mname;
		this.mage = mage;
		this.mphone = mphone;
		this.mgr = mgr;
		this.id = id;
		this.pw = pw;
	}
	public MemberDto(String mname, int mage, String mphone,String id, String pw, List<String> list) {
		this.mname = mname;
		this.mage = mage;
		this.mphone = mphone;
		this.id = id;
		this.pw = pw;
		this.allergylist = new ArrayList<>();
		this.allergylist = list;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMage() {
		return mage;
	}
	public void setMage(int mage) {
		this.mage = mage;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public boolean getMgr() {
		return mgr;
	}
	public void setMgr(boolean mgr) {
		this.mgr = mgr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public List<String> getAllergylist() {
		return allergylist;
	}
	public void setAllergylist(List<String> allergylist) {
		this.allergylist = allergylist;
	}
	@Override
	public String toString() {
		return "mname=" + mname + ", mage=" + mage + ", mphone=" + mphone + ", mgr=" + mgr + ", id=" + id
				+ ", pw=" + pw;
	}
}
