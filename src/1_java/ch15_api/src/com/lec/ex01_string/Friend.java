package com.lec.ex01_string;
// ģ�� : �̸�, ��ȭ��ȣ ����(12-12) new Friend (�̸� , ���� , ����)
//print() : �̸�[ȫ ], ����[8888], ����[12-12] ����� .
public class Friend {
	private String name; //������.
	private String tel;
	private String birth;
	public Friend() {} //�Ű����� ���»�����.
	public Friend(String name, String tel, String birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	//f.prinf()  // �����Լ�
	//System.out.println(f.toString())   //��Ʈ������ �ٲ�� ~ toString
	public void print() { //����Ÿ���� �����ϱ� ���̵�   //����Ʈ �Լ� ����.
		System.out.printf("[�̸�]&s,[����]&s,[����]&s\n", name, tel, birth);
	}
		//System.out.println(f.toString()) 
	@Override
	public String toString() {
		return "[�̸�]"+name+"[��ȭ��ȣ]"+tel+"[����]"+birth;  // <- ��ü ����� �ؼ� ���̰� �ϰ������ <-  com.lec.ex01_string.Friend@7d4991ad
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getBirth() {
		return birth;
	}
}
