package com.lec.studentGUI;

public class StudentSwingDto {
	private int rank;
	private String sNo;
	private String sName;
	private String mName;
	private int score;
	//insert
	public StudentSwingDto(int rank, String sName, String mName, int score) {
		this.rank = rank;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}
	//select 
	public StudentSwingDto(String sNo, String sName, String mName, int score ) {
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
		
	}
	
	
	public int getRank() {
		return rank;
	}
	public String getsNo() {
		return sNo;
	}
	public String getsName() {
		return sName;
	}
	public String getmName() {
		return mName;
	}
	public int getScore() {
		return score;
	}
	@Override
	public String toString() {
		if(rank != 0) {
			
			return rank+"��\t"+sName+"\t"+mName+"\t"+score;
			
		}else {
			return sNo+"\t"+sName+"\t"+mName+"\t"+score;
		}
	}
	
	
	
}
