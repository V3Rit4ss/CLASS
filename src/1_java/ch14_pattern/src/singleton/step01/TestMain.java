package singleton.step01;

public class TestMain {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		System.out.println("�ʱ�ȭ�� i�� : "+obj1.getI());
		obj1.setI(999);
		System.out.println("obj1�� ���� ������ �� obj2�� �� : "+obj2.getI() );
	}
}
