package com.lec.ex01_string;
//��Ʈ�� ������ ������.   str�� ��ü�� �״�� ���鼭 �߰��� ������ Ȯ���ؼ� �߰����ش�. ��, �������� ��ü�� ������ �ʴ´�.
public class Ex09_stringBuffer {
	public static void main(String[] args) {
		String str = new String ("abc");      //��ҿ� �ϴ�.
		StringBuilder strBu = new StringBuilder("abc");
		System.out.println("1. "+strBu);  //append("def") �ϱ���.
		strBu.append("def"); // abcdef concat �� �����
		System.out.println("2. "+strBu);
		strBu.insert(3, "AAA"); //3�� �ε����� "AAA" �߰� =abc.AAA.def
		System.out.println("3. "+strBu);
		strBu.delete(3, 6); //3�� �ε������� 6���� ���� ���� = abcdef
		System.out.println("4. "+strBu);
		int capacitySize = strBu.capacity(); //���� ũ�� �� Ȯ���ų��.
		System.out.println("����ũ�� : "+capacitySize); //19
		System.out.println("���� strBu �� �ؽ��ڵ� : "+strBu.hashCode());
		strBu.append("12345678901234567890"); //����ũ�⺸�� �� �߰� ������. ����ũ��� �ؽ��ڵ尡 ���ϴ°�?
		capacitySize = strBu.capacity();
		System.out.println("����ũ�� ���� : "+capacitySize);
		System.out.println("������ strBu�� �ؽ��ڵ� : "+strBu.hashCode());  //�ؽ��ڵ�� �������ʰ� ����ũ�⸸ �þ��.
		
		strBu.ensureCapacity(1000); //����ũ�⸦ ���������� �÷�����.
		capacitySize = strBu.capacity();
		System.out.println("����ũ�� ���� : "+capacitySize);
		System.out.println("������ strBu�� �ؽ��ڵ� : "+strBu.hashCode());  //���ó� �ؽ��ڵ�� ������ �ʰ� ����ũ�⸸ �þ.
	}
}
