package strategy1.step3;

public class StandardRobot extends Robot {//�������̵� �߰�.
	
	@Override
	public void actionFly() {
		System.out.println("���� ����.");
	}
	@Override
	public void actionMissile() {
		System.out.println("�̻����� ����ִ�.");
	}
	@Override
	public void actionKnife() {
		System.out.println("��ö�� �� �ִ�.");
	}
}