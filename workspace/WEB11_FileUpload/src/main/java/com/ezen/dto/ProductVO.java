package com.ezen.dto;

public class ProductVO {
	private int code;
	private String name;
	private int price;
	private String description;
	private String pictureurl;
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pirctureurl) {
		this.pictureurl = pirctureurl;
	}
	
}
