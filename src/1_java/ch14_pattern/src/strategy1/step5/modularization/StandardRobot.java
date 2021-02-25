package strategy1.step5.modularization;

import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeIron;
import strategy1.step4.component.MissileYes;


public class StandardRobot extends Robot {

	public StandardRobot() {

		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeIron());
	}

	@Override
	public void shape() {
		System.out.println("SuperRobot은 팔,다리,몸통,머리으로 이루어져있다.");		
	}
	
	
	




	
}
