package singleton.step02;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("firstClass 형 객체 생성");
		System.out.println(singletonObject.getI());
		
		singletonObject.setI(999);
		System.out.println("변경후 i값(FristClasll 에서)"+singletonObject.getI());
		System.out.println("FirstClass 형 생성자 끝.");
	}
}
