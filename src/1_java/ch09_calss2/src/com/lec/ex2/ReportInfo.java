package com.lec.ex2;

public class ReportInfo {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	public ReportInfo() {}
	
	
	public ReportInfo(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor+eng+mat;
		avg = tot/3.0 ;
	}


	public void print() {
		System.out.printf("\t %s \t %d \t%d \t%d \t%d \t%.1f\n" , name, kor, eng, mat, tot, avg );
	}//"성명 : "+name+"\n국어 : "+kor+"\n영어 : "+eng+"\n수학 : "+mat+"\n총점 : "+tot+"\n평균 : "+avg 
	
	public void setName(String name) {
		this.name = name;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
}
