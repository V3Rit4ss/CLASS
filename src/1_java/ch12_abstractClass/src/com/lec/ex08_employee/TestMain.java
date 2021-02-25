package com.lec.ex08_employee;

public class TestMain {
	public static void main(String[] args) {
		Employee[] employee = { new SalaryEmployee("ȫ�浿", 28000000) , new SalaryEmployee("������",70000000) , new SalaryEmployee("�����", 24000000) , new HourlyEmployee("�̾˹�", 100, 8500) , new HourlyEmployee("�ž˹�", 120, 9500)};
		for(Employee emp : employee) {
			System.out.println("======== ���� ���� ==========");
			System.out.println("�� �� :"+emp.getName());
			System.out.println("�� �� :"+emp.computePay());
			int incentive = emp.computeIncentive();
			if(incentive != 0) {
				System.out.println("�� �� �� :"+incentive);
			}
			System.out.println("�����ϼ̽��ϴ�.");
		}
	}
}
