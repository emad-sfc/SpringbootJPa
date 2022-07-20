package com.example.demo;

import org.springframework.stereotype.Component;

@Component("lap1")
public class Laptop {
	
	private String hddType;
	private int size;

	public String getHddType() {
		return hddType;
	}
	public void setHddType(String hddType) {
		this.hddType = hddType;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}	
	
	@Override
	public String toString() {
		return "Laptop [hddType=" + hddType + ", size=" + size + "]";
	}
	
	public void LaptopTest() {
		System.out.println("calling from laptop class");
	}
	
	

}
