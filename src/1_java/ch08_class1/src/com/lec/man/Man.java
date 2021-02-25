package com.lec.man;
// Man kim = new Man(20,170,60,"010-9999-9999");
//Man yi = new Man(20,170,60);
//Man kang = new Man(20,"010-9999-9999");
public class Man {
	private int age;
	private int height;
	private int weight;
	private String tel; //전화번호는 스트링으로
	public Man() {} // 디폴트 생성자
	public Man(int age, int height , int weight,  String tel) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.tel = tel;
	}
	public Man(int age, int height , int weight ) {
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	public Man(int age, String tel) {
		this.age = age ;
		this.tel = tel ;
	}
	//BMI 지수를 변환하는 메소드
	public double calculateBMI() {
		double result = weight / ((height*0.01)*(height*0.01));
		return result;
	}
	//~.setAge()
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setHeight( int height) {
		this.height = height ;
	}
	public int getHeight() {
		return height ;	
		}
	public void setWeight (int weight) {
		this.weight =  weight;
	}
	public int getWeight() {
		return weight ;
	}
	public void setTel (String tel) {
		this.tel = tel ;
	}
	public String getTel () {
		return tel ;
	}
	
}
