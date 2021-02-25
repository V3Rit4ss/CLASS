package strategy1.step5.modularization;

import strategy1.step4.component.FlyYes;
import strategy1.step4.component.KnifeLazer;
import strategy1.step4.component.MissileYes;


public class LowRobot extends Robot {
	

	
	public LowRobot() {
		


		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
		
		
	}

	@Override
	public void shape() {
		System.out.println("SuperRobot은 팔,다리,몸통,머리으로 이루어져있다.");		
	}
	
	


}
