package strategy3.step7.modularzation;

import strategy3.componemt.GetSalary;
import strategy3.componemt.JobLec;

public class Lecturer extends Person {
	private String subject;
	public Lecturer(String id, String name , String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	
	@Override
	public void print() {
		
		super.print();
		System.out.println("\t[����]"+subject);
	}
	@Override
	public String toString() {

		
		return super.toString()+"\t[����]"+subject;
	}

}
