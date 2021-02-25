package strategy1.step5.modularization;

import strategy1.step4.component.*;

public abstract class Robot {
	
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;
	
	
	
	public abstract void shape() ;

	public void actionWalk() {
		System.out.println("걸을수있다.");
	}
	public void actionRun() {
		System.out.println("뛸수 있다.");
	}

	
	public void actionFly() {
		// 부품호출 영역.
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
