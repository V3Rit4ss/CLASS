package strategy1.step5.modularization;

import strategy1.step4.component.*;

public abstract class Robot {
	
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;
	
	
	
	public abstract void shape() ;

	public void actionWalk() {
		System.out.println("�������ִ�.");
	}
	public void actionRun() {
		System.out.println("�ۼ� �ִ�.");
	}

	
	public void actionFly() {
		// ��ǰȣ�� ����.
		fly.fly();
		
	}

	
	public void actionMissile() {
		missile.missile();
		
	}

	
	public void actionKnife() {
		knife.knife();
		
	}

	public void setFly(FlyImpl fly) {
		
		this.fly = fly;
		
	}

	public void setMissile(MissileImpl missile) {
		
		this.missile = missile;
		
	}

	public void setKnife(KnifeImpl knife) {
		
		this.knife = knife;
		
	}

}
