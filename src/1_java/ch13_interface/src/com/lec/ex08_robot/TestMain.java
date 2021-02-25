package com.lec.ex08_robot;

public class TestMain {
	public static void main(String[] args) {
		DanceRobot aRobot = new DanceRobot();
		SingRobot bRobot = new SingRobot();
		DrawRobot cRobot = new DrawRobot();
		RobotOrder order = new RobotOrder();
		order.action(aRobot);
		order.action(bRobot);
		Robot[] robot = {aRobot, bRobot, cRobot};
		for(Robot robots : robot) {
			order.action(robots);
		}
	}
}
