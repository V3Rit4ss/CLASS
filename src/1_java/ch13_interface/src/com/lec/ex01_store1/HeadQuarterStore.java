package com.lec.ex01_store1;
// ���� ��ħ : �ݵ�� �������̵� �Ͻÿ� (������) [abstract] : �߻�޼ҵ� 1�� �̻� �ִ� Ŭ����  . 
//h.kimchi �̷��� ���� �߻�Ŭ������ �ִ°Ŷ�.
//HeadQuarterStore[] store = new HeadQuarterStore(); �Ұ�
public interface HeadQuarterStore {
//	private String name; //  �Ϲݺ��� ����.
//	public HeadQuarterStore(String name) {//������ �� ����.
//		this.name=name;
//	}
	public  void kimchi(); //�߻�(abstract �� ����) �޼ҵ� 
	public  void bude();
	public  void bibib();
	public  void sunde();
	public  void gonggibab();
	public String getName(); //�߰� ����.
//	public String getName() { 
//		return name;
//	}
}
