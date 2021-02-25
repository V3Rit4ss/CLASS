package com.lec.ex;

public class Ex01_array {
	public static void main(String[] args) {
//		int i = 10; // 변수의 선언과 초기화 [한 곳의 주머니에 한개만.]
		int[] iArr = { 10, 20, 30, 40, 50 }; // 1. 배열변수 의 선언과 초기화 int[] iArr = {a,b,c,d,e,....}
		iArr[1] = 200; // 2.  1번방 안의 내용을 바꿈. [ 배열은 index로 접근(index:0~4) ] iArr[0] 번 부터 시작함.
		for(int idx=0 ; idx<5 ; idx++) { //일반 for문  [확장 for문 도 있음]
			System.out.println(iArr[idx]);
//			System.out.println(iArr[0]);  이렇게 해도 되지만 가독성 좋은걸로 바꿀수있음.
//			System.out.println(iArr[0]);
//			System.out.println(iArr[0]);
//			System.out.println(iArr[0]);
		}
		int[]iArr2 = new int[5];   //2. 배열변수 선언과 배열메모리 공간 확보      new라고 설정하면 공간을 정리해준다. 0 , null 같은걸로   //new 객체(데이터와)를 메모리안에 잡게해주는 역할.
		iArr2[0] = 999;  // 해당 공간만 변환을 해주면 그 공간만 바뀐 값으로 바뀐다.
		for(int idx=0 ; idx<iArr2.length ; idx++) { //idx (<=) iArr2 해당 설정값 오류가 나면 실행했을때 어디서 오류가 되었는지 알수있음. 궁금하면 해보셈. 
			System.out.println(idx+"번째 값 : "+ iArr2[idx]);
		}
		System.out.println("************구별선*************");
		int[] iArr3;// 3. 배열변수를 선언만 했을때. 주소는 4바이트.
		iArr3 = new int[5];  // 공간 확보. 0 0 0 0 0
		//System.out.println(iArr3[0]); //공간 확보 안되면 오류나옴.
		//for(int idx=0 ; idx<iArr3.length ; idx++) { //일반 for문 idx 장난질 가능.
		for(int temp : iArr3) { //확장for문   //일반 -> for(int idx=0 ; idx<iArr3.length ; idx++) //변수의 값을 바꿀땐 일반for문.
			temp = 10;			//확장 for문			// 일반-> iArr3[idx] = idx+1;	
		}
		for(int temp : iArr3) // 확장 for문 임시변수 temp idx출력을 못함. 단순 데이터 이동과 출력같은걸 할때. 값변경x 
			System.out.println(temp);
		}	
}