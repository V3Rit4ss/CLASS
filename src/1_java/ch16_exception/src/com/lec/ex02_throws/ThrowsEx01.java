package com.lec.ex02_throws;

public class ThrowsEx01 {
	public ThrowsEx01() throws Exception {
		actionC();
	}

	private void actionC() throws Exception {
		System.out.println("actionC ���ݺ�");
		//try {
			actionB();
	//	}catch(Exception e) {
			
	//	}
		System.out.println("actionC �Ĺݺ�");
	}

	private void actionB() throws Exception {
		System.out.println("actionB ���ݺ�");
		//try {
		actionA();
		//}catch(ArrayIndexOutOfBoundsException e) { //Ÿ���� �ٸ��� ����x
		//	System.out.println("���ܸ޼��� : "+e.getMessage());
	//	}
		System.out.println("actionB �Ĺݺ�");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException { // throws ���� Exception ����.
		System.out.println("actionA ���ݺ�");
		int[] arr = { 0, 1, 2, 3 };

		System.out.println(arr[4]); // Exception �߻� .  �߻��� ������ ��������(Throws) �׼�A�� �ҷ������� ���� ����.
										// �� �׼�A �Ĺݺ� ���� x
		System.out.println("actionA �Ĺݺ�");
	}
}
