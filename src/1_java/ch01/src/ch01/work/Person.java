package ch01.work;

public class Person {
	    private String name;
	    private String tel;
	    public Person(String name, String tel){
	        this.name = name;
	        this.tel = tel;
	    }

	    @Override
	    public String toString(){
	        return this.name + this.tel;
	    }
	}

