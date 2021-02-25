package com.lec.ex01_string;
//스트링 단점의 보안점.   str의 객체를 그대로 쓰면서 추가된 정보만 확장해서 추가해준다. 즉, 여러가지 객체를 만들지 않는다.
public class Ex09_stringBuffer {
	public static void main(String[] args) {
		String str = new String ("abc");      //평소엥 하는.
		StringBuilder strBu = new StringBuilder("abc");
		System.out.println("1. "+strBu);  //append("def") 하기전.
		strBu.append("def"); // abcdef concat 과 비슷함
		System.out.println("2. "+strBu);
		strBu.insert(3, "AAA"); //3번 인덱스에 "AAA" 추가 =abc.AAA.def
		System.out.println("3. "+strBu);
		strBu.delete(3, 6); //3번 인덱스부터 6번앞 까지 삭제 = abcdef
		System.out.println("4. "+strBu);
		int capacitySize = strBu.capacity(); //가용 크기 를 확장시킬때.
		System.out.println("가용크기 : "+capacitySize); //19
		System.out.println("현재 strBu 의 해시코드 : "+strBu.hashCode());
		strBu.append("12345678901234567890"); //가용크기보다 더 추가 했을때. 가용크기와 해시코드가 변하는가?
		capacitySize = strBu.capacity();
		System.out.println("가용크기 변경 : "+capacitySize);
		System.out.println("변경후 strBu의 해시코드 : "+strBu.hashCode());  //해쉬코드는 변하지않고 가용크기만 늘어난다.
		
		strBu.ensureCapacity(1000); //가용크기를 인위적으로 늘렸을때.
		capacitySize = strBu.capacity();
		System.out.println("가용크기 변경 : "+capacitySize);
		System.out.println("변경후 strBu의 해시코드 : "+strBu.hashCode());  //역시나 해쉬코드는 변하지 않고 가용크기만 늘어남.
	}
}
