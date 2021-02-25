package strategy1.step5.modularization;

import strategy1.step4.component.FlyYes;
import strategy1.step4.component.KnifeLazer;
import strategy1.step4.component.MissileYes;


//날수있 미사일쏠수있 레이저검
public class SuperRobot extends Robot {


	public SuperRobot() {
//생성자

		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
		
	

		
		
	}

	@Override
	public void shape() {
		System.out.println("SuperRobot은 팔,다리,몸통,머리으로 이루어져있다.");		
	}


}
