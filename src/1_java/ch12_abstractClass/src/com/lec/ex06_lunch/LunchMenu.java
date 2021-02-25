package com.lec.ex06_lunch;
//Child1 c = new Child1(300,1000,100,300,800,350);    
//Child2 c = new Child1(300,1000,100,300,800,350);   
public abstract class LunchMenu {
	//1�� ����
	private int rice;    //�Ұ�
	private int bulgogi; //�Ұ�Ⱚ
	private int soup;    //����
	private int banana; //�ٳ�����
	private int mlik; //������
	private int almond; // �Ƹ�尪
//	public LunchMenu() {}  �Ű����� ���� ������ ������ ���ϵ�1�� ���� ���� ~
	public LunchMenu(int rice, int bulgogi, int soup, int banana, int mlik, int almond) { //������.
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.banana = banana;
		this.mlik = mlik;
		this.almond = almond;
	}
	//�Ĵ� ��� �ϴ� �߻�޼ҵ�
	public abstract int calcuate();
	
	//===================================
	public int getRice() { //���͸� �ʿ��ؼ� ���͸� ���� ��,�� �� ���� ��
		return rice;
	}
	public int getBulgogi() {
		return bulgogi;
	}
	public int getSoup() {
		return soup;
	}
	public int getBanana() {
		return banana;
	}
	public int getMlik() {
		return mlik;
	}
	public int getAlmond() {
		return almond;
	}
	
}
