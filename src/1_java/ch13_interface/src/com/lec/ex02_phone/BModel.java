package com.lec.ex02_phone;
//b��ǰ : DMB�ۼ��Ű���, LTE, TV������ ž��, 
public class BModel implements IAcor {
	private String modelName;
	public BModel() {
		modelName = "B ��" ;
	}
	@Override
	public void dmbReceive() {
		System.out.println(modelName+"�� DMB �ۼ��� ����.");
	}

	@Override
	public void lte() {
		System.out.println(modelName+"�� LET .");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"�� TV ������ ž�� .");
	}

}
