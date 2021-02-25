package strategy2.modularization;

import strategy2.componemt.EngineMid;
import strategy2.componemt.FuelGasoline;
import strategy2.componemt.km15;

public class Sonata extends Car {
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new km15());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.print("¼Ò³ªÅ¸");
		super.shape();
	}
}
