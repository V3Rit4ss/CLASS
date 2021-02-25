package strategy2.modularization;
//제네시스 :최고급 , 연비10 , 휘발유, 기본적으로 드라이브.
//모먕 door sheet handle .

import strategy2.componemt.*;

public class Genesis extends Car {
	private EngineImpl engine;
	private KmImpl km;
	private FuelImpl fuel;
	public Genesis() {
		
//		engine = new EngineHigh();  생성자.
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.println("제네시스");
		super.shape();
	}
//	
}
