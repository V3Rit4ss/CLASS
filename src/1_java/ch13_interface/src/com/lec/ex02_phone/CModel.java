package com.lec.ex02_phone;
//c��ǰ : DMB�ۼ��Ű���, LTE, TV������ ��ž��, 
public class CModel implements IAcor {
	private String modelName;
	public CModel() {
		modelName = "C ��";
	}
	@Override
	public void dmbReceive() {
		System.out.println(modelName+"�� DMB �ۼ��� ����.");
	}

	@Override
	public void lte() {
		System.out.println(modelName+"�� LTE .");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"�� TV ������ ��ž�� .");
	}

}
