package strategy3.step7.modularzation;

import strategy3.componemt.GetStudentPay;
import strategy3.componemt.JobSutdy;

public class Student extends Person {
	private String ban;
	
	public Student(String id, String name , String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobSutdy());
		setGet(new GetStudentPay());
	}
	@Override
	public void print() {
		
		super.print();
		System.out.println("\t[¹Ý]"+ban);
	}
	@Override
	public String toString() {
		
		return super.toString()+"\t[¹Ý]"+ban;
	}

	
}
