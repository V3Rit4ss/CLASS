package com.lec.ex01_store;
// 본사 지침 : 반드시 오버라이드 하시오 (강제성) [abstract] : 추상메소드 1개 이상 있는 클래스  . 
//h.kimchi 이런걸 못함 추상클래스에 있는거라서.
//HeadQuarterStore[] store = new HeadQuarterStore(); 불가
public abstract class HeadQuarterStore {
	private String name;
	public HeadQuarterStore(String name) {
		this.name=name;
	}
	public abstract void kimchi(); //추상(abstract) 메소드 
	public abstract void bude();
	public abstract void bibib();
	public abstract void sunde();
	public abstract void gonggibab();
	public String getName() {
		return name;
	}
}
