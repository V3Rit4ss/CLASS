package com.lec.ex05;

public interface IVolume {
	public int TV_MAX_VOLUME = 50;
	public int RADIO_MAX_VOLUME = 30;
	public int MIN_VOLUME = 0;
	public void volumeUp();
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	public default void mute() {   //�Ϲ� �޼ҵ�    default �� �ϸ� �����ִ�. => default �޼ҵ�. ���⿡ ������ ������Ѵ�. // �־���ϴ� ������ �ִ�.
		System.out.println("����ó���Դϴ�.");
		
	}
}
