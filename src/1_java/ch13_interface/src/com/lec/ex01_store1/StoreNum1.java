package com.lec.ex01_store1;//StoreNum1 store1 = new StoreNum1("���ð� 1ȣ��")
//��ġ�-5,000  �δ��-5,000  �����-6,000 ���뱹-���Ⱦ� �����-1,000��
//extends �� -> implements ,  name ���� �߰� , ������ ����, ���� �߰� (�ټ� �ʿ��Ѱ� �߰�.) 
public class StoreNum1 implements HeadQuarterStore {
	private String name;
	public StoreNum1(String name) { //super �θ���� Ŭ���� ������
		this.name = name;
	}
	
	@Override
	public void kimchi() {
		System.out.println("��ġ� 4,500dnjs");
	}
	
	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��.");
	}
		@Override
		public void bibib() {
			System.out.println("����� 6,000��");
		}
	
	@Override
	public void sunde() {
		System.out.println("���뱹 �� �Ⱦ�");
	}

	@Override
	public void gonggibab() {
		System.out.println("����� 1,000��");
	
	}

	public String getName() { //�߰�
		return name;
	}
}
