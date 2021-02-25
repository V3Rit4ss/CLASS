package com.lec.ex01_store1;

public class StoreNum3 implements HeadQuarterStore {
	private String name;
	public StoreNum3(String name) {
		this.name=name;
//		super(name);
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
	@Override
	public void gonggibab() {
		System.out.println("°ø±â¹ä 1,000¿ø");
		
	}
	@Override
	public String getName() {
	
		return name;
	}
}
