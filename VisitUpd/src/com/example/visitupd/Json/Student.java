package com.example.visitupd.Json;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable{
	private int cateid;
	private String hotelname;
	private String address;
	private String cateprice;
	private String catetitle;
	private String catecontent;
	private String cateurl;
	
	public Student(int cateid, String hotelname, String address,
			String cateprice, String catetitle, String catecontent,
			String cateurl) {
		super();
		this.cateid = cateid;
		this.hotelname = hotelname;
		this.address = address;
		this.cateprice = cateprice;
		this.catetitle = catetitle;
		this.catecontent = catecontent;
		this.cateurl = cateurl;
	}
	public String getCateprice() {
		return cateprice;
	}
	public void setCateprice(String cateprice) {
		this.cateprice = cateprice;
	}
	public String getCatetitle() {
		return catetitle;
	}
	public void setCatetitle(String catetitle) {
		this.catetitle = catetitle;
	}
	public String getCatecontent() {
		return catecontent;
	}
	public void setCatecontent(String catecontent) {
		this.catecontent = catecontent;
	}
	public String getCateurl() {
		return cateurl;
	}
	public void setCateurl(String cateurl) {
		this.cateurl = cateurl;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [cateid=" + cateid + ", hotelname=" + hotelname
				+ ", address=" + address + ", cateprice=" + cateprice
				+ ", catetitle=" + catetitle + ", catecontent=" + catecontent
				+ ", cateurl=" + cateurl + "]";
	}
	
}
