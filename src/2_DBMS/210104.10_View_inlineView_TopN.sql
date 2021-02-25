--[X] VIEW , INLINE VIEW , TOP-N ����
--1. VIEW : ������ ���̺� (1) �ܼ��� , (2)���պ�

--(1) �ܼ���
CREATE OR REPLACE VIEW EMPv0  --EMPv0 �̶�� VIEW�� ������ ����� ������ �����ض�. �Ϻ��ʵ带 ���� ������ ���̺�
    AS SELECT EMPNO , ENAME, JOB, DEPTNO FROM EMP;  -- AS ���� ��������.

SELECT * FROM EMPv0;   --������ ���̺�ó�� ���������� ������ �͸� ����, ���� �� �Ҽ��ִ�.

INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'IT', 40);  --VIEW �� INSERT
SELECT * FROM EMPv0;  --INSERT ���� ������ Ȯ��.
SELECT * FROM EMP;  --EMP ���̺��� ��ȭ ��.
UPDATE EMPv0 SET JOB= 'ANALYST' WHERE EMPNO= 1111;
DELETE FROM EMPv0 WHERE EMPNO=1111;
--EMPv0 �̶�� VIEW = EMP�� 30�� �μ� �� �� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30;   --VIEW �� DDL �̶� ROLLBACK �ȴ�. 
    
SELECT * FROM USER_VIEWS; --������ ��ųʸ� �� �� Ȯ��.
SELECT * FROM EMPv0;  --30�� �μ��� �־����� 30�� �μ��� ���δ�.
DESC EMPv0;  -- ������ ���̺��̶� ���� ���´�.
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL,NULL,NULL,NULL,NULL,30);
SELECT * FROM EMPv0;  --��� INSERT Ȯ��.

INSERT INTO EMPv0 VALUES (1112, 'ȫ', NULL,NULL,NULL,NULL,NULL,40);  --EMP ���̺����� ����.
SELECT * FROM EMPv0; --30�� �μ��� ���̰��ؼ� 40�� �μ��� �������� �ʴ´�.
SELECT * FROM EMP;

DELETE FROM EMPv0 WHERE EMPNO<1113; --30�� �μ��� ������.
DELETE FROM EMP WHERE EMPNO<1113;
COMMIT;

-- EMP���̺� 30�� �μ��� ������ ���̺�(30�� �μ��� INSERT �����ϰ� ������ ��)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30
    WITH CHECK OPTION; --VIEW �� ���� ����.   WHERE ���� �־�� üũ ����,
    
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL,NULL,NULL,NULL,NULL,30);
INSERT INTO EMPv0 VALUES (1112, 'ȫ', NULL,NULL,NULL,NULL,NULL,40);   --�������� ������ �Ʒ� ���������� ���´�.
--����� 38 �࿡�� �����ϴ� �� ���� �߻� -
--INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL,NULL,NULL,NULL,NULL,40)
--���� ���� -
--ORA-01402: view WITH CHECK OPTION where-clause violation

DELETE FROM EMPv0 WHERE EMPNO=1111;  --EMP ���̺��� ������ �Ǳ⿡ �ѹ� ����.


--(2) ���պ�
CREATE OR REPLACE VIEW EMPv1
    AS SELECT EMPNO, ENAME , JOB ,DNAME FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO;  --�� ���̺��� ������ AS�������� + VIEW ����.

SELECT * FROM EMPv1;
INSERT INTO EMPv1 VALUES (1111,'ȫ','SALESMAN','RESEARCH');  --���պ�� �μ�Ʈ �Ұ���.

--���պ� ���� DML ��ɾ ��� ����� �� ���� ���(INSERT,DELETE,UPDATE �Ұ�.)
CREATE OR REPLACE VIEW EMPv2
    AS SELECT EMPNO, ENAME, DEPTNO FROM EMP
    WITH READ ONLY;  --�б� ���� VIEW [���� �Ұ�, ���⸸ ����.]
SELECT * FROM EMPv2;
SELECT EMPNO, ENAME, DNAME FROM EMPv2 E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
INSERT INTO EMPv2 VALUES (1111, 'ȫ',40);  --�Ұ�.

--EMP (�̸�, �޿�)
CREATE OR REPLACE VIEW EMPv3
    AS SELECT ENAME, SAL FROM EMP;
SELECT * FROM EMPv3;    --VIEW �� ���°͵��� �� NULL �� ����.
INSERT INTO EMPv3 VALUES ('ȫ',9000);  --EMPNO �� �����̸Ӹ� Ű ���� NOT NULL �̴� �μ�Ʈ�� �ȵȴ�.   

--EMP (���,�̸�,����=SAL*12)
--���������� �ʵ�� Ư�����ڰ� ���� ��� 1.��Ī �ֱ�.
CREATE OR REPLACE VIEW EMPv3  --Ư������ �ȴ�. * , () �ҷ��� ������ ��������.
    AS SELECT EMPNO, ENAME, SAL*12 YEARSAL FROM EMP;  
--���������� �ʵ�� Ư�����ڰ� ���� ��� 2. ��Ī�� ���� �ִ¹�.
CREATE OR REPLACE VIEW EMPv3 (NO, NAME, YEARSAL)  --�̷��� ���� �ָ� ������ �����ٲ��� �������� ��� ������ �����־����,
    AS SELECT EMPNO,ENAME,SAL*12 FROM EMP;
SELECT * FROM EMPv3;
INSERT INTO EMPv3 VALUES (1115, 'ȫ', 12000); -- VIEW �����Ҷ� �ʵ忡 ������ ������ INSERT �Ұ�.

--VIEW ������ �Լ��� ����� ���( ������ ,�׷��� )�� INSERT �Ұ�.
--EMP (���,�̸�, �ݿø��� SAL)
CREATE OR REPLACE VIEW EMPv3
    AS SELECT EMPNO, ENAME, ROUND(SAL, -2) SAL FROM EMP;
SELECT * FROM EMPv3;
INSERT INTO EMPv3 VALUES (1115, 'ȫ',1000); --�Լ� �����̿��� �μ�Ʈ �Ұ�.

--�μ���ȣ , �ּұ޿�, �ִ�޿�, �μ���� �� ������ DEPTv1 VIEW ����.
CREATE OR REPLACE VIEW DEPTv1 (DEPTNO, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DEPTNO, MIN(SAL), MAX(SAL), ROUND(AVG(SAL), 1) FROM EMP GROUP BY DEPTNO;
SELECT * FROM DEPTv1;

--�μ���ȣ, �μ���, �ּұ޿�, �ִ�޿�, �μ� ��ձ޿�   --�����Ҷ��� ������ �����ͼ� ����Ʈ �ض�. 
SELECT DEPT.DEPTNO, DNAME, MINSAL, MAXSAL, ROUND(AVGSAL) FROM DEPTv1 , DEPT WHERE DEPTv1.DEPTNO=DEPT.DEPTNO;
DESC DEPTv1;
INSERT INTO DEPTv1 VALUES (40, 700, 9000, 4000);  --�Լ��� ��⶧���� �μ�Ʈ �Ұ�. ������ �Ұ�.

SELECT * FROM EMP WHERE EMPNO<1115;
DELETE FROM EMP WHERE EMPNO<1115;
SELECT COUNT (*) FROM EMP;
--EMP(�ߺ��� ���ŵ� JOB, DEPTNO )
SELECT DISTINCT JOB, DEPTNO FROM EMP ORDER BY JOB; --�������� ������ �ذŴ� ���� ���ϴ°� ã�� ���� �ҷ��� �����Ŷ� �ȳ־ ����.
CREATE OR REPLACE VIEW EMPv3
    AS SELECT DISTINCT JOB, DEPTNO FROM EMP ORDER BY JOB;
SELECT * FROM EMPv3;
INSERT INTO EMPv3 VALUES ('CLERK',10);  --DISTINCT ������ VIEW �� �μ�Ʈ �Ұ�.


--2. INLINE VIEW : SQL�� �����ϴ� ������ ��ɾ���� ������ ��   ���� �����Ҷ� ��� �����Ǵ� ��.
--FROM ���� �������� = INLINE VIEW �� �Ѵ�.
-- SELECT �ʵ�1, �ʵ�2 ~
-- FROM EMP E, (��������) "S"
-- WHERE ����

--�޿��� 2000�� �ʰ��ϴ� ����� ��ձ޿�
SELECT AVG(SAL) FROM EMP WHERE SAL > 2000;
SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL > 2000); --������ ������ �̸����� ������ �䰡 ���������.

--�̸� ,�޿�,�μ���ȣ, �ش����� �μ���� �޿�. �������� ��������.
SELECT ENAME, SAL, DEPTNO, (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO) FROM EMP E;

--������ ������ ���� ������ INLINE VIEW ��� �������� ��������.
SELECT ENAME, SAL ,DEPTNO FROM EMP;  -- [ 1 ]
SELECT DEPTNO, ROUND(AVG(SAL)) FROM EMP GROUP BY DEPTNO; -- [ 2 ]
-- 1���� 2�� �� ��.
SELECT ENAME, SAL,E.DEPTNO, S.AVGSAL FROM EMP "E" , (SELECT DEPTNO, ROUND(AVG(SAL)) "AVGSAL" FROM EMP GROUP BY DEPTNO) "S"
    WHERE E.DEPTNO=S.DEPTNO;   --INLINE VIEW �� ��Ī ������ �������.

--�̸�, �޿�, �μ���ȣ, �ش����� �μ����(�μ���պ��� ���� �޴� ������)
SELECT ENAME, SAL ,E.DEPTNO, ROUND(AVGSAL) FROM EMP E ,(SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) "S"
    WHERE E.DEPTNO=S.DEPTNO AND SAL>AVGSAL;

--3. TOP - N ����  (TOP - 1~10��, TOP - 11~20�� TOP - 6~10��  ... )  INLINE VIEW ������ ����.
--ROWNUM : EMP���̺��� ������ ����. => ���̺��� ���� ������ ��� ����.
SELECT ROWNUM, ENAME, SAL FROM EMP;
SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL; --���� EMP ���� �������� �°� �����´���. ORDER BY SAL �� ���� ��ġ.
SELECT ROWNUM, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL);
SELECT ROWNUM ,ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL) WHERE ROWNUM < 6; --TOP 1~ 5 �������
SELECT ROWNUM ,ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL) WHERE ROWNUM >=6 AND ROWNUM<=10; --TOP 6~10 ����
--BETWEEN 6 AND 10 --BETWEEN �̴� ��ó�� �ϴ� �ȳ���.  TOP -N ���� �̿ϼ��̶� �׷�.

--�Լ��� �̿��� RANK ���.
SELECT RANK() OVER(ORDER BY SAL) RANK,
    DENSE_RANK() OVER (ORDER BY SAL) "D_RANK",
    ROW_NUMBER() OVER (ORDER BY SAL) N_RNAK, ENAME, SAL FROM EMP;

-- TOP - N ����
SELECT ROWNUM , ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 1 AND 5;  --6~10 �� �Ұ���. �׷��� �Ʒ����� �����ҷ�����.
SELECT ROWNUM, RN, ENAME , SAL FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL ))
    WHERE RN BETWEEN 6 AND 10;  --���������ȿ��� ����� ������ �������� �������� RN�� ������ RN ���� ����.
    -- THIS IS REAL   TOP - N ����.

--�̸� ���ĺ� ������� 6~10����� ��� (�̸�, ���, JOB, MGR, HIREDATE)
SELECT ROWNUM RN , ENAME , EMPNO, JOB ,MGR , HIREDATE FROM (SELECT * FROM EMP ORDER BY ENAME ); --��������

SELECT ENAME , EMPNO, JOB , MGR , HIREDATE 
    FROM (SELECT ROWNUM RN , ENAME , EMPNO, JOB ,MGR , HIREDATE FROM (SELECT * FROM EMP ORDER BY ENAME ))
    WHERE RN BETWEEN 6 AND 10;
--FROM (SELECT ROWNUM RN , ENAME , EMPNO, JOB ,MGR , HIREDATE = * �� �ص��ǰ� * ���Ҳ��� ������ ���Ǵ�� ����.


--<�� ��������>
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, ENAME FROM EMP E ,DEPT D WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU  --�������� ENAME �ߺ� OR Ư������ ������ ��Ī ��������.
    AS SELECT W.ENAME "WORKER" , M.ENAME "MANAGER" FROM EMP W, EMP M WHERE W.MGR=M.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;


-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���) ? ģ������

SELECT DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC; --����

SELECT ROWNUM "���",DEPTNO, SUMSAL FROM (SELECT DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC);

-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT RN "���", DEPTNO , SUMSAL 
    FROM (SELECT ROWNUM RN, DEPTNO, SUMSAL FROM(SELECT DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
    WHERE RN BETWEEN 2 AND 3;

-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC; --��������
SELECT EMPNO, ENAME, HIREDATE 
    FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC)
    WHERE ROWNUM <= 5;
    
-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� 

SELECT EMPNO, ENAME, HIREDATE 
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC)) WHERE RN BETWEEN 6 AND 10;


