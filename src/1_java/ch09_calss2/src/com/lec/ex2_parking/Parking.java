package com.lec.ex2_parking;

import com.lec.cons.PiClass;

public class Parking {
	private String numBer ;
	private int inTime ;
	private int outTime ;
	private int fee ;
	//private final int HOURYRATE = 2000; //(상수) final : 한번 세팅하면 바꾸지마라.
	public Parking() {}
	public Parking(String numBer , int inTime) {
		this.numBer = numBer ;
		this.inTime = inTime ;
		System.out.println(numBer+"님 어서오세요");
		System.out.println("입차시간 : "+inTime+"시");
		System.out.println("=========================");
	}
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime - inTime) * PiClass.HOURYRATE;
		System.out.println(numBer+"님 안녕히 가세요");
		System.out.println("입차시간 : "+inTime+"시");
		System.out.println("출차시간 : "+outTime+"시");
		System.out.println("주차요금 : "+fee+"원");
		System.out.println("=========================");
	}
	public String getNumber() {
		return numBer;
	}
	public void setNumber(String numBer) {
		this.numBer = numBer;
	}
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	public int getOutTime() {
		return outTime ;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime ;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
}
