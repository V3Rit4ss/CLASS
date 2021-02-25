package com.lec.ex08_robot;

public class RobotOrder {
	public void action(Robot robot) {
		if(robot instanceof DanceRobot) {//로봇의 타입이 무엇이냐 instanceof
			((DanceRobot)robot).dance();
			
//			DanceRobot drobot = (DanceRobot)robot;
//			dRobot.dance();
			
		}else if(robot instanceof SingRobot) {
			((SingRobot)robot).Sing();
			
//			SingRobot srobot = (SingRobot)robot;
//			sRobot.sing();
			
		}else if (robot instanceof DrawRobot) {
			((DrawRobot)robot).draw();
			
//			DanceRobot drobot = (DanceRobot)robot;
//			dRobot.dance();
			
		}
	}
}
