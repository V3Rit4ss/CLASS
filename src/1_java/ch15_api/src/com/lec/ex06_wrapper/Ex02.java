package com.lec.ex06_wrapper;
//�������� �Լ�   ����==�Ű�����  [�Ű������� �ٲ��]
public class Ex02 {
	public static void main(String[] args) {
		int total = valueSum("10","20");
		System.out.println("���� ���� �Ѱ�� "+total);
	}
	private static int valueSum(String ... value) {
		//String[] value = {("10","20")};
		int result = 0;//��������
		for(int i=0; i<value.length; i++) {
			result += Integer.parseInt(value[i]); //Integer = int  ��Ʈ���� ������ �ٲٰ������.
			//Integer.parseInt(Val); val ���ڿ��� ������ �ٲ�.  Integer.parseInt ���� ���δ�.
		}
	return result;	
	}
}
