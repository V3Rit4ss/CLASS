package com.lec.ex01_store1;
// 본사 지침 : 반드시 오버라이드 하시오 (강제성) [abstract] : 추상메소드 1개 이상 있는 클래스  . 
//h.kimchi 이런걸 못함 추상클래스에 있는거라서.
//HeadQuarterStore[] store = new HeadQuarterStore(); 불가
public interface HeadQuarterStore {
//	private String name; //  일반변수 못씀.
//	public HeadQuarterStore(String name) {//생성자 라서 못씀.
//		this.name=name;
//	}
	public  void kimchi(); //추상(abstract 를 생략) 메소드 
	public  void bude();
	public  void bibib();
	public  void sunde();
	public  void gonggibab();
	public String getName(); //추가 가능.
//	public String getName() { 
//		return name;
//	}
}
