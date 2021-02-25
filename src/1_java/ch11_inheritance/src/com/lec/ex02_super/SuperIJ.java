package com.lec.ex02_super;

public class SuperIJ {
	private int i;
	private int j;
	public SuperIJ() {
		System.out.println("매개변수 없는거");  // 매개변수가 없으면 상속할때 문제가 생길수있다.
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("매개변수 있는거");
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
}
