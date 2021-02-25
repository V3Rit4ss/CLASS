package com.lec.ex07_car;

import com.lec.cons.CarSpec;

public class TestMain {
	public static void main(String[] args) {
		Car lowCar = new LowGradeCar(CarSpec.GRAY_CAR , CarSpec.TIRE_NORMAL , CarSpec.DISPLACEMENT_1000 , CarSpec.HANDLE_POWER );
		Car highCar = new HighGradeCar(CarSpec.WHIT_CAR , CarSpec.TIRE_WIDE , CarSpec.DISPLACEMENT_2000 , CarSpec.HANDLE_POWER );
		lowCar.getSpec();
		highCar.getSpec();
	}
}
