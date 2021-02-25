package com.lec.ex01_string;
// �پ��� String �� method��
public class Ex02 {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = " ja  va ";
		System.out.println("1. concat : "+str1.concat(str2)); //abcXabcABCXabc  �� ������ ����.
		System.out.println("2. substring(3) : "+str1.substring(3));//3��° ���� ������  �ڹٴ� 0���� ������.
		System.out.println("2. substring(3,5) : "+str1.substring(3,5));//3~5���� ����
		System.out.println("4. length() : "+str1.length());//���ڱ���(7) length()-1 ����������
		System.out.println("5. toUpperCase() : "+str1.toUpperCase());//�빮�ڷ� ������
		System.out.println("6. toLowerCase() : "+str2.toLowerCase());//�ҹ��ڷ�
		System.out.println("7. charAt(3) : "+str1.charAt(3));//3��(index)° ���� �ϳ� ��������
		System.out.println("8. indexOf : "+str1.indexOf("b"));//ó�� b�� �ִ� index.
		System.out.println("9. indexOf(\"b\",3) : "+str1.indexOf("b",3));//3��°���� b�� ����ֳ� 
		System.out.println("10. lastIndexOf(\"b\") : "+str1.lastIndexOf("b"));//������ b �ε���
		System.out.println("11. lastIndexOf(\"z\") : "+str1.lastIndexOf("z"));//������ -1
		System.out.println("12. equals(str2) : "+str1.equals(str2));//������ Ʈ�� �ٸ��� false
		System.out.println("13. equalsIgnoreCase(str2) : "+str1.equalsIgnoreCase(str2));//���ڿ��� ������ Ʈ�� �Ǵ� ������.
		System.out.println("14. trim() : "+str3.trim());//�¿� �����̽��� ����.
		System.out.println("15. replace('a', '��') : "+str1.replace('a', '��')); // 'a' ��� �� ��� '��' ���
		System.out.println("16. replace(\"ab\", \"�ٲ�\") : "+str1.replace("ab", "�ٲ�"));  // ab(�� ��Ʈ��) �� ����
		System.out.println("����.  : "+str1);
		
		
		
		
		
	}
}
