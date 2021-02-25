package strategy1.step5.modularization;

import strategy1.step4.component.FlyHigh;
import strategy1.step4.component.FlyYes;

public class TestMain {
	public static void main(String[] args) {
		SuperRobot superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot lowRobot = new LowRobot();
		
		Robot[] robots = {superRobot, standardRobot , lowRobot} ;
		for(Robot robot : robots) { //Ȯ��for��
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		//LowRobot�� �����ִ� �κ����� ���׷��̵� ��û.
		lowRobot.setFly(new FlyYes());
		//superRobt ��� ���׷��̵� �߰�./
		superRobot.setFly(new FlyHigh());
		System.out.println("���׷��̵� ��");
		for(Robot robot : robots) { //Ȯ�� for��
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		
		
	}
}
