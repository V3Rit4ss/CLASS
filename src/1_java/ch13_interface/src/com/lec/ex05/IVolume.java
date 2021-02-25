package com.lec.ex05;

public interface IVolume {
	public int TV_MAX_VOLUME = 50;
	public int RADIO_MAX_VOLUME = 30;
	public int MIN_VOLUME = 0;
	public void volumeUp();
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	public default void mute() {   //일반 메소드    default 를 하면 쓸수있다. => default 메소드. 여기에 원래는 없어야한다. // 있어야하는 순간이 있다.
		System.out.println("무음처리입니다.");
		
	}
}
