--[V] �׷��Լ� : SUM, AVG , MIN , MAX , COUNT , STDDEV ,VARIANCE
SELECT ENAME, ROUND(SAL, -3) FROM EMP; --������ �Լ�
SELECT SUM(SAL) FROM EMP; --�׷��Լ�
SELECT ENAME , SUM(SAL) FROM EMP;  -- ������� �׷����� ���� ��������.
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;  -- ���� DEPTNO �� �׷���� DEPTNO 

--1. �׷��Լ�
--EMP ���̺��� ��� SAL ���.
SELECT ROUND(AVG(SAL), 2) FROM EMP;
SELECT COUNT(SAL) FROM EMP;
SELECT COUNT(ENAME) FROM EMP;
SELECT COUNT(*) FROM EMP; --�ο�(��)�� ��ü
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT COMM FROM EMP; --(300, 500 1400 , 0)/14? /4? �� �Ϸ��µ� ����Ŭ������ ��� �ұ�?
SELECT AVG(COMM) FROM EMP; --�׷��Լ��� NULL���� �����Ѵ�.
SELECT COUNT(COMM), SUM(COMM), AVG(COMM)FROM EMP; --���� ����.
--EMP ���̺��� SAL �� ���,��,�ּڰ�,�ִ밪,�л�, ǥ������
SELECT ROUND(AVG(SAL)), SUM(SAL) ,MIN(SAL),MAX(SAL),ROUND(VARIANCE(SAL)),ROUND(STDDEV(SAL)) FROM EMP; 

--�μ���ȣ ��  �޿� �ִ�ġ --�׷������� ���� ����.
SELECT DEPTNO "�μ���ȣ" ,MAX(SAL) FROM EMP GROUP BY DEPTNO ORDER BY "�μ���ȣ" ;
--�׷��Լ��� ������,������,��¥�� ��� ��밡��
--�μ���ȣ���� ���� �Ի�⵵ , �ֱ��Ի�⵵
SELECT DEPTNO, MIN(HIREDATE), MAX(HIREDATE) FROM EMP GROUP BY DEPTNO;
SELECT MIN(ENAME), MAX(ENAME) FROM EMP;  --���ĺ� ���� ����.
SELECT COUNT(JOB) FROM EMP; --JOB �ʵ��� ����. 14�� �� ���´�.
SELECT COUNT(DISTINCT JOB) FROM EMP; --JOB�� ���� DISTINCT �� �Ἥ �ߺ��� �����ش�.

--����.
--��	(���) 80��12��17�� �����Ի�  :14,620��° 83��01��12�� �ֱ��Ի� :13,864��°
SELECT MIN(HIREDATE)||' ���� �Ի� : '||TRUNC(SYSDATE-MIN(HIREDATE))||'��°',
        MAX(HIREDATE)||' �ֱ� �Ի� : '||TRUNC(SYSDATE-MAX(HIREDATE))||'��°' FROM EMP;
--��	(���) 80��12��17�� �����Ի�  :14,620��° 83��01��12�� �ֱ��Ի� :13,864��°
SELECT MIN(HIREDATE)||' ���� �Ի� : '||TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)), '99,999')||'��°',
            MAX(HIREDATE)||' �ֱ� �Ի� : '||TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)), '99,999')||'��°' FROM EMP;

--10�� �μ� �Ҽ��� ����� ��ձ޿�.
SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 10 ;

--2. GROUP BY ��
--EX.�μ���ȣ��. �ִ�޿�
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;

--SELECT ENAME , HIREDATE FROM EMP WHERE HIREDATE=(SELECT MAX(HIREDATE) FROM EMP); -- ��������

--�μ� ��ȣ�� �����, �ִ�޿� , �ּұ޿�, ��ձ޿�
SELECT DEPTNO , COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL)) FROM EMP GROUP BY DEPTNO;

--�μ��� ��, �����, �ִ�޿�,�ּұ޿�, ��ձ޿�,
SELECT DNAME , COUNT(*) , MAX(SAL), MIN(SAL) ,ROUND(AVG(SAL)) FROM EMP E, DEPT D  WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;

SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;
--SELECT [DEPTNO, JOB], SUM(SAL) FROM EMP GROUP BY [DEPTNO, JOB] ORDER BY DEPTNO;  [] ���� ������ ���ƾ��Ѵ�.


--3. HAVING ����

--SELECT column, group_function
--FROM table
--[WHERE condition]
--[GROUP BY group_by_expression]
--[HAVING   group_condition]
--[ORDER BY column] ;
--���� - ���� - �׷�- ��� - �������� ��.

--DEPTNO ���� ��ձ޿� (AVG(SAL)�� 2000�̻��� �μ��� ���)
SELECT DEPTNO, AVG(SAL)  FROM EMP WHERE AVG(SAL)>2000 GROUP BY DEPTNO; --����.
SELECT DEPTNO, AVG(SAL)  FROM EMP GROUP BY DEPTNO HAVING AVG(SAL)>2000;

--4. �ǹ����̺�
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;
--1�ܰ�
SELECT DEPTNO, DECODE(JOB, 'CLERK', SAL, 0) CLERK,
           DECODE(JOB, 'MANAGER', SAL, 0) MANAGER,
           DECODE(JOB, 'PRESIDENT', SAL, 0) PRESIDENT,
           DECODE(JOB, 'ANALYST', SAL, 0) ANALYST,
           DECODE(JOB, 'SALESMAN', SAL, 0) SALESMAN FROM EMP;

--2�ܰ�
SELECT DEPTNO , SUM(DECODE(JOB, 'CLERK', SAL, 0)) "CLERK", 
    SUM(DECODE(JOB, 'MANAGER',SAL, 0)) "MANAGER", 
    SUM(DECODE(JOB, 'PRESIDENT',SAL, 0))"PRESIDENT",
    SUM(DECODE(JOB, 'ANALYST',SAL, 0))"ANALYST",
    SUM(DECODE(JOB, 'SALESMAN',SAL, 0))"SALESMAN" FROM EMP GROUP BY DEPTNO;  --�ǹ����̺�

--3�ܰ� �հ� �߰�.
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);  --�հ� �߰�.

SELECT DEPTNO , SUM(DECODE(JOB, 'CLERK', SAL, 0)) "CLERK", 
    SUM(DECODE(JOB, 'MANAGER',SAL, 0)) "MANAGER", 
    SUM(DECODE(JOB, 'PRESIDENT',SAL, 0))"PRESIDENT",
    SUM(DECODE(JOB, 'ANALYST',SAL, 0))"ANALYST",
    SUM(DECODE(JOB, 'SALESMAN',SAL, 0))"SALESMAN" , SUM(SAL) "�μ����Ұ�" FROM EMP GROUP BY ROLLUP(DEPTNO);


--ROLLUP
SELECT JOB, AVG(SAL) FROM EMP GROUP BY ROLLUP(JOB);
SELECT DEPTNO, JOB, AVG(SAL) FROM EMP GROUP BY ROLLUP (DEPTNO, JOB);



-- ��<�� ��������>

-- 1. ��� ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ���
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP;


-- 2. ������̺��� ������ �ο����� ���Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB;

--- 3. ������̺��� �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ����ϴ� SELECT������ �ۼ��Ͽ���.
SELECT MIN(SAL), MAX(SAL), MAX(SAL)-MIN(SAL) FROM EMP;
SELECT MAX(SAL)-MIN(SAL) FROM EMP;

-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ����ϵ� �޿��� ���� ���� ������ ����϶�.
SELECT DEPTNO, COUNT(*), ROUND(AVG(SAL)), MIN(SAL) , MAX(SAL), SUM(SAL) FROM EMP 
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;
    
SELECT DEPTNO, COUNT(*), ROUND(AVG(SAL)), MIN(SAL), MAX(SAL), SUM(SAL) FROM EMP    
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;
    
SELECT DNAME, COUNT(*), ROUND(AVG(SAL)), MIN(SAL), MAX(SAL), SUM(SAL) FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    ORDER BY SUM(SAL) DESC;
    
-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� 
    --���Ͽ� ����϶�(��°���� �μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB ,COUNT(*), ROUND(AVG(SAL)), SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;

SELECT DNAME , JOB , COUNT(*), ROUNF(AVG(SAL)), SUM(SAL) FROM EMP E , DEPT D WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME, JOB ORDER BY DNAME, JOB;


-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� 
-- ����϶�.(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO ,COUNT(*), ROUND(AVG(SAL)), SUM(SAL) FROM EMP GROUP BY JOB, DEPTNO ORDER BY JOB, DEPTNO;



--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ����Ͻÿ�.
SELECT DEPTNO, COUNT(*) FROM EMP GROUP BY DEPTNO HAVING COUNT(*) >= 5;




-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ����Ͻÿ�

SELECT DNAME, COUNT(*) FROM EMP E, DEPT D WHERE E.EMPNO=D.DEPTNO GROUP BY DNAME HAVING COUNT(*) >= 5;





--9. ��� ���̺��� ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, 
--�޿��� ���� ���Ͽ� ����϶�
SELECT JOB, AVG(SAL),SUM(SAL)  FROM EMP GROUP BY JOB HAVING AVG(SAL)>=3000;




--10. ������̺��� �޿����� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿��հ踦 ����϶� 
        --��, �޿� �հ�� �������� �����϶�.
SELECT JOB , SUM(SAL) FROM EMP GROUP BY JOB HAVING SUM(SAL) > 5000 ORDER BY SUM(SAL) DESC;

SELECT JOB , SUM(SAL) "SUMSAL" FROM EMP GROUP BY JOB HAVING SUM(SAL) > 5000 ORDER BY "SUMSAL" DESC; --�������������� ���� ����.


--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ����϶�.
SELECT DEPTNO , ROUND(AVG(SAL)) , SUM(SAL) , MIN(SAL) FROM EMP GROUP BY DEPTNO;

SELECT DNAME , ROUND(AVG(SAL)) , SUM(SAL) , MIN(SAL) FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;


--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, 
            --�μ��� �ּұ޿��� �ִ�ġ�� ����϶�.
            
SELECT MAX(AVG(SAL)), MAX(SUM(SAL)) , MAX(MIN(SAL)) FROM EMP GROUP BY DEPTNO;
SELECT ROUND(MAX(AVG(SAL))) , MAX(SUM(SAL)) , MAX(MIN(SAL)) FROM EMP GROUP BY DEPTNO;


--13. ��� ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(�⵵�� ������)
-- H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--  80	      1		    800		    800		    800		    800
--	81	     10	        950		    5000	    2282.5	  22825
--	82	      2		    1300	    3000	   2150		   4300
--	83	      1		    1100	    1100	    1100	   1100

SELECT TO_CHAR(HIREDATE, 'YY') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), ROUND(AVG(SAL)), SUM(SAL) FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'YY') ORDER BY H_YEAR;

SELECT SUBSTR(EXTRACT(YEAR FROM HIREDATE),3, 2) H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), ROUND(AVG(SAL)), SUM(SAL) FROM EMP
    GROUP BY SUBSTR(EXTRACT(YEAR FROM HIREDATE),3, 2) ORDER BY H_YEAR;
    
-- 14.  ������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�
-- TOTAL	1980	1981	1982	1983
--  14		  1	     10	      2	      1

SELECT EXTRACT(YEAR FROM HIREDATE), COUNT(*) FROM EMP GROUP BY ROLLUP(EXTRACT(YEAR FROM HIREDATE));
SELECT COUNT(*) TOTAL,
    COUNT(DECODE(EXTRACT(YEAR FROM HIREDATE), '1980',1)) "1980",
    COUNT(DECODE(EXTRACT(YEAR FROM HIREDATE), '1981',1)) "1981",
    COUNT(DECODE(EXTRACT(YEAR FROM HIREDATE), '1982',1)) "1982",
    COUNT(DECODE(EXTRACT(YEAR FROM HIREDATE), '1983',1)) "1983" FROM EMP;



--15. ������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�(JOB ������ �������� ����)
-- JOB��, DEPTNO�� SUM(SAL)
--JOB		DEPTNO10	DEPTNO20	DEPTNO30     TOTAL
--ANALYST	     0		   6000		    0		6000
--CLERK		  1300		   1900		  950		4150
--��.
--SALESMAN	      0	 		0	 5600		 5600

SELECT JOB, DECODE(DEPTNO, 10, SAL, 0) "DEPTNO10",
    DECODE(DEPTNO, 20, SAL, 0) "DEPTNO20",
    DECODE(DEPTNO, 30, SAL, 0) "DEPTNO30"
    FROM EMP ORDER BY JOB;

SELECT JOB, SUM(DECODE(DEPTNO, 10, SAL ,0)) "DEPTNO10",
    SUM(DECODE(DEPTNO, 20, SAL, 0)) "DEPTNO20",
    SUM(DECODE(DEPTNO, 30, SAL, 0)) "DEPTNO30",
    SUM(SAL) "TOTAL" FROM EMP GROUP BY JOB ORDER BY JOB;
    
SELECT DEPTNO , SUM(DECODE(JOB, 'CLERK', SAL, 0)) "CLERK",     --DECODE(JOB, 'CLERK', SAL, 0)  ���ξ��� ���� 0���� ���Ͷ� OR 1�� ���Ͷ�.
    SUM(DECODE(JOB, 'MANAGER',SAL, 0)) "MANAGER", 
    SUM(DECODE(JOB, 'PRESIDENT',SAL, 0))"PRESIDENT",
    SUM(DECODE(JOB, 'ANALYST',SAL, 0))"ANALYST",
    SUM(DECODE(JOB, 'SALESMAN',SAL, 0))"SALESMAN" , SUM(SAL) "�μ����Ұ�" FROM EMP GROUP BY ROLLUP(DEPTNO);
--�ǹ�?

        
--16. ������̺��� �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���Ͻÿ�
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL), 2) FROM EMP;

--17. ������̺��� �μ��� �ο����� ���Ͻÿ�
SELECT DNAME ,COUNT(*) FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;
SELECT DEPTNO , COUNT(*) FROM EMP GROUP BY DEPTNO;

--18. ��� ���̺��� �μ��� �ο����� 6���̻��� �μ��ڵ带 ���Ͻÿ�
SELECT DNAME , COUNT(*) FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME HAVING COUNT(*) >= 6;
SELECT DEPTNO, COUNT(*) FROM EMP GROUP BY DEPTNO HAVING COUNT(*) >= 6;



--19. ������̺��� ������ ���� ����� ������ �Ͻÿ�
--DNAME               CLERK    MANAGER  PRESIDENT  ANALYST   SALESMAN
--ACCOUNTING          1300       2450       5000          0           0
--RESEARCH             1900       2975           0       6000          0
--SALES                  950       2850           0          0       5600

SELECT DNAME, DECODE(JOB, 'CLERK' , SAL ,0) "CLERK",
    DECODE(JOB, 'MANAGER' , SAL ,0)  "MANAGER",
    DECODE(JOB, 'PRESIDENT', SAL, 0) "PRESIDENT",
    DECODE(JOB, 'ANALYST', SAL, 0) "ANALYST",
    DECODE(JOB, 'SALESMAN', SAL, 0) "SALESMAN" FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;

SELECT DNAME, SUM(DECODE(JOB, 'CLERK', SAL, 0)) "CLERK",
    SUM(DECODE(JOB, 'MANAGER', SAL, 0)) "MANAGER",
    SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) "PRESIDENT",
    SUM(DECODE(JOB, 'ANALYST', SAL, 0)) "ANALYST",
    SUM(DECODE(JOB, 'SALESMAN' , SAL ,0)) "SALESMAN" FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;

--20.  ������̺��� �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--����
SELECT E1.ENAME, COUNT(E2.ENAME)+1 "���" FROM EMP E1, EMP E2 WHERE E1.SAL<E2.SAL(+) GROUP BY E1.ENAME ORDER BY "���";

SELECT ENAME, SAL,
    RANK() OVER(ORDER BY SAL DESC) "RANK",
    DENSE_RANK() OVER(ORDER BY SAL DESC) "DENSE_R",
    ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUM" FROM EMP;