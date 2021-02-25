package com.lec.ex05; // ������ �ѹ� �ϱ�.

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

			System.out.println("TV ������ �ִ� �Դϴ�.");
		} else {
			System.out.println("TV������" + 2 + "��ŭ �÷���" + volumeLevel);
		}
	}

	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if (volumeLevel + level >= TV_MAX_VOLUME) {
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV������ �ִ� �Դϴ�.");
		} else {
			System.out.println("TV������" + level + "��ŭ �÷���" + volumeLevel);
		}
	}

	@Override
	public void volumeDown() {
		volumeLevel--;
		if (volumeLevel < MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("���� ������ 0 �Դϴ�.");
		}
		System.out.println("TV������" + 2 + "��ŭ ������" + volumeLevel);
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if (volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("���� ������ 0 �Դϴ�. ");

		}
		System.out.println("TV������ " + level + "��ŭ ������ " + volumeLevel);
	}
}
