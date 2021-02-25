package com.lec.ex;
// 형변환 = 묵시적인 형변환, 명시적인 형변환
public class varEx07 {
	public static void main(String[] args) {
		int i1 = 10; //4byte 값을 넣음
		long l1 = 22000000000L; 
		l1 = 10;   //long 형 8byte 값에 4byte 짜리 10을 할당하기 위해 4byte 짜리 10이 8byte형으로 묵시적인 형변환을 함.
		double d = i1; //묵시적인 형변환 큰 방에 작은 상자가 들어간 격. (나머지 남은 자리는 0으로 표시댐)
		d = 10.7;
		i1 = (int)d;  //명시적인 형변환(대놓고 바꿔!) 시에는 데이터 손실이 올수 있다 (즉 뒷자리가 짤린다)
		System.out.print("i1="+i1);
	}
}
