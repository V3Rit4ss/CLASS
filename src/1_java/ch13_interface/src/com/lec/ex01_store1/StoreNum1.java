package com.lec.ex01_store1;//StoreNum1 store1 = new StoreNum1("주택가 1호점")
//김치찌개-5,000  부대찌개-5,000  비빔밥-6,000 순대국-안팔아 공기밥-1,000원
//extends 를 -> implements ,  name 변수 추가 , 생성자 수정, 겟터 추가 (겟셋 필요한거 추가.) 
public class StoreNum1 implements HeadQuarterStore {
	private String name;
	public StoreNum1(String name) { //super 부모단의 클래스 생성자
		this.name = name;
	}
	
	@Override
	public void kimchi() {
		System.out.println("김치찌개 4,500dnjs");
	}
	
	@Override
	public void bude() {
		System.out.println("부대찌개 5,000원.");
	}
		@Override
		public void bibib() {
			System.out.println("비빔밥 6,000원");
		}
	
	@Override
	public void sunde() {
		System.out.println("순대국 안 팔아");
	}

	@Override
	public void gonggibab() {
		System.out.println("공기밥 1,000원");
	
	}

	public String getName() { //추가
		return name;
	}
}
