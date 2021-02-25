package com.lec.supermarket;

public class SupermarketDto {
	private int cID;
	private String cTEL;
	private String cNAME;
	private int cPOINT;
	private int cAMOUNT;
	private String LevelName;
	private int forlevelUp;
	
	//insert.
	public SupermarketDto(String cNAME, String cTEL) {
		this.cNAME = cNAME;
		this.cTEL = cTEL;
	}
	
	
	
	//select .
	public SupermarketDto(int cID, String cTEL, String cNAME, int cPOINT, int cAMOUNT, String LevelName, int forlevelUp) {
		this.cID = cID;
		this.cTEL = cTEL;
		this.cNAME = cNAME;
		this.cPOINT = cPOINT;
		this.cAMOUNT = cAMOUNT;
		this.LevelName = LevelName;
		this.forlevelUp = forlevelUp;
	}
	
	
	
	
	@Override
	public String toString() {
		return cID+"\t"+cTEL + "\t" + cNAME + "\t" + cPOINT + "\t" + cAMOUNT + "\t" + LevelName + "\t" + forlevelUp;
	}
	
	public int getcID() {
		return cID;
	}
	public String getcTEL() {
		return cTEL;
	}
	public String getcNAME() {
		return cNAME;
	}
	public int getcPOINT() {
		return cPOINT;
	}
	public int getcAMOUNT() {
		return cAMOUNT;
	}
	public String getLevelName() {
		return LevelName;
	}
	public int getforlevelUp() {
		return forlevelUp;
	}
	
	
	
	
	
}
