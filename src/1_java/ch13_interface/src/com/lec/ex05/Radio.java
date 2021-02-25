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
			System.out.println("현재 볼륨은 최대 입니다.");
		}else {
			System.out.println("Radio 볼륨을"+1+"만큼 올려서"+volumeLevel);
		}
	}

	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if(volumeLevel >= RADIO_MAX_VOLUME) {
			volumeLevel = RADIO_MAX_VOLUME;
			System.out.println("현재 볼륨은 최대 입니다. ");
		}else {
			
			System.out.println("Radio 볼륨을 "+level+"만큼 올려서"+volumeLevel);
		}
	}

	@Override
	public void volumeDown() {
		volumeLevel--;
		if(volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("현재 볼륨은 최소입니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if(volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("현재 볼륨은 최소 입니다.");
		}else {
		
			System.out.println("Radio 볼륨을 "+level+"만큼 내려서"+volumeLevel);
		}
	}

}
