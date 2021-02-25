package com.lec.loop;
// 10. 9. 8. 7. 6. ... 1.
public class Ex07_while {
	public static void main(String[] args) {
		int i=10;
		while(i>=1 ) {
			System.out.print(i+". "); //(i--+". ") 이렇게 넣어도 되기는 하나 가독성이 조금 딸리기에 아래 형식 처럼 넣음.
			i--; // 요로코롬.
		}
		
		for(int j=10 ; j>=1 ; j--) {
			System.out.print(j+". ");
		}
	}
}
