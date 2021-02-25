package com.lec.ex01_string;
// 친구 : 이름, 전화번호 생일(12-12) new Friend (이름 , 전번 , 생일)
//print() : 이름[홍 ], 전번[8888], 생일[12-12] 출력할 .
public class Friend {
	private String name; //데이터.
	private String tel;
	private String birth;
	public Friend() {} //매개변수 없는생성자.
	public Friend(String name, String tel, String birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	//f.prinf()  // 메인함수
	//System.out.println(f.toString())   //스트링으로 바꿔라 ~ toString
	public void print() { //리턴타입이 없으니까 보이드   //프린트 함수 생성.
		System.out.printf("[이름]&s,[전번]&s,[생일]&s\n", name, tel, birth);
	}
		//System.out.println(f.toString()) 
	@Override
	public String toString() {
		return "[이름]"+name+"[전화번호]"+tel+"[생일]"+birth;  // <- 객체 출력을 해서 보이게 하고싶은면 <-  com.lec.ex01_string.Friend@7d4991ad
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getBirth() {
		return birth;
	}
}
