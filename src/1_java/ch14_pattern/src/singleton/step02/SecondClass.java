package singleton.step02;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("SecondClass ������");
		System.out.println(singletonObject.getI());
		System.out.println("SecondClass ������ ��===");
	}
}
