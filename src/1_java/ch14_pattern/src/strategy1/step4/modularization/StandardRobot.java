package strategy1.step4.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeIron;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileYes;

public class StandardRobot extends Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;
	
	public StandardRobot() {
		fly = new FlyNo();
		missile = new MissileYes();
		knife = new KnifeIron();
//		setFly(new FlyNo());
//		setMissile(new MissileYes());
//		setKnife(new KnifeIron());
	}
	
	
	
	@Override
	public void actionFly() {
		fly.fly();

	}

	@Override
	public void actionMissile() {
		missile.missile();

	}

	@Override
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
