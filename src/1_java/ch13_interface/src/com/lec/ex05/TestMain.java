package com.lec.ex05;

public class TestMain {
	public static void main(String[] args) {
		TV tv = new TV(9);
		Radio radio = new Radio(3);
		
		IVolume vol[] =new IVolume[2];
		vol[0] = radio;
		vol[1] = tv;
		tv.volumeUp(5);
		radio.volumeUp(4);
		System.out.println("이제부터는 인터페이스를 이용한 호출입니다.");
		for(int i = 0; i<vol.length ; i++)
			vol[i].volumeUp(10);
		for(IVolume v : vol)
			v.volumeUp();
	}
}
