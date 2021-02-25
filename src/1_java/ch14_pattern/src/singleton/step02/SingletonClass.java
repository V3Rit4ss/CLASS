package singleton.step02;
//private static SingletonClass INSTANCE = new SingletonClass();   if 문 안쓸라면.
public class SingletonClass {
	private static SingletonClass INSTANCE;   //  //싱글톤 = int  , 인스탄스 = i 
	private            int           i;
	private SingletonClass() {
		i = 10 ;
	}
	public static SingletonClass getInstance() {
		if(INSTANCE == null) {    //if문을 안쓸라면 위에 =new 처럼.
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
