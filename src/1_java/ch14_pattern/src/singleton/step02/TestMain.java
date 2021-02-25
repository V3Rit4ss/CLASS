package singleton.step02;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
		SecondClass secondObj = new SecondClass();
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("메인메소드에서 singObj안의 i값은");
		System.out.println(singObj.getI());
	}
}
