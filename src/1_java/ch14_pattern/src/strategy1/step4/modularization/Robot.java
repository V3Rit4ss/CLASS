package strategy1.step4.modularization; 


public abstract class Robot {
	public void shape() {
		System.out.println(getClass().getName()+"은 팔,다리,머리,몸통으로 이루어져 있다.");
	}
	public void actionWalk() {
		System.out.println("걸을수있다.");
	}
	public void actionRun() {
		System.out.println("뛸수 있다.");
	}
	public abstract void actionFly(); //업스트랙트 보이드 액션 관련.
	public abstract void actionMissile();
	public abstract void actionKnife();

}
