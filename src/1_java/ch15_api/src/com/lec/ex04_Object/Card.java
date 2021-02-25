package com.lec.ex04_Object;
//메인 만들기/
public class Card {
	private char kind;  //char 객체 아닌 기본.
	private int num;

	public Card(char kind, int num) { // 우클 -> 소스 -> 제너레이터 컨스트럭트 필드.

		this.kind = kind;
		this.num = num;
	}

	@Override
	public String toString() {
		return "카드모양은" + kind + " " + num;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj != null && obj instanceof Card) {
			boolean kindChk = this.kind == ((Card) obj).kind; //this. 생략 가능.
			boolean numChk = this.num == ((Card) obj).num; 
			
			return kindChk && numChk;

		}//"else {" 써도 안써도.
		return false;
		
		
		
	}

}
