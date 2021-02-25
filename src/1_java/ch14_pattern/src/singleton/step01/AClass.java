package singleton.step01;

public class AClass {
	private int intVar;
	private static AClass INSTANCE;    //2������ �ν�ź�� �ƹ��ų� �ᵵ ��.
	public static AClass getInstance() {    //3getInatance() �޼ҵ� �ƹ��ų� �ص���.
		if(INSTANCE == null) {       //if 4
		INSTANCE = new AClass();
		}
		return INSTANCE;    //5 ����.
	}
	private AClass() {}  //������    //1�ۺ��� �����̺�����
	public int getIntVar() {
		return intVar;
	}
	public void setInVar(int intVar) {
		this.intVar = intVar;
	}
}
