package strategy2.modularization;

import strategy2.componemt.EngineLow;
import strategy2.componemt.FuelDiesel;
import strategy2.componemt.km20;

public class Accent extends Car {
	public Accent() {
		setEngine(new EngineLow());
		setKm(new km20());
		setFuel(new FuelDiesel());
	}
	@Override
	public void shape() {
		System.out.println("¿¢¼¾Æ®");
		super.shape();
	}
}
