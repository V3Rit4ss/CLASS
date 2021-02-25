package strategy2.modularization;

import strategy2.componemt.FuelHybrid;
import strategy2.componemt.km20;

public class TestMain {
	public static void main(String[] args) {
		Genesis genesis = new Genesis();
		Sonata sonata = new Sonata();
		Accent accent = new Accent();
		
		Car[] cars = {genesis, sonata , accent};
		for(Car car : cars) {
			car.shape();
			car.drive();
			car.isEngine();
			car.isKm();
			car.isFuel();
			
			
		}//for
		
		System.out.println("소나타의 연료를 하이브리드로, 연비를 20km/L");
		sonata.setFuel(new FuelHybrid()); //연료 업그레이드
		sonata.setKm(new km20()); // 연비 업그레이드
		for(Car car : cars) {
			car.shape();
			car.drive();
			car.isEngine();
			car.isKm();
			car.isFuel();
		
		}
	}//main
}//class
