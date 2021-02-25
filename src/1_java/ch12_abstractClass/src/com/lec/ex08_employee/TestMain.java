package com.lec.ex08_employee;

public class TestMain {
	public static void main(String[] args) {
		Employee[] employee = { new SalaryEmployee("홍길동", 28000000) , new SalaryEmployee("박직원",70000000) , new SalaryEmployee("윤사원", 24000000) , new HourlyEmployee("이알바", 100, 8500) , new HourlyEmployee("신알바", 120, 9500)};
		for(Employee emp : employee) {
			System.out.println("======== 월급 명세서 ==========");
			System.out.println("성 함 :"+emp.getName());
			System.out.println("월 급 :"+emp.computePay());
			int incentive = emp.computeIncentive();
			if(incentive != 0) {
				System.out.println("상 여 금 :"+incentive);
			}
			System.out.println("수고하셨습니다.");
		}
	}
}
