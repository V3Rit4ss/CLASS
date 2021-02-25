package singleton.step01;

public class SingletonClass {
 
		private int i;
		private static SingletonClass INSTANCE; //2.스태틱 변수 //싱글톤클래스의 객체주소. 첫 변수는 null 기초값. //메모리에는 들어가있지만 부르지를 못함.
		public static SingletonClass getInstance() {    //3.
			if(INSTANCE == null) {
				INSTANCE = new SingletonClass();
			}
			return INSTANCE;
		}
		private SingletonClass() {  //1.생성자를 프라이빗으로
			
			i=10;
			
		}
		public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
	}

