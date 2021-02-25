package com.lec.ex11_store;

public class StoreNum3 extends HeadQuarterStore {
	public StoreNum3(String name) {
		super(name);
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 6,000¿ø.");
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ 7,000¿ø.");
	}
	@Override
	public void bibib() {
		System.out.println("ºñºö¹ä 7,000¿ø.");
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹ 6,000¿ø.");
	}
}
