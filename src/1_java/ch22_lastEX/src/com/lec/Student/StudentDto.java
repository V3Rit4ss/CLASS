package com.lec.Student;

public class StudentDto {
	private int rank;
	private String sNo;
	private String sName;
	private String mName;
	private int score;
	
	
	
	public StudentDto(int rank, String sNo, String sName, String mName, int score) {
		this.rank = rank;
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}




	@Override
	public String toString() {
		 return rank+"\t"+sName+"("+sNo+")\t"+mName + "\t"+score;
	}




}
