-- [II] select ��    -- �� �ּ� ó����.   SQL�� ��ҹ��� ������ ���⿡ �빮�ڷ� ����.
SELECT * FROM TAB;   -- ������ SCOTT�� ������ �ִ� ���̺�� ( ��+���� �ϸ� �ؿ� ǥ������)
SELECT * FROM DEPT; --DEPT���̺��� ��� ���� ��� ���� �����ִ�.
SELECT * FROM EMP; -- EMP���̺��� ����� ��翭 �����ִ�.
SELECT * FROM TAB;  --SCOTT �� �����ϰ��ִ� ���̺��� ���� ������
SELECT * FROM DEPT; --DEPT ���̺� ������ ��ü ������
DESC DEPT;   --DEPT ���̺��� ��������.
SELECT * FROM EMP;
SELECT EMPNO, ENAME, SAL , JOB FROM EMP;
SELECT empno AS "���", ename AS "���� �̸�", job AS "����" FROM emp; -- ������ �����ٶ�
SELECT empno ���, ename �̸�, job ���� FROM emp;  --AS �� �ִ� ���� ""�� �ִ� ���� ����.
SELECT empno AS NO, ename AS NAME, job FROM emp; --�ѱ� , ���� �Ѵ� ����.
SELECT empno, ename, job FROM emp;      -- ����� �̸� �������� ���������.

--3. WHERE �� (����) �񱳿����ڸ� �̿�
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP  --Ư���� ����
    WHERE SAL=3000;  -- SAL �� 3000�� �ุ �����.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL!= 3000;    
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL^= 3000;  --�´� �ٸ��� ��� �Ѵ�.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<> 3000;  

--10�� �μ��� ����� ��� �ʵ带 ���
SELECT * FROM EMP WHERE DEPTNO=10;  
--ENAME �� 'FORD'�� ������ ��� �ʵ带 ���
SELECT * FROM EMP WHERE ENAME='FORD';  --�����ʹ� ��ҹ��� ���� ����.
select * from emp where ename='ford';   --�ȳ���.
-- �޿��� 2000�̻� 3000�̸��� ������ ��� �ʵ带 ���.
SELECT * FROM EMP WHERE SAL>= 2000 AND SAL<3000;  --AND => &  OR => |
--�񱳿����� ���� , ����, DATE�� (��¥) ��� ����.
SELECT * FROM EMP WHERE ENAME < 'F';  --�̸��� F���� ���� ��� �ѷ���.  ABCDE �� �����ϴ� ��� �ѷ���.
-- �� ���� ���� ��� �ѷ��� = ������ �̸��� ����.
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';  --81�⵵ ���� ������� �ѷ���
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';  --82�⵵ ���� ũ��  82�� 12.31 ���� ���� �����.
--��¥ ǥ�ù� ����
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD';  --��¥ Ÿ�� �ٲ�.
--������ 2400�̻��� ������ ENAME , SAL , ���� ���(����=SAL*12)  '' ������. ""����
SELECT ENAME �̸�, SAL �޿�, SAL*12 ���� FROM EMP WHERE SAL*12>2400 ORDER BY ����;  --WHERE ������ ������ ������������. 
 -- 1������ 2���� �� 3����Ʈ�� 4������  �������� ������ ���� �߱⶧���� ���������� �������� �Ѱ��� �˾Ƽ� �����ִ� --ORDER BY ������ ���� ����.      
--5. ��� ǥ����  �ƹ��뼭�� ����.
SELECT ENAME, SAL , SAL+300 UPGRADESAL FROM EMP;
--������� �����, ����(SAL),����(SAL*12+COMM(�󿩱�))
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM,0) FROM EMP; --�ΰ� ��� ��ġ�� �����Ѱ� �־��
--��������� ����� NULL�� �����ϸ� ����� NULL -> NVL(NULL �ϼ��� �ִ� �ʵ��, ��ġ��)  ���� Ÿ���� ���ƾ���.
DESC EMP;  -- COMM ������ NUMBER �� �ѹ��� ����.
--������� �����, ����(SAL), COMM ,����(SAL*12+COMM(�󿩱�)) COMM�� NULL�̸� 0���� ����.
SELECT ENAME, SAL, NVL(COMM, '0$'), SAL*12+NVL(COMM, 0) FROM EMP;  --'0$' �ѹ� Ÿ���� �ƴ϶� �ȴ�. �Ϸ��� ����ȯ �ؾ���.
--��� ����� �����(ENAME), ����� ���(MGR) ��簡 ������ CEO ��ºҰ�  =0���� ����غ���
SELECT ENAME, NVL(MGR, 0) FROM EMP;
--���� ������.( || ) = ���̳� ���ڸ� ������.
SELECT ENAME || ' �� ' || JOB || ' �̴�'  FROM EMP;
 --"SMITH IS CLERA" �� ��µǰ� TITLE EMPLOYEES ��� ��� ���� ���
 SELECT ENAME || ' IS ' || JOB EMPLOYEES FROM EMP;
 --�ߺ�����  = DISTINCT
 SELECT DISTINCT JOB FROM EMP;   --������ �� ���̿�.
 SELECT DISTINCT MGR FROM EMP;
 
--�߰� ��������.
--1. emp ���̺��� ���� ���
DESC EMP;
--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;
--3. �� scott �������� ��밡���� ���̺� ���
SELECT * FROM TAB;
--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME ,SAL, JOB, HIREDATE FROM EMP;
--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000 ;
--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME , JOB, HIREDATE FROM EMP WHERE HIREDATE>='81/02/01';
--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB='SALESMAN';
--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB!='CLERK'; -- != , <> , ^= ������ �ƹ��ų�.
--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL <=3000;
--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;
--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL>=3000;
--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME ,JOB, SAL FROM EMP WHERE SAL>=2500 AND JOB='MANAGER';
--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���
SELECT ENAME || '��(��) '||JOB||'�����̰� ������'||(SAL*12+NVL(COMM,0)) || '��' FROM EMP;

--8��. SQL ������. 	DISTINCT : �ߺ����� 
--SAL �� 1500�̻��̰� 3000���ϸ� ���, �̸�, �޿� ��� �� SQL �����ڷ� �Ẹ��
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL <=3000;
--�ʵ�� BETWEEN A AND B (A~B���� , A�� B ����.) ���ڿ� ����Ʈ���� ����.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
--82�⵵�� �Ի��� ������ ��� �ʵ带 ���.
SELECT EMPNO, ENAME , JOB, HIREDATE FROM EMP WHERE HIREDATE>='81/01/01' AND HIREDATE<= '82/12/31';
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31'; --�տ� �����Ͱ� �۾ƾ���.
--�̸��� A~C�� �����ϴ� ���.
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D';  --�� + D �� �ϸ� �ϴ� ����.  �ڹٿ����� ���������.
                                                    -- ENAME != 'D' D�� ����~
--�μ���ȣ (DEPTNO) �� 10,20 �� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO =20;
SELECT * FROM EMP WHERE DEPTNO IN (10,20);  --IN ������
                                                    
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20); --�μ���ȣ�� 10�� 20�� �ƴ� �����.
-- EMPNO �� 7902, 7788 7566 �� ����� ��� �ʵ�.
SELECT *FROM EMP WHERE EMPNO IN (7902, 7788, 7566);
--�̸��� M ���� �����ϴ� ����� ��� �ʵ�.  M_(����ٴ� �ѱ��ڼ�.) ,  M% 0���� �̻�. 
SELECT * FROM EMP WHERE ENAME LIKE 'M%'; --0���� �̻�.  ����ũ�� ���ڿ� ���� ���δ�.
-- �̸��� N�� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%N%';  -- �հ� �߰� �ڿ� ���� �ֵ��� ã���ش�.
--�̸��� S �� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S';
--�̸��� %�� ���� ����� ��� �ʵ�
INSERT INTO EMP VALUES (9999,'A%',NULL,NULL,NULL,9000,9000,40);--�ش� ���̺��� ��� ���� �־���Ѵ�.
--������ ���̺� ���� �����͸� ������� INSERT INTO ���̺� VALUES (���̺� ����ĭ ������ �°�.);
SELECT * FROM EMP;
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';  --% �� �������� �ִ°Ŵ� �̷���.
ROLLBACK; --(DML ������ ���۾ ���) 
SELECT * FROM EMP;  --A% �߰��Ȱ��� ��Ҵ�.
--SAL �� 5�� ������ ����� ��� �ʵ�.   VACHAR ����.
SELECT * FROM EMP WHERE SAL LIKE '%5';  --���ڵ� ����Ʈ���� �Ǳ���.
--�Ի�⵵�� 82���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE >='82/01/01' AND HIREDATE <= '82/12/31' ;
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31' ;
SELECT * FROM EMP WHERE HIREDATE LIKE '82/__/__' ;
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';

SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('1982/01/01','YYYY/MM/DD') AND TO_DATE('1982/12/31', 'YYYY/MM/DD');
--Ÿ���� �� �ٸ��� �̷��� �ؼ� �ٲ���� �Ѵ�.

--1���� �Ի��� ����� ��� �ʵ� ���  '%/01/%'
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
--�󿩱��� ���� ����� ��� �ʵ� ���.
SELECT COMM FROM EMP; --COMM �� ��� �ִ��� ����.
SELECT * FROM EMP WHERE COMM=0 OR COMM IS NULL;  --�ΰ��� �̰������ IS NULL �� �ؾ���.
--�󿩱��� �ִ� ����� ��� �ʵ� ���.
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM!=0;   --�ε� �ƴϰ� 0�� �ƴ� ����.

--9.���� (��������, ��������)
SELECT ENAME , SAL FROM EMP ORDER BY SAL; --�������� ����   ORDER BY SAL(ASC); ���ξ��� ���� ������.
SELECT ENAME , SAL FROM EMP ORDER BY SAL DESC; -- �������� ����
--SAL �� ���� ������ ���(��, ���� SAL �� ��� �Ի��� �ֽ� ������ ����.)
SELECT * FROM EMP ORDER BY SAL DESC, HIREDATE ; --SCOTT �� FORD �� �Ի��� ���̿� ���� ������ ��������.
SELECT * FROM EMP ORDER BY SAL DESC, HIREDATE DESC; --������ ���̴� �Ի��ϱ������� ������¥�� ������������.
SELECT * FROM EMP ORDER BY SAL DESC, HIREDATE DESC, ENAME;  -- �̸�������� �����ٶ� ABCD 
SELECT * FROM EMP ORDER BY ENAME;
--�̸�,����(SAL*12+COMM)�� ��� (������ ���� �� ����) --ORDER BY ����(����) DESC; �̷��� ����.
SELECT ENAME, SAL*12+NVL(COMM,0) ���� FROM EMP ORDER BY SAL*12+NVL(COMM,0) DESC;
--�̸�,������ 2000�̻��� ������ �̸�,������ ��� (������ ������) --WHERE ������ ������ �־����. ���� �ִ°� �Ұ�.
SELECT ENAME, SAL*12+NVL(COMM,0) ���� FROM EMP WHERE SAL*12+NVL(COMM,0) >= 2000 ORDER BY ���� DESC;


--���ݱ����� ��� �͵��� ������.

--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 3000 ORDER BY SAL;
 
--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO = '7788' ;

--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME ,SAL FROM EMP WHERE (SAL*12+NVL(COMM,0)) >= 24000 ORDER BY SAL;

--4.	EMP ���̺��� hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� 
--ename,job,hiredate�� ����ϴ� SELECT ������ �ۼ� (�� hiredate ������ ���)
SELECT ENAME , JOB, HIREDATE FROM EMP WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' ORDER BY HIREDATE;

--5.	EMP ���̺��� deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN (10,20) ORDER BY ENAME;

--6.	EMP ���̺��� sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT * FROM EMP;
DESC EMP;
SELECT ENAME employee , SAL "monthly" FROM EMP WHERE SAL >= 1500 AND DEPTNO IN (10,30);

--7.	EMP ���̺��� hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY/MM/DD') LIKE '1982&';
--��¥�� -> ������ TO_CHAR(HIREDATE, 'YYYY/MM/DD') = '1982/02/14'
--������ -> ��¥�� TO_DATE('1982/12/12','YYYY/MM/DD') =��¥������ �ٲ�.
 
--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME , SAL FROM EMP 
            WHERE (ENAME BETWEEN 'C' AND 'Q') AND ENAME != 'Q' ORDER BY ENAME; --Q ���� ������ AND ENAME!='Q' ���ϸ� Q�� ����.

--9.	EMP ���̺��� comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--����ϴ� SELECT ���� �ۼ�
SELECT ENAME , SAL, COMM FROM EMP WHERE COMM>SAL*1.1;

--10.	EMP ���̺��� job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP WHERE (JOB = 'CLERK' OR JOB = 'ANALYST') AND SAL NOT IN (1000, 3000, 5000) ;
SELECT * FROM EMP WHERE JOB IN('CLERK' , 'ANALYST') AND SAL NOT IN (1000, 3000, 5000);
SELECT * FROM EMP WHERE (JOB = 'CLERK' OR JOB = 'ANALYST') AND NOT ( SAL IN (1000,3000,5000));

--11.	EMP ���̺��� ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND (DEPTNO = 30 OR MGR = 7782);

--12.	��� ���̺��� �Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/__/__';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE BETWEEN '81/01/01' AND '81/12/31';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE BETWEEN TO_DATE('1981/01/01' , 'YYYY/MM/DD')
                                                                        AND TO_DATE('1981/12/31' , 'YYYY/MM/DD');
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'YYMMDD') BETWEEN '810101' AND '811231';  
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'YYMM') BETWEEN '8101' AND '8112';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = '81' ;
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY') = '1981';

--13.	��� ���̺��� �Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/__/__' AND JOB != 'SALESMAN';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81%' AND JOB!='SALESMAN';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = '81' AND JOB != 'SALESMAN';
--14.	��� ���̺��� ���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE ;

--15.	��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';

--16.	��� ���̺�������(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME , SAL*12 "����"  FROM EMP WHERE SAL*12 >= 35000;


