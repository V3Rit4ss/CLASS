package singleton.step01;

public class SingletonClass {
 
		private int i;
		private static SingletonClass INSTANCE; //2.����ƽ ���� //�̱���Ŭ������ ��ü�ּ�. ù ������ null ���ʰ�. //�޸𸮿��� �������� �θ����� ����.
		public static SingletonClass getInstance() {    //3.
			if(INSTANCE == null) {
				INSTANCE = new SingletonClass();
			}
			return INSTANCE;
		}
		private SingletonClass() {  //1.�����ڸ� �����̺�����
			
			i=10;
			
		}
		public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
	}

