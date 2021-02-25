package com.lec.ex04_Object;
//���� �����/
public class Card {
	private char kind;  //char ��ü �ƴ� �⺻.
	private int num;

	public Card(char kind, int num) { // ��Ŭ -> �ҽ� -> ���ʷ����� ����Ʈ��Ʈ �ʵ�.

		this.kind = kind;
		this.num = num;
	}

	@Override
	public String toString() {
		return "ī������" + kind + " " + num;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj != null && obj instanceof Card) {
			boolean kindChk = this.kind == ((Card) obj).kind; //this. ���� ����.
			boolean numChk = this.num == ((Card) obj).num; 
			
			return kindChk && numChk;

		}//"else {" �ᵵ �Ƚᵵ.
		return false;
		
		
		
	}

}
