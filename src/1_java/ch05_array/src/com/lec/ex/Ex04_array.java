package com.lec.ex;
//2차원 배열
public class Ex04_array {
	public static void main(String[] args) {
	//	int[] test = {10,20};  //일자로 잡히는걸 일차원 배열
		int[][] test = {{10,20,30} , {40,50,60}}; //이차원 배열 <두개의 방안에 각자 배열이 있는 형태.>
		test[0][2] = 300 ; //배열 값 바꾼거.
		System.out.println(test[0][2]);    //이차원  
		for(int i=0 ; i<test.length; i++) { //i<test.length -> i<2 로 바꿔써도 댐.
			for(int j=0 ; j<3 ; j++) { //test[i].length <- 이렇게 할수있음.
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);
			}
		}
	}
}
