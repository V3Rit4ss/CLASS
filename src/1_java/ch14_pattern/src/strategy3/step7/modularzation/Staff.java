package strategy3.step7.modularzation;

import strategy3.componemt.GetSalary;
import strategy3.componemt.JobMng;

public class Staff extends Person {
	private String part;
	public Staff(String id, String name , String part) {
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t[�μ�]"+part);
	}
	@Override
	public String toString() {
		return super.toString()+"\t[�μ�]"+part;
	}

}
