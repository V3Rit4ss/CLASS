package strategy1.step4.modularization; 


public abstract class Robot {
	public void shape() {
		System.out.println(getClass().getName()+"�� ��,�ٸ�,�Ӹ�,�������� �̷���� �ִ�.");
	}
	public void actionWalk() {
		System.out.println("�������ִ�.");
	}
	public void actionRun() {
		System.out.println("�ۼ� �ִ�.");
	}
	public abstract void actionFly(); //����Ʈ��Ʈ ���̵� �׼� ����.
	public abstract void actionMissile();
	public abstract void actionKnife();

}
