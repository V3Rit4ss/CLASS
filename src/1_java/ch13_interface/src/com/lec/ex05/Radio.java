package com.lec.ex05;

public class Radio implements IVolume {
	private int volumeLevel;
	public Radio() {
		volumeLevel = 10;
	}
	public Radio(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	@Override
	public void volumeUp() {
		volumeLevel++;
		if(volumeLevel >= RADIO_MAX_VOLUME) {
			volumeLevel = RADIO_MAX_VOLUME;
			System.out.println("���� ������ �ִ� �Դϴ�.");
		}else {
			System.out.println("Radio ������"+1+"��ŭ �÷���"+volumeLevel);
		}
	}

	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if(volumeLevel >= RADIO_MAX_VOLUME) {
			volumeLevel = RADIO_MAX_VOLUME;
			System.out.println("���� ������ �ִ� �Դϴ�. ");
		}else {
			
			System.out.println("Radio ������ "+level+"��ŭ �÷���"+volumeLevel);
		}
	}

	@Override
	public void volumeDown() {
		volumeLevel--;
		if(volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("���� ������ �ּ��Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if(volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("���� ������ �ּ� �Դϴ�.");
		}else {
		
			System.out.println("Radio ������ "+level+"��ŭ ������"+volumeLevel);
		}
	}

}
