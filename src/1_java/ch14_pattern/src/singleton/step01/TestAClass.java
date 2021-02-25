package singleton.step01;

public class TestAClass {
	public static void main(String[] args) {
		AClass aobj = AClass.getInstance();    // 겟 메소드 가져오고
		aobj.setInVar(456);   //변수값 기입
		AClass bobj = AClass.getInstance();
		System.out.println(bobj.getIntVar());
	}
}
