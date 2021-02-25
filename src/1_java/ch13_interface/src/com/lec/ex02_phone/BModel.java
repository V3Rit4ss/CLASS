package com.lec.ex02_phone;
//b제품 : DMB송수신가능, LTE, TV리모콘 탑재, 
public class BModel implements IAcor {
	private String modelName;
	public BModel() {
		modelName = "B 모델" ;
	}
	@Override
	public void dmbReceive() {
		System.out.println(modelName+"은 DMB 송수신 가능.");
	}

	@Override
	public void lte() {
		System.out.println(modelName+"은 LET .");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"은 TV 리모콘 탑재 .");
	}

}
