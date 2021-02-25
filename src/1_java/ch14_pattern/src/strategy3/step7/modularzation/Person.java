package strategy3.step7.modularzation;//집가서 하기.

import strategy3.componemt.*;

public class Person {
	private String id;
	private String name;
	private JobImpl job;
	private GetImpl get;
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
		
	}
	public void job() {
		job.job();
	}
	public void get() {
		get.get();
	}
	public void print() {
		System.out.print("[ID]"+id+"\t[이름]"+name);
	}
	@Override
	public String toString() {
		return "[ID]"+id+"\t[이름]"+name;
		
	}
	public void setJob(JobImpl job) {
		this.job = job;
	}
	public void setGet(GetImpl get) {
		this.get = get;
	}
	
}
