package strategy2.modularization;
//���׽ý� :�ְ�� , ����10 , �ֹ���, �⺻������ ����̺�.
//��� door sheet handle .

import strategy2.componemt.*;

public class Genesis extends Car {
	private EngineImpl engine;
	private KmImpl km;
	private FuelImpl fuel;
	public Genesis() {
		
//		engine = new EngineHigh();  ������.
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.println("���׽ý�");
		super.shape();
	}
//	
}
