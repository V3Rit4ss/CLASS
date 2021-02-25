package strategy2.modularization;

import strategy2.componemt.EngineImpl;
import strategy2.componemt.FuelImpl;
import strategy2.componemt.KmImpl;

public class Car {
	private EngineImpl engine;
	private KmImpl km;
	private FuelImpl fuel;
	
public void shape() {
		
		System.out.println(" door, sheet , handle이 있습니다.");
		
	}
	
	public void drive() {
		System.out.println("드라이브 할수있습니다.");
		
	}
	
	public void isEngine() {
		
		engine.engine();
		
	}
	public void isKm() {
		
		km.km();
		
	}
	
	public void isFuel() {
		
		fuel.fuel();
		
	}
	
		
	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}
	public void setKm(KmImpl km) {
		this.km = km;
	}
	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}
	
	
}
