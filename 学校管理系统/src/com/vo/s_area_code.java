package com.vo;

public class s_area_code {
	int ID;
	int areaCode  ;
	String  province  ;
	String  city  ;
	String district  ;
	String  detail ;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public s_area_code(int iD, int areaCode, String province, String city, String district, String detail) {
		super();
		ID = iD;
		this.areaCode = areaCode;
		this.province = province;
		this.city = city;
		this.district = district;
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "s_area_code [ID=" + ID + ", areaCode=" + areaCode + ", province=" + province + ", city=" + city
				+ ", district=" + district + ", detail=" + detail + "]";
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
