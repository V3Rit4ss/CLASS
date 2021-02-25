package com.lec.ex03_set;

public class Student {
	private String name;
	private int grade;
	public Student(String name, int grade) {
		
		this.name = name;
		this.grade = grade;
	}
	@Override
	public String toString() {
		
		return name + ":" +grade; //   "ȫ�浿:5"
	}
	
	@Override// new Student("�庸��",1).equlas(new Student("�庸��",1)) �̷� �۾��� �Ѵ�.
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj!=null && obj instanceof Student) {
			boolean nameChk = name.equals(((Student)obj).name);
			boolean gradeChk = grade == ((Student)obj).grade;
			return nameChk && gradeChk;  //���� ���� �Ʒ��� ����
		//	return toString().equals(obj.toString());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return toString().hashCode();  //         ����Ʈ������  "�庸��:1" �׷��� �ؽ��ڵ带 ������ �ؽ��ڵ带 ����.
		
	}
}
