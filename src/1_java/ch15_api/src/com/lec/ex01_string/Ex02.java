package com.lec.ex01_string;
// 다양한 String 의 method들
public class Ex02 {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = " ja  va ";
		System.out.println("1. concat : "+str1.concat(str2)); //abcXabcABCXabc  로 나오게 만듬.
		System.out.println("2. substring(3) : "+str1.substring(3));//3번째 부터 끝까지  자바는 0부터 시작함.
		System.out.println("2. substring(3,5) : "+str1.substring(3,5));//3~5번앞 까지
		System.out.println("4. length() : "+str1.length());//문자길이(7) length()-1 마지막부터
		System.out.println("5. toUpperCase() : "+str1.toUpperCase());//대문자로 나오게
		System.out.println("6. toLowerCase() : "+str2.toLowerCase());//소문자로
		System.out.println("7. charAt(3) : "+str1.charAt(3));//3번(index)째 문자 하나 가져오기
		System.out.println("8. indexOf : "+str1.indexOf("b"));//처음 b가 있는 index.
		System.out.println("9. indexOf(\"b\",3) : "+str1.indexOf("b",3));//3번째부터 b가 어디있나 
		System.out.println("10. lastIndexOf(\"b\") : "+str1.lastIndexOf("b"));//마지막 b 인덱스
		System.out.println("11. lastIndexOf(\"z\") : "+str1.lastIndexOf("z"));//없으면 -1
		System.out.println("12. equals(str2) : "+str1.equals(str2));//같으면 트루 다르면 false
		System.out.println("13. equalsIgnoreCase(str2) : "+str1.equalsIgnoreCase(str2));//문자열이 같은지 트루 또는 페일즈.
		System.out.println("14. trim() : "+str3.trim());//좌우 스페이스바 제거.
		System.out.println("15. replace('a', '몽') : "+str1.replace('a', '몽')); // 'a' 라는 것 대신 '몽' 출력
		System.out.println("16. replace(\"ab\", \"바꿔\") : "+str1.replace("ab", "바꿔"));  // ab(긴 스트링) 를 제거
		System.out.println("최종.  : "+str1);
		
		
		
		
		
	}
}
