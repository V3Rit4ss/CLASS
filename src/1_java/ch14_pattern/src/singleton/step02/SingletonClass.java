package singleton.step02;
//private static SingletonClass INSTANCE = new SingletonClass();   if �� �Ⱦ����.
public class SingletonClass {
	private static SingletonClass INSTANCE;   //  //�̱��� = int  , �ν�ź�� = i 
	private            int           i;
	private SingletonClass() {
		i = 10 ;
	}
	public static SingletonClass getInstance() {
		if(INSTANCE == null) {    //if���� �Ⱦ���� ���� =new ó��.
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
