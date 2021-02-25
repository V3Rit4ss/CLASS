package strategy1.step4.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyYes;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeLazer;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileYes;

//날수있 미사일쏠수있 레이저검
public class SuperRobot extends Robot {
//생성자.
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;

	public SuperRobot() {

		fly = new FlyYes();
		missile = new MissileYes();
		knife = new KnifeLazer();
		//setFly(new FlyYes());
		//setMissile(new MissileYes());
		//setKnife(new KnifeLazer());
		
	}

	@Override
	public void actionFly() {
		// 부품호출 영역.
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
