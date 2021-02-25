package com.lec.ex04_Object;
// ������ ��������� enum.
public class Rectanle {
	private int garo;
	private int sero;
	private String color;
	
	public Rectanle () { //()��ȣ �ȿ� �����ִ��ڸ�. ������ �Ű����� ���� ������.
		
		this.garo = 0;
		this.sero = 0;
		color = "����";
	}

	public Rectanle(int garo, int sero, String color) {
		
		this.garo = garo;
		this.sero = sero;
		this.color = color;
	}

	@Override
	public String toString() {
		return garo+"cm "+ sero + "cm " + " ���� :" + color + " �簢��.";
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj != null && obj instanceof Rectanle) {
			
			boolean garoCm = this.garo == ((Rectanle)obj).garo;
			boolean seroCm = this.sero == ((Rectanle)obj).sero;
			boolean colorChk = this.color.equals(((Rectanle)obj).color);
			//��Ʈ���� ���ϰ�������� ��.����.equals(((Ŭ�����̸�)obj).����
			return garoCm && seroCm && colorChk;
		}
		return false;
	}
	
}
