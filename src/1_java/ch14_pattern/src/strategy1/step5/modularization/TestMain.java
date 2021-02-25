package strategy1.step5.modularization;

import strategy1.step4.component.FlyHigh;
import strategy1.step4.component.FlyYes;

public class TestMain {
	public static void main(String[] args) {
		SuperRobot superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot lowRobot = new LowRobot();
		
		Robot[] robots = {superRobot, standardRobot , lowRobot} ;
		for(Robot robot : robots) { //확장for문
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		//LowRobot을 날수있는 로봇으로 업그레이드 요청.
		lowRobot.setFly(new FlyYes());
		//superRobt 기능 업그레이드 추가./
		superRobot.setFly(new FlyHigh());
		System.out.println("업그레이드 후");
		for(Robot robot : robots) { //확장 for문
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		
		
	}
}
