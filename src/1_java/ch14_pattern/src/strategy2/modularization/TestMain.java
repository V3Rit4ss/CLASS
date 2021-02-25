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
		
		System.out.println("�ҳ�Ÿ�� ���Ḧ ���̺긮���, ���� 20km/L");
		sonata.setFuel(new FuelHybrid()); //���� ���׷��̵�
		sonata.setKm(new km20()); // ���� ���׷��̵�
		for(Car car : cars) {
			car.shape();
			car.drive();
			car.isEngine();
			car.isKm();
			car.isFuel();
		
		}
	}//main
}//class
