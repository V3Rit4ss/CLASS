package com.lec.ex02_phone;

public class TestMain {
	public static void main(String[] args) {
		AModel aPhone = new AModel();
		BModel bPhone = new BModel();
		CModel cPhone = new CModel();
		IAcor[] phones = {aPhone, bPhone, cPhone};
		for(IAcor phone : phones) {
			System.out.println(phone.getClass().getName()); //객체의 클래스타입.
			phone.dmbReceive();
			phone.lte();
			phone.tvRemoteControl();
		}
//		IAcor ob = new IAcor() {  //안드로이드 에서는 가능.
//			
//		}
	}
}
