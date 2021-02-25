--[IV] ������ �Լ�.
--����Ŭ������ �������Լ� + �׷��ռ�(�������Լ�)
--'YY"���� ����."
SELECT ENAME,TO_CHAR(HIREDATE, 'YY"��"MM"��"DD"��" DY"����"') FROM EMP; 
SELECT ENAME, INITCAP(ENAME) FROM EMP;  --������ �Լ�
SELECT SUM(SAL) FROM EMP; --�׷��Լ� �������� ���  �� ����SUM(SAL) SAL�� ����.
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;

--EX. ���� ���� �Լ�, ���ڰ��� �Լ�, ��¥���� �Լ�, ����ȯ ���� �Լ�, NVL() ���� �Լ�, ETC���� �Լ� ����....
--(1) ���ڰ��� �Լ�
DESC DUAL; --����Ŭ���� �����ϴ� 1�� 1��¥�� ���� ���̺�.
SELECT ABS(-9) FROM DUAL; --���밪
SELECT FLOOR(34.5678) FROM DUAL; --�Ҽ������� ����.
SELECT FLOOR(34.5678*10)/10 FROM DUAL; --�Ҽ��� ���ڸ����� ����.
SELECT TRUNC (34.5678) FROM DUAL; --�Ҽ������� ����
SELECT TRUNC (34.5678,1) FROM DUAL; --�Ҽ��� ���ڸ����� ����.
SELECT TRUNC (34.5678,-1) FROM DUAL; --���� �ڸ����� ����.

--EMP ���̺��� �̸�,�޿� (�޿��� �����ڸ����� ����)
SELECT ENAME, TRUNC (SAL, -1) FROM EMP;
SELECT ENAME, TRUNC (SAL, -2) FROM EMP; --���� �ڸ� ���� ����
SELECT CEIL(34.5678) FROM DUAL; --�Ҽ������� �ø�
SELECT ROUND(34.5678) FROM DUAL; --�Ҽ������� �ݿø�
SELECT ROUND(34.5678, 1) FROM DUAL;  --�Ҽ��� ���ڸ����� �ݿø�
SELECT ROUND(34.5678, -1) FROM DUAL;--���� �ڸ����� �ݿø�
SELECT FLOOR(10/4) FROM DUAL;   --�÷ξ ���ϰ� �ϸ� 2.5 �� ����.
SELECT MOD (9, 2) FROM DUAL;  --������ ����.
SELECT MOD ('9', 2) FROM DUAL;  --9/2 �� ������ ����� �ִ��� ����.
--Ȧ���޿� �Ի��� �������� ��� �ʵ带 ���
SELECT * FROM EMP WHERE MOD (TO_CHAR(HIREDATE, 'MM'),2)=1;

--(2) ���� ���� �Լ�
SELECT UPPER('abcABC') FROM DUAL; -- ��� �빮��
SELECT LOWER('abcABC') FROM DUAL; -- ��� �ҹ���
SELECT INITCAP('abcABC') FROM DUAL; --ù ���ڸ� �빮�ڷ� �ϰ� �������� �ҹ���
--JOB�� MANAGER�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT EMPNO,INITCAP(ENAME) FROM EMP;
--��Ĺ ��ġ��. ���� �������� || �� ����.
SELECT 'AB'||'CD'||'EF'||'GB' FROM DUAL;
SELECT CONCAT ('AB','CD') , CONCAT('EF','GH') FROM DUAL;  --��Ĺ�� �ΰ����ۿ� ����. ������ �ҷ��� ����ó��,
--SELECT CONCAT ('AB','CD','EF','GH') FROM DUAL;  MYSQL ������ ����,
SELECT ENAME||'�� '||JOB||' �̴�' FROM EMP;
SELECT CONCAT(CONCAT(ENAME,'�� '), CONCAT(JOB, '�̴�')) FROM EMP; --������ �۾�.
--SUBSTR(STR , ������ġ , ���ڰ���) --����Ŭ������ 0�������� �ƴ� 1������ �����.
--SUBSTRB (STR ,������ġ ,���ڹ���Ʈ��)
SELECT SUBSTR('WELCOM TO ORACLE' , 3, 2)FROM DUAL;  --3��°���� 2��  L���� C���� �ΰ�.
SELECT SUBSTRB('WELCOM TO ORACLE' , 3, 2)FROM DUAL;  --3��°���� 2����Ʈ. L���� C���� 2����Ʈ.
SELECT SUBSTR ('�����ͺ��̽�', 4, 3) FROM DUAL; --4��°���� 3����.
SELECT SUBSTRB ('�����ͺ��̽�', 4, 3) FROM DUAL; --4��° ���� 3����Ʈ.
--����� �ѹ��ڰ� 1����Ʈ , �ѱ��� �ѹ��ڰ� 3����Ʈ.   �̹����� ����Ŭ�� �׷�.
--'9��'�� �Ի��� ��� �ʵ带 ���.
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4,2)='09';

SELECT SUBSTR('010-99-9999', -4, 4) FROM DUAL;
--���ڰ�������   �������� �տ��� ������ �ڿ��� �����ִ�.
--1 2 3 4 5 6
--6 5 4 3 2 1
--'9��'�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2,2)='09';

--���� ���ڱ��̸� �����ϴ�.
SELECT LENGTH('ABCD') FROM DUAL;  --���� ���� : 4
SELECT LENGTHB('ABCD') FROM DUAL;  --���� ����Ʈ ����. : 4
SELECT LENGTHB('����Ŭ') FROM DUAL;  --���� ����Ʈ ���� : 9
SELECT LENGTH ('����Ŭ') FROM DUAL;  --���� ���� : 3

--�ν�Ʈ��. INSTR(STR, ã�� ����) : STR ���� ã�� ������ ��ġ(ù��°1) , ������ 0
SELECT INSTR('ABCABC', 'B') FROM DUAL;  --ã�� ���ڿ��� ��ġ��ȯ.
--INSTR(STR, ã�� ����, ������ġ) : STR ���� ������ġ���� ã�Ƽ� ã�� ������ ��ġ(ù��°1) , ������ 0
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL;  --3��° ������ġ���� C-> B�� �ִ� ��ġ 5.
--9���� �Ի��� ���(INSTR�̿�)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09')=4;
--9�Ͽ� �Ի��� ���(INSTR)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09')=7;

--LPAD (����, �ڸ���, '*')  20�ڸ� Ȯ���ؼ� #�� ���� ���ڸ��� ����.
SELECT LPAD('ORACLE', 20, '#') FROM DUAL;
SELECT RPAD('ORACLE', 20, '*') FROM DUAL;
SELECT ENAME , LPAD(SAL, 6, '*') FROM EMP;

--���, S****(�̸��� �� �ѹ��ڸ� ����ϰ� �������� * ���)
SELECT EMPNO, RPAD(SUBSTR(ENAME,  1,1),LENGTH(ENAME),'*') NAME FROM EMP;

--7369(���), S****(�̸�) 80/12/**(�Ի���)���
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1,1), LENGTH(ENAME), '*') NAME, RPAD(SUBSTR(HIREDATE, 1, 6),LENGTH(HIREDATE),'*') HIRE FROM EMP;

-- 7369(���), ****H(�̸�) 80/12/**(�Ի���) ���
SELECT EMPNO, LPAD(SUBSTR(ENAME, -1,1), LENGTH(ENAME), '*') NAME, RPAD(SUBSTR(HIREDATE, 1, 6),LENGTH(HIREDATE),'*') HIRE FROM EMP;

--�̸��� ����° �ڸ��� R�� ��� ���(INSTR, SUBSTR , LIKE)
SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R')=3;
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R';
SELECT TRIM('       ORACLE DB            ') FROM DUAL; -- �¿� ��ĭ ����.
SELECT LTRIM('       ORACLE DB   .   .  . .   ') FROM DUAL;  --���� ��ĭ ����
SELECT RTRIM(' . . . .   ORACLE DB            ') FROM DUAL; --������ ��ĭ ����

--REPLACE  Ư�� ���ڸ� Ư�����ڷ� �ٲٴ�.
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;


--(3) ��¥ ���� ����� , �Լ�  
SELECT SYSDATE FROM DUAL;  
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS') FROM DUAL; --��ü���� ����.
SELECT SYSDATE-1 ����, SYSDATE ����, SYSDATE+1 ���� FROM DUAL;
--14�� ��
SELECT SYSDATE+14 FROM DUAL;

--�̸�, �Ի��� , �ٹ�����.
SELECT ENAME , HIREDATE , TRUNC(SYSDATE-HIREDATE) �ٹ����� FROM EMP;  --TRUNC ��� FLOOR ����.

--�̸�, �Ի���, �ٹ��ּ� , �ٹ� ���
SELECT ENAME, HIREDATE, FLOOR((SYSDATE-HIREDATE)/7) �ٹ��ּ�, FLOOR((SYSDATE-HIREDATE)/365) �ٹ���� FROM EMP;

--�̸�, �Ի���, �ٹ����� :MONTHS_BETWEEN Ư���� �� ���� ������ ������
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP;

--ADD_MONTHS(Ư����¥, ������) Ư���� ��¥�� ���� ��� ���� ����.
--�̸�, �Ի���, �����Ⱓ������(�����Ⱓ�� 6����)
SELECT ENAME ,HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;

--NEXT_DAY(Ư����¥, '��') Ư����¥�κ��� ó�� �����ϴ� ������.
SELECT NEXT_DAY(SYSDATE, '��') FROM DUAL; --�̹��� �ٰ����� '��'���� ��¥.

--LAST_DAY(Ư����¥) :Ư����¥�� ���� ����.
--�̸�, �Ի���,���޳�(������ ����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;

--ROUND (��¥���� �ݿø�) , TRUNC(��¥���� ����.)
SELECT ROUND(SYSDATE-30, 'YEAR') FROM DUAL;  --����� 1��1�� ����1��1�� �̳� �۳�1��1���̳�
SELECT ROUND(SYSDATE-30, 'MONTH') FROM DUAL; --����� 1��.  12��1���̳� 11�� 1���̳�
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL;-- ��� �Ͽ���. �̹��ֿ� �������� �����ֿ� ��������
SELECT ROUND(SYSDATE) FROM DUAL;  --��� : ����� 0��

--TRUNC
SELECT TRUNC(SYSDATE-30, 'YEAR') FROM DUAL;  --����� 1��1�� ����1��1�� �̳� �۳�1��1���̳�
SELECT TRUNC(SYSDATE-30, 'MONTH') FROM DUAL; --����� 1��.  12��1���̳� 11�� 1���̳�
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL;-- ��� �Ͽ���. �̹��ֿ� �������� �����ֿ� ��������
SELECT TRUNC(SYSDATE) FROM DUAL; --���� 0��

--EX1. �̸�, �Ի���, �Ի��ϴ��� 1��
SELECT ENAME , HIREDATE , TRUNC(HIREDATE, 'MONTH') FROM EMP;

--EX2. �̸�,�Ի���, ���޳�(������ 24�ϳ�)
SELECT ENAME, HIREDATE, ROUND(HIREADTE-8, 'MONTH')+23 FROM EMP;

--EX3. �̸�, �Ի��� ,SAL �̶����� ���� ������ ��
SELECT  ENAME, HIREDATE, SAL, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP; 

--EX4 �̸�, �Ի��� SAL COMM �̶����� ���� ����(SAL*12+COMM)
SELECT ENAME, HIREDATE, SAL, COMM, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))+NVL(COMM,0)*TRUNC((SYSDATE-HIREDATE)/365) FROM EMP;


--(4) ����ȯ �Լ�.
--TO_CHAR(��¥, ����) : ��¥�� ���Ͽ� �°� ���ڷ� ����ȯ.
-- YY(�⵵) MM(��) MON(�� �̸�) DD(��) DY(����)
-- HH24(0~23��) AM(����/����) HH(0~11��) M1(��) SS(��)
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;   --YY, MM , DD ���ڸ� �̻� �����.
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY"��"MM"��"DD"��"DY"����"') FROM EMP;
SELECT TO_CHAR(SYSDATE, 'YY"��"MON DD"��" AM HH"��" MI"��"SS"��"') FROM DUAL;

--TO_CHAR(����, ����) : ���ڰ��� ���Ͽ� �°� ���ڷ� ����ȯ.
-- ���ϳ� 0 ������ : �ڸ��� ǥ��. �ڸ����� ���� ������ 0���� ä����.
-- ���ϳ� 9 �� ���� : �ڸ��� ǥ��. �ڸ����� ���� ������ ä���� ���� (�ڹٿ����� #)
-- ���ϳ� $ �� ���� : ��ȭ ����. ��ȭ ������ ���� �տ� ����.
-- ���ϳ� L �� ���� : ������ȭ������ ���ھտ� ����. Ÿ������ ���� �ش� ������ȭ�� �ٲ�.
SELECT ENAME, SAL FROM EMP;
SELECT ENAME, TO_CHAR(SAL, 'L999,999') SAL FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$999,999') SAL FROM EMP; --�˳� �ϰ� �ڸ��� �������.
SELECT ENAME, TO_CHAR(SAL, '$000,000') SAL FROM EMP;  --0 �� 9�� ������.

--TO_DATE(����, ����) : '81/01/01' -> ���ڸ� ���Ͽ� �°� ��¥������ ��ȯ.
--81/5/1 ~ 83/5/1 ���� ������ �Ի��� ���� ���.
SELECT * FROM EMP WHERE HIREDATE BETWEEN '81/05/01' AND '83/05/01'; --����� PC�� ����Ʈ Ÿ���� ��� �𸣴� �̷��� �ϸ� �����ؾ��Ѵ�.
SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('19810501', 'YYYYMMDD') AND TO_DATE('19830501', 'YYYYMMDD'); --�Ʒ�ó�� �ϴ°� ����.
--2020�� 11�� 30�� ���� ������� ��¥���� ��� (�ý����� ��¥�� ������ �𸥴�.)
SELECT CEIL(SYSDATE-TO_DATE('20201130', 'YYYYMMDD')) FROM DUAL; --�ø� 29��
SELECT TRUNC(SYSDATE-TO_DATE('20201130', 'YYYYMMDD')) FROM DUAL; -- ���� 28��

--TO_NUMBER(����, ����) : ���ڸ� ���Ͽ� �°� ���������� ��ȯ.
SELECT TO_NUMBER('1,000', '9,999') FROM DUAL;
SELECT TO_NUMBER('1,000', '9,999')*1.1 FROM DUAL; 
--'1,000'*1.1 �׳� �ϸ� �������� ����� ���ϱ⿡ ���ѹ��� ���������� ����ȯ ���Ѽ� ������, ���� ���ڸ� ���ڷ� �Ἥ ����ϴ� ���� ���� ����.


--(5)NULL ���� �Լ� : NVL(�� �� �� ���ִ� ������, �� ������ ��� �� ��) --�Ű����� 2���� Ÿ�� ��ġ.

--����̸�, ���ӻ���� �̸�(���ӻ�簡 ������ CEO�� ���)
SELECT W.ENAME, NVL(M.ENAME, 'CEO') FROM EMP W, EMP M WHERE W.MGR=M.EMPNO(+) ;

--����̸�, ���ӻ���� ���(���ӻ�簡 ������ CEO �� ���)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP; 
SELECT * FROM EMP;

--(6) DECODE �Լ� (�Ű�����=������, ��1, ��2, ���2, ... ��N, ��� N , �׿� ���) 
--�̸� , �μ���ȣ, �μ��̸� 
SELECT ENAME , D.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
SELECT ENAME, DEPTNO, 
    DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATIONS', 'ETC') AS "DNAME" FROM EMP;
    --JOIN ���ų� DECODE �� �Ȱ��� ���´�.
    
SELECT ENAME, DEPTNO, CASE WHEN DEPTNO=10 THEN 'ACCOUNTING' 
    WHEN DEPTNO=20 THEN 'RESEARCH' 
    WHEN DEPTNO=30 THEN 'SALES' 
    WHEN DEPTNO=40 THEN 'OPERATIONS' 
    ELSE 'ETC' END AS "DNAME" FROM EMP;

SELECT ENAME, DEPTNO, CASE DEPTNO WHEN 10 THEN 'ACCOUNTING' 
    WHEN 20 THEN 'RESEARCH' 
    WHEN 30 THEN 'SALES' 
    WHEN 40 THEN 'OPERATIONS' 
    ELSE 'ETC' END AS "DNAME" FROM EMP;
--�̸�, �޿� , �λ� �����޿�  
--JOB�� ���� 'ANALYST' �� 10%�λ�,  MANAGER �� 20% �λ� RESEARCH �� 30% �λ� SALESMAN �̸� 40%�λ� CLERK �λ����.
SELECT DISTINCT JOB FROM EMP;
SELECT ENAME , SAL , DECODE(JOB, 'ANALYST', SAL*1.1, 'MANAGER', SAL*1.2, 'PRESIDENT', SAL*1.3, 'SALESMAN', SAL*1.4 ,SAL ) "�λ�޿�" FROM EMP;

SELECT ENAME, SAL, CASE WHEN JOB='ANALYST' THEN SAL*1.1 
    WHEN JOB='MANAGER' THEN SAL*1.2 
    WHEN JOB='PRESIDENT' THEN SAL*1.3 
    WHEN JOB='SALESMAN' THEN SAL*1.4 
    ELSE SAL END "�λ�޿�" FROM EMP;

SELECT ENAME, SAL, CASE JOB WHEN 'ANALYST' THEN SAL*1.1 
    WHEN 'MANAGER' THEN SAL*1.2 
    WHEN 'PRESIDENT' THEN SAL*1.3 
    WHEN 'SALESMAN' THEN SAL*1.4 
    ELSE SAL END "�λ�޿�" FROM EMP; --����� JOB�� CASE �տ� ������.


--(7)�׿� �Լ�. [ EXTRACT, ������ ���]
SELECT EXTRACT(YEAR FROM HIREDATE) YEAR FROM EMP;
SELECT TO_CHAR(HIREDATE, 'YYYY') YEAR FROM EMP;
SELECT EXTRACT(MONTH FROM HIREDATE) MONTH FROM EMP;
SELECT TO_CHAR(HIREDATE, 'MM') MONTH FROM EMP;

--LEVEL, START WITH(�ֻ��� ������ ����), CONNECT BY PRIOR(������ ��������)
SELECT LEVEL, LPAD(' ',LEVEL*2)||ENAME ,MGR FROM EMP 
    START WITH MGR IS NULL CONNECT BY PRIOR EMPNO=MGR;  --�̰� �� �Ⱦ��̱� �Ѵ�.


--<�� ��������> --12-28--
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;
--���� �ѿ� ��� �����������

-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL , SAL*1.15 "New Salary", SAL*0.15 "Increase" FROM EMP; 

--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE FROM EMP;
SELECT ENAME ,HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '��') "6���� �� �����" FROM EMP;


--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "��������ǰ�����", SAL, ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE)*SAL,2) "�޿��Ѱ�" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "��������ǰ�����", SAL, TO_CHAR(ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE),2)*SAL, '$9,999,999.99') "�޿��Ѱ�" FROM EMP;
--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL, 15, '*') FROM EMP; 
SELECT LPAD('ORACLE', 20, '#') FROM DUAL;
SELECT RPAD('ORACLE', 20, '*') FROM DUAL;

--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'YY/MM/DD/DY"����"') FROM EMP;
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY') FROM EMP;
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"����"') FROM EMP;

--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, JOB, LENGTH(SUBSTR(ENAME, 1, 6)) FROM EMP WHERE LENGTH(SUBSTR(ENAME, 1, 6)) >= 6;
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP WHERE LENGTH(ENAME) >= 6;
SELECT SUBSTR('WELCOM TO ORACLE' , 3, 2)FROM DUAL;
SELECT LENGTH('ABCD') FROM DUAL;


--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB ,SAL "�޿�", COMM "���ʽ�" , SAL+NVL(COMM ,0) "SALandCOMM" FROM EMP;

-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT ENAME, SUBSTR(ENAME, 2, 3) FROM EMP;


--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
SELECT EMPNO, ENAME , HIREDATE FROM EMP WHERE INSTR(HIREDATE, '12', 4)=4;
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE HIREDATE LIKE '%/12/%';
SELECT EMPNO, ENMAE, HIREDATE FROM EMP WHERE SUBSTR(HIREADATE, 4, 2)= '12';
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12';
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE EXTRACT(MONTH  FROM HIREDATE)=12;


--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 
SELECT EMPNO, ENAME ,LPAD(SAL, 10, '*') "�޿�" FROM EMP;


-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD' ) "�Ի���" FROM EMP; -- "-" Ư������ �ε� �ֵ���ǥ�� ���ε� �Ȱ��ε� ����.
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD')"Current Date" FROM DUAL;

--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$999,999') "SAL" FROM EMP WHERE DEPTNO = 20;
SELECT ENAME, TO_CHAR(SAL, 'L999,999') SAL FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$999,999') SAL FROM EMP; --�˳� �ϰ� �ڸ��� �������.
SELECT ENAME, TO_CHAR(SAL, '$000,000') SAL FROM EMP;  --0 �� 9�� ������.

-- 14. ��� ���̺��� �޿��� ���� ���, �̸�, �޿�, ����� �˻��ϴ� SQL ������ �ۼ� �Ͻ� ��. ���ڵ�
-- �޿��� 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME ,SAL , CASE WHEN SAL BETWEEN 0 AND 1000 THEN 'E'
    WHEN SAL BETWEEN 1001 AND 2000 THEN 'D'
    WHEN SAL BETWEEN 2001 AND 3000 THEN 'C'
    WHEN SAL BETWEEN 3001 AND 4000 THEN 'B'
    WHEN SAL BETWEEN 4001 AND 5000 THEN 'A' 
    END "���" FROM EMP;
    
SELECT EMPNO, ENAME, SAL , CASE WHEN SAL >= 0 AND SAL <= 1000 THEN 'E'
    WHEN SAL >= 1001 AND SAL <= 2000 THEN 'D'
    WHEN SAL >= 2001 AND SAL <= 3000 THEN 'C'
    WHEN SAL >= 3001 AND SAL <= 4000 THEN 'B'
    WHEN SAL >= 4001 AND SAL <= 5000 THEN 'A'
    END "���" FROM EMP;

SELECT EMPNO, ENAME, SAL , CASE TRUNC((SAL-1)/1000) WHEN 0 THEN 'E'
    WHEN 1 THEN 'D'
    WHEN 2 THEN 'C'
    WHEN 3 THEN 'B'
    ELSE 'A' END "���" FROM EMP;
    
SELECT EMPNO , ENAME, SAL ,DECODE(TRUNC(SAL/1000), 0, 'E' , 1, 'D', 2, 'C' , 3 , 'B' , 'A') "���" FROM EMP;

SELECT EMPNO, ENAME , SAL ,CASE TRUNC(SAL/1000) WHEN 0 THEN 'E'
    WHEN 1 THEN 'D'
    WHEN 2 THEN 'C'
    WHEN 3 THEN 'B'
    ELSE 'A' END "���" FROM EMP;







