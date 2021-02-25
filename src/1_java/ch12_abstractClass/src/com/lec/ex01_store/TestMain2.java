package com.lec.ex01_store;

public class TestMain2 {
	public static void main(String[] args) { //={}; 0개 방
		HeadQuarterStore[] store = {};//new HeadQuarterStore("== 본사 ==") , new StoreNum1("== 주택가 1호점 ==") , new StoreNum2("== 대학가 2호점 ==") , new StoreNum3("== 증권가 3호점 ==")};
		for(HeadQuarterStore s : store) {  //확장 for
			System.out.println(s.getName());
			s.kimchi();
			s.bude();
			s.bibib();
			s.sunde();
			s.gonggibab();
		}
//		for(int idx=0 ; idx<store.length ; idx++ ) { //일반 for
//			System.out.println(store[idx].getName());
//			store[idx].kimchi();
//			store[idx].bude();
//			store[idx].bibib();
//			store[idx].sunde();
//			store[idx].gonggibab();
//		}
	}
}
