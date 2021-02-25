package com.lec.ex05; // 집가서 한번 하기.

public class TV implements IVolume {
	private int volumeLevel;

	public TV() {
		volumeLevel = 10;
	}

	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		volumeLevel += 2;
		if (volumeLevel >= TV_MAX_VOLUME) {
			volumeLevel = TV_MAX_VOLUME;

			System.out.println("TV 볼륨이 최대 입니다.");
		} else {
			System.out.println("TV볼륨을" + 2 + "만큼 올려서" + volumeLevel);
		}
	}

	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if (volumeLevel + level >= TV_MAX_VOLUME) {
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV볼륨이 최대 입니다.");
		} else {
			System.out.println("TV볼륨을" + level + "만큼 올려서" + volumeLevel);
		}
	}

	@Override
	public void volumeDown() {
		volumeLevel--;
		if (volumeLevel < MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("현재 볼륨은 0 입니다.");
		}
		System.out.println("TV볼륨을" + 2 + "만큼 내려서" + volumeLevel);
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if (volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("현재 볼륨은 0 입니다. ");

		}
		System.out.println("TV볼륨을 " + level + "만큼 내려서 " + volumeLevel);
	}
}
