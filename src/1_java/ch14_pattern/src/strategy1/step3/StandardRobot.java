package strategy1.step3;

public class StandardRobot extends Robot {//오버라이드 추가.
	
	@Override
	public void actionFly() {
		System.out.println("날수 없다.");
	}
	@Override
	public void actionMissile() {
		System.out.println("미사일을 쏠수있다.");
	}
	@Override
	public void actionKnife() {
		System.out.println("강철검 이 있다.");
	}
}