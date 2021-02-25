package singleton.step01;

public class AClass {
	private int intVar;
	private static AClass INSTANCE;    //2변수인 인스탄스 아무거나 써도 댐.
	public static AClass getInstance() {    //3getInatance() 메소드 아무거나 해도댐.
		if(INSTANCE == null) {       //if 4
		INSTANCE = new AClass();
		}
		return INSTANCE;    //5 리턴.
	}
	private AClass() {}  //생성자    //1퍼블릭을 프라이빗으로
	public int getIntVar() {
		return intVar;
	}
	public void setInVar(int intVar) {
		this.intVar = intVar;
	}
}
