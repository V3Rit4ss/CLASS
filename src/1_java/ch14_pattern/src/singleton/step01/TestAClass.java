package singleton.step01;

public class TestAClass {
	public static void main(String[] args) {
		AClass aobj = AClass.getInstance();    // �� �޼ҵ� ��������
		aobj.setInVar(456);   //������ ����
		AClass bobj = AClass.getInstance();
		System.out.println(bobj.getIntVar());
	}
}
