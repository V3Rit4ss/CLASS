--[VII] DDL, DML, DCL   DML�� ��� ���������� �������� ��Ұ� �Ұ���. DML�� ��� ���ϰ� �ϰ������ COMMIT.
--SQL = DDL(���̺� ����, ���� , ���̺� ���� ����, ���̺��� ����������.) 
    -- + DML(SELECT , INSERT, UPDATE, DELETE)
    -- + DCL(����� ���� ����, ����ڿ��� ���� �ο�, ���ѹ�Ż, Ʈ�����Ǹ�ɾ�.)
    
--$$$ DDL  
--1. ���̺� ����.(CREATE TABLE)
SELECT * FROM EMP;
--������ ���̺� �̸��� ��������. ���̺� �̸� 30�� ����
CREATE TABLE BOOK(
    BOOKID NUMBER(4),--������ȣ --�ѹ��ϰ� �ƹ��͵� ���ϸ� 30~40�ڷ� �ڵ����� ������.
    BOOKNAME VARCHAR2(20),--�����̸�
    PUBLISHER VARCHAR2(20),--���ǻ�
    RDATE DATE, --������
    PRICE NUMBER(8),  --���� ����
    PRIMARY KEY(BOOKID) --���̺� ��Ű(PRIMARY KEY) = ������ �ڵ�, ������ �� ,�ߺ�X,NULL �� �Ұ�.  --�������� �� �ϳ��� �����̸Ӹ� Ű.
    
);

DROP TABLE BOOK; --BOOK ���̺� ����.
CREATE TABLE BOOK(
    BOOKID NUMBER(4) PRIMARY KEY,   --���������� �ؿ��� ������ �ص� ��.
    BOOKNAME VARCHAR2(20),       --���������� �ʵ� �����ʿ� �ص� ��.  ����Ŭ������.
    PUBLISHER VARCHAR2(20),
    RDATE DATE,
    PRICE NUMBER(8)


);
--����2 �� 2000����Ʈ �����ε�, LOB �� ���� 2GB ���� �����ִ�.
SELECT * FROM BOOK;

--EMP �� ������ EMP01 ���̺� : EMPNO(NUMBER 4), ENAME(VARCHAR:20) , SAL(NUMBER 7 ,2[�Ҽ��� ǥ��])
CREATE TABLE EMP01 (
    EMPNO NUMBER (4),
    ENAME VARCHAR (20),
    SAL NUMBER (7, 2)




);

SELECT * FROM EMP01;
DESC EMP01; --���� ���� ���̺� ����Ȯ��.

--DEPT01 : DEPTNO(NUMBER 2), DNAME(VARCHAR2 14) ,LOC(VARCHAR2 13)
CREATE TABLE DEPT01 (
    DEPTNO NUMBER (2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2 (13)



);
SELECT * FROM DEPT01;
DESC DEPT01;   -- ���� Ȯ��.

--���������� �̿��� ���̺� ����.
CREATE TABLE EMP02    --�׽�Ʈ�� ���� ���鶧 ..
    AS
    SELECT * FROM EMP;  --�������� ����� ��, EMP02(���������� ������)   ���̺� ���������� ���� �ȳ־��.

SELECT * FROM EMP02;
INSERT INTO EMP02 (EMPNO, ENAME, DEPTNO) VALUES (7369, 'HONG', 90);   --���������� ��� �ߺ��Ȱ͵� ����.

-- EMP03 : EMP ���̺����� EMPNO, ENAME, DEPTNO �� ����.
CREATE TABLE EMP03
    AS
    SELECT EMPNO, ENAME, DEPTNO FROM EMP;  --��ü ���̺��߿��� �����κи� �׽�Ʈ �ϰ������.

SELECT * FROM EMP03;


--EMP04 : EMP ���̺����� 10�� �μ��� ����.
CREATE TABLE EMP04
    AS
    SELECT * FROM EMP WHERE DEPTNO=10;

SELECT * FROM EMP04;

--EMP05 : EMP ���̺��� ������ ����.
CREATE TABLE EMP05
    AS                             --[WHERE 1=0 ] ������ �����̶� �����ʹ� ������ ������ ���´�.
    SELECT * FROM EMP WHERE 1=0 ; --[ WHERE 1=1 ] ������ ���̶� EMP �� ���� ������
    

SELECT * FROM EMP05;


-- (2) ���̺� ���� ����. (ALTER TABLE)
--ALTER TABLE ���̺� ��
--ADD || MODIFY || DROP ~ 3���߿� �ϳ��� ���´�.

-- 1. �ʵ� �߰� (ADD)  : ������ , �ϳ��� ����.
SELECT * FROM EMP03;
ALTER TABLE EMP03 ADD (JOB VARCHAR2(10), SAL NUMBER(7, 2)); --������ 
SELECT * FROM EMP03;  -- �ΰ��� ����.
ALTER TABLE EMP03 ADD (MGR NUMBER(4)); -- �Ѱ�.
SELECT * FROM EMP03;

-- 2. �ʵ� Ÿ�� ���� (MODIFY)
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(5));  --���� �����Ͱ� ���ִ� ���� �׷��� �ٲܼ��� ����.
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(5)); --�����Ͱ� ��� ���� ����. NULL �� �־.
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(200)); --�ø��°� ����.
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2 (5)); -- �̹� �ִ� ������ ũ�⺸�� �� �۰Դ� �Ұ����ϴ�. ENAME = 6����Ʈ�� ���ֱ� ����.

-- 3. �ʵ� ����(����) (DROP)
SELECT * FROM EMP03;
ALTER TABLE EMP03 DROP COLUMN JOB;    --��Ӵ��� ���� �Ⱦ� NULL ���̶� ������ ����������. �����Ͱ� �ִ� ���¿��� �ϸ� �����Ͱ��� ��°�� �����µ�
ALTER TABLE EMP03 DROP COLUMN EMPNO;                                            --������ �Ұ��� �ϴ�.
SELECT * FROM EMP03;
--�������� Ư�� �ʵ带 ���� ���ϵ��� �ϴ�.(��)
ALTER TABLE EMP03 SET UNUSED (SAL);
SELECT * FROM EMP03;  --SAL �� �Ⱥ������� ��� ���ܵд�.

--�������� ���� �Ұ��ߴ� �ʵ带 ���� (����)
ALTER TABLE EMP03 DROP UNUSED COLUMNS; -- ���������� ������ ���̺� �＼�� �Ұ�.


--(3) ���̺� ���� (DROP TABLE)
SELECT * FROM EMP01; --�ִ��� ������ Ȯ�� �ϰ�.
DROP TABLE EMP01;  
DROP TABLE DEPT;   -- �ٸ� ���̺��� �����ϴ� �����Ͱ� ���� ��� DROP �Ұ�
                    --DEPT�� �θ�Ŭ���� EMP �� �ڽ�Ŭ����  DEPT �� ������ �����ϴ� Ŭ������ ���־� �����.

-- (4) ���̺� ���� ������ �ϴ� ����. (TRUNCATE TABLE) ���� �Ұ�.
SELECT * FROM EMP02;
TRUNCATE TABLE EMP02; -- DDL ��ɾ�� ��� �Ұ�.


-- (5) ���̺� �̸� ����. (RENAME)
SELECT * FROM EMP03;  --���� ��.
RENAME EMP03 TO EMP3; -- EMP03 �� EMP3  ����  ���̺� �̸� ����.
SELECT * FROM EMP3;  --���� ��.


--6. ������ ��ųʸ�(���ٺҰ�)-> ������ ��ųʸ��� (����� ���ٿ�) DBA �ְ� ����.  �Ϲ� ������ ������ ���°Ŷ� �ְ������ ���°Ŷ� ���̰� �ִ�.
    --DBA_TABLES , DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS;
    --USER_TABLES , USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS;
    --ALL_TABLES , ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS;

--USER_ XXX : [SCOTT ]�� ������ ��ü ����. [���� ������]
SHOW USER;  -- ������ ���� �����ִ�.
SELECT TABLE_NAME FROM USER_TABLES; --���� ���� �͵��� ����.
SELECT * FROM USER_TABLES;
SELECT * FROM USER_INDEXES; --������ ����ã�� �ϱ� ����.  �ε����� �ý��ۿ��� �ڵ������� ���������� �ϳ� ���� ���� �ε����� �̸��� �ٸ����̴�.
SELECT * FROM USER_CONSTRAINTS;

SELECT * FROM USER_VIEWS;  -- �並 ����� ��� �ϳ��� ������ �ʴ´�.

CREATE TABLE BOOK2(
    BOOKID NUMBER(4) CONSTRAINT BP PRIMARY KEY,  -- CONSTRAINT "BP" : �����̸Ӹ� Ű �� �̸��� �����Ҽ�����.
    BOOKNAME VARCHAR2(120),       
    PUBLISHER VARCHAR2(120),
    RDATE DATE,
    PRICE NUMBER(8)


);
--DDL �� ���� ���� ������ ������ �ٷιٷ� �ٲ��.

--DBA_XXX : DBA ������ ���� ����ڸ� ���� ������ ��ü ����.
SELECT * FROM DBA_TABLES;
SELECT TABLE_NAME, OWNER FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;

--ALL_XXX : SCOTT �� ������ ��ü�� ������ �ο��� ��ü
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_VIEWS;


--###### DML ######
--7.DML : SELECT , INSERT , UPDATE, DELETE
--(1) INSERT INTO ���̺��̸� (�ʵ��1 , �ʵ��2, ~~~~)   ��1 -> �ʵ��1 , ��2 -> �ʵ��2 , ��3 -> �ʵ��3 ~~~~~
       --            VALUES (��1, ��2 , ~~~~~);
       
--    INSERT INTO ���̺� �̸� VALUES (��1, ��2, ~~~); 
SELECT * FROM DEPT01;
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (10, 'ACCOUNTING', 'NEW YORK');  --�ʵ���� �������� �ִ� ������� ���ص� ��.
INSERT INTO DEPT01 (DNAME, LOC, DEPTNO) VALUES ('SALES','BOSTON',20);
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES ( 30, 'IT', NULL); --����� NULL �Է�
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (40, 'OPERATION'); -- ���� �� ������ �ڵ����� NULL ��
--�ʵ���� ���� �Ҷ� �ݵ�� DEPT01 �� �ʵ尪�� �� �;��Ѵ�.
INSERT INTO DEPT01 VALUES (50, '����','����');    -- DML �̶� ��� ����.
SELECT * FROM DEPT01;
DESC DEPT01;  --PK(�����̸Ӹ� Ű) ���� DEPT01 
--DEPT01 ���̺� DEPT���Ը� 10~30�� �μ����� ������ INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT WHERE DEPTNO<40;   --SELECT * FROM DEPT WHERE DEPTNO<40 �������� ���� �����ؼ� �Ǵ��� ����.
SELECT * FROM DEPT01;  --�����̸Ӹ� Ű�� ��� �Ȱ����͵鵵 �� �����̴�.

--BOOK ���̺� 11��, '����������', �Ѽ�����, ������ ����, ������ 90000
SELECT * FROM BOOK;
INSERT INTO BOOK (BOOKID, BOOKNAME, PUBLISHER, RDATE, PRICE)
    VALUES (11, '����������', '�Ѽ�����',SYSDATE, 90000);
--�ʵ�� ����.
--INSERT INTO BOOK [�ʵ�� ����.] VALUES (11, '����������', '�Ѽ�����',SYSDATE, 90000);

-- COMMIT; --DML ��ɾ� ������ ����.  DML ��ɾ�� Ʈ������ ������ ����. �� Ʈ�������� �۾��� �ݿ�.
-- ROLLBACK; --Ʈ������ �ȿ� �ִ� DML ��ɾ ���


--���̺� ����1.
CREATE TABLE SAM01  (

     EMPNO NUMBER(4)CONSTRAINT C_SAM PRIMARY KEY, 
     ENAME VARCHAR2(10),
     JOB VARCHAR2(9),
     SAL NUMBER(7, 2)
    
);
SELECT * FROM USER_CONSTRAINTS;
DROP TABLE SAM01;
CREATE TABLE SAM01(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2));
SELECT * FROM USER_CONSTRAINTS;
DROP TABLE SAM01;
CREATE TABLE SAM01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2),
    PRIMARY KEY(EMPNO));
INSERT INTO SAM01 (EMPNO , ENAME, JOB, SAL) VALUES (1000, 'APPLE', 'POLICE',10000);
INSERT INTO SAM01 VALUES (1010, 'BANANA','NURSE',15000);
INSERT INTO SAM01 VALUES (1020,'ORANGE','DOCTOR',25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1030,'VERY',25000);
INSERT INTO SAM01 VALUES (1040,'CAT',NULL,2000);
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10;
SELECT * FROM SAM01;

--DROP TABLE SAM01;
--SELECT * FROM SAM01;



-- (2) UPDATE ���̺��̸� SET �ʵ��1= ��1, �ʵ��2 = ��2 ~~~~ WHERE (�ٲ� ���� ����);  
-- ��� ����.
--SELECT * FROM EMP01; �߰��ϱ����� �ִ��� ������ Ȯ��.
--
DROP TABLE EMP01; --�ִٸ� �����.
CREATE TABLE EMP01 
    AS SELECT * FROM EMP;
    
SELECT * FROM EMP01;
--�μ���ȣ�� 30���� ����.
UPDATE EMP01 SET DEPTNO = 30;  --WHERE ���̾����� ���� �ٲ�.
SELECT * FROM EMP01; -- �ٷ� ���� ������ Ȱ���� �Ǿ����� Ȯ��.

--��� ������ �޿��� 10% �λ� �Ͻÿ�.
UPDATE EMP01 SET SAL = SAL*1.1;  
SELECT * FROM EMP01;
COMMIT;

-- Ư�� ���� �����͸� �����ϰ��� �Ҷ��� WHERE �� �߰�.
-- 10�� �μ� ������ �Ի����� ���÷� �ٲٰ� , 30�� �μ��� �ٲ��.
UPDATE EMP01 SET HIREDATE = SYSDATE, DEPTNO=30 WHERE DEPTNO=10;

SELECT * FROM EMP01;

--SAL�� 3000�̻� ����� �޿��� 10% �λ��Ͻÿ�.
UPDATE EMP01 SET SAL = SAL*1.1 WHERE SAL>=3000;

-- DALLAS �� �ٹ��ϴ� �������� �޿��� 1000�λ�.
UPDATE EMP01 SET SAL= SAL+1000 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');


--SCOTT ����� �μ���ȣ�� 20���� JOB �� MANAGER �� ����.
UPDATE EMP01 SET DEPTNO = 20, JOB= 'MANAGER' WHERE ENAME = 'SCOTT';
--SET DEPTNO = 20, JOB= MANAGER ������ �ٲ㵵 ����� ����.
SELECT * FROM EMP01 WHERE ENAME = 'SCOTT';

--SCOTT ����� �Ի����� ���÷�, �޿��� 50 , COMM �� 400 ����
UPDATE EMP01 SET HIREDATE = SYSDATE , SAL =50 , COMM = 400 WHERE ENAME='SCOTT';
SELECT * FROM EMP01 WHERE ENAME = 'SCOTT';

--���������� �̿��� UPDATE ��
--EMP01���� 20������ �������� 40�� �μ��� �������� ����.
SELECT * FROM DEPT01;
UPDATE DEPT01 SET LOC='����' WHERE DEPTNO=40;

--DEPT01 ���� 20���μ��� �������� 40�� �μ��� �μ���, ���������� ����. ������ ��������.
UPDATE DEPT01 SET (DNAME,LOC) = (SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO = 40)  WHERE DEPTNO = 20;
SELECT * FROM DEPT01 WHERE DEPTNO IN (20,40);

--EMP01 ���̺��� ��� ����� �޿��� �Ի����� 'KING' ��  �޿��� �Ի��Ϸ� ����
SELECT * FROM EMP01;
UPDATE EMP01 SET (SAL,HIREDATE) = (SELECT SAL,HIREDATE FROM EMP01 WHERE ENAME = 'KING') ; 
SELECT * FROM EMP01;


--(3) DELETE FROM ���̺�� WHERE ����; DELETE �� ��� ������.
COMMIT;
SELECT * FROM EMP01;
DELETE FROM EMP01;
ROLLBACK;

--EMP01 ���̺��� 30�� �μ��� �����ض�.
DELETE FROM EMP01 WHERE DEPTNO=30;
SELECT * FROM EMP01;

--SAM01 ���̺��� JOB�� ������������ ����� ����
SELECT * FROM SAM01;
DELETE FROM SAM01 WHERE JOB IS NULL;

--EMP01 ���̺��� �μ����� SALES�� ����� ����.
DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');

--EMP01 ���̺��� RESEARCH �μ� �Ҽ��� ��� ����
DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='RESEARCH');
SELECT * FROM EMP01;

--����2 

-- 1. ================
CREATE TABLE MY_DATA (

    ID NUMBER(4)  PRIMARY KEY,
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10, 2)

);
-- =======================
SELECT * FROM MY_DATA;

-- 2. =============================
INSERT INTO MY_DATA (ID , NAME, USERID, SALARY) VALUES (1, INITCAP('SCOTT'), 'SSCOTT', 10000.00);
INSERT INTO MY_DATA (ID , NAME, USERID, SALARY) VALUES (2, 'Ford', 'fford', 13000.00);
INSERT INTO MY_DATA (ID , NAME, USERID, SALARY) VALUES (3, 'Patel', 'ppatel', TO_NUMBER('33,000.00', '999,999.99'));
INSERT INTO MY_DATA (ID , NAME, USERID, SALARY) VALUES (4, 'Report', 'rreport', TO_NUMBER('23,500.00', '999,999.99'));
INSERT INTO MY_DATA (ID , NAME, USERID, SALARY) VALUES (5, 'Good', 'ggood', TO_NUMBER('44,450.00', '999,999.99'));
--ROLLBACK;
-- ====================================

--3.
SELECT * FROM MY_DATA;
SELECT ID,NAME,USERID, TO_CHAR(SALARY,'999,999.99')SALARY FROM MY_DATA;
--=======================

--4.
COMMIT;
--=========================
--6. UPDATE EMP01 SET SAL = SAL*1.1 WHERE SAL>=3000;
UPDATE MY_DATA SET SALARY = 65000.00 WHERE ID = 3;  --�Ǵ�.
UPDATE MY_DATA SET SALARY = TO_NUMBER('65,000.00', '999,999.99') WHERE ID = 3;
SELECT * FROM MY_DATA;
COMMIT;
--ROLLBACK;
-- ========================

--7. DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
DELETE FROM MY_DATA WHERE ID = 3;
DELETE FROM MY_DATA WHERE NAME ='Ford';
DELETE FROM MY_DATA WHERE INITCAP(NAME)='Ford';
SELECT * FROM MY_DATA;
COMMIT;
ROLLBACK;
--DELETE FROM MY_DATA WHERE ID = (SELECT NAME, USERID, SALARY FROM MY_DATA WHERE ID = 3)

--8 ===========================
UPDATE MY_DATA SET SALARY = 15000 WHERE SALARY <= 15000;
SELECT * FROM MY_DATA;
--===================================

--9.  DROP TABLE EMP01 ===========================
DROP TABLE MY_DATA;
SELECT * FROM MY_DATA;


-- ERD : ����ȭ�� �����͸� �����ϱ� ���� DB�� ����ϴµ�, DB�� ������ �������ǵ� �پ��� ����� �����ϴ� ��.

CREATE TABLE DEPT1 (
    DEPTNO NUMBER(2), 
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13),


    PRIMARY KEY(DEPTNO)
);
SELECT * FROM DEPT1;

CREATE TABLE EMP1 (
    EMPNO NUMBER(4) PRIMARY KEY, -- ��������1. PRIMARY KEY   : �������� ������ ���� ���� ����. 
    ENAME VARCHAR2(10) UNIQUE ,   --��������2. UNIQUE
    JOB VARCHAR2(9) NOT NULL ,  --���θ� �ؿ� ����.   --��������3. NOT NULL
    MGR NUMBER(4),
    HIREADTE DATE DEFAULT SYSDATE,  -- ��������4. DEFAULT
    SAL NUMBER(7, 2) CHECK (SAL >0),  --�������� 5. CHECK
    COMM NUMBER(7, 2),
    DEPTNO NUMBER(2) REFERENCES DEPT1(DEPTNO)  --�������� 6. FOREIGN Ű.
    
);
SELECT * FROM EMP1;
--������ �ִ� ������ �θ�Ŭ���� �����͸���.
INSERT INTO DEPT1 VALUES (10, 'ȸ��', '����');
INSERT INTO DEPT1 VALUES (20, '����', '����');
INSERT INTO DEPT1 VALUES (30, '����', '�̴�');
INSERT INTO DEPT1 VALUES (40, '����', '����'); --�ѹ� ����. DML �̱⶧��.

--EMP1 �Է�     --�ؿ� �μ�Ʈ ������ ���̾��Ʈ �ƹ��͵� �ȳ����� ���ε� ������ ����� ��⿡ ����� ��.
INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR,SAL, DEPTNO) VALUES (1111,'ȫ��','ȸ��',NULL,9000,40); 
INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR,SAL, DEPTNO) VALUES (1112,'ȫ��','����',1111,1000,30); 
        --JOB �� ���� �����̶� �ȴ�. + �̸����� ����ũ�ϴٰ� ������ �ɾ �������� �ȴ�.
SELECT * FROM EMP1;
INSERT INTO EMP1 VALUES (1113,'�豺','����',1112,TO_DATE('20201230','YYYYMMDD'), 8000,200,40);
COMMIT; --�� �ϴ��� ������ �����ϰ� ���� Ŀ���Ҳ���, �ѹ��Ҳ��� ��� �˾�â�� �ߴµ� �ű⼭ Ŀ�� �ص� ��.


--EX.�л�����
--SELECT * FROM STUDENT;
--DELETE TABLE STUDENT;
CREATE TABLE MAJOR (
    MAJOR_CODE NUMBER(2) PRIMARY KEY,
    MAJOR_NAME VARCHAR2(100) NOT NULL,
    MAJOR_OFFICE_LOC VARCHAR2(255) NOT NULL

);
SELECT * FROM MAJOR;

CREATE TABLE STUDENT (
    STUDENT_CODE VARCHAR2(10) PRIMARY KEY,
    STUDENT_NAME VARCHAR2(30),
    SCORE VARCHAR(3),
    MAJOR_CODE NUMBER(2) REFERENCES MAJOR(MAJOR_CODE)
    --PRIMARY KEY(STUDENT_CODE), �Ʒ��� �����̸Ӹ� Ű�� �־�����, �Ʒ��� FOREIGN KEY ~~ �־����.
    --FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE) 
);
SELECT * FROM STUDENT;

--MAJOR ������ ����.
INSERT INTO MAJOR VALUES (1,'�濵����','3�� �ι���');
INSERT INTO MAJOR VALUES (2, '����Ʈ�������', '3�� �ι���');
INSERT INTO MAJOR VALUES (3, '������', '4�� ���н�');
INSERT INTO MAJOR VALUES (4, '����','4�� ���н�');

--STUDENT ������ ����.
INSERT INTO STUDENT VALUES ('A01','��浿',100,1);
INSERT INTO STUDENT VALUES ('A02','���浿',90,2);
INSERT INTO STUDENT VALUES ('A03','ȫ�浿',95,1);



--BOOK TABLE 'S

CREATE TABLE BOOKCATEGORY (
    CATEGORY_CODE NUMBER(4) PRIMARY KEY,
    CATEGORY_NAME VARCHAR2(255),
    OFFICE_LOC VARCHAR2(255)


);
SELECT * FROM BOOKCATEGORY;
DROP TABLE BOOK;
CREATE TABLE BOOK(
    CATEGORY_CODE NUMBER(4) REFERENCES BOOKCATEGORY (CATEGORY_CODE),
    BOOKNO VARCHAR2(10) PRIMARY KEY ,
    BOOKNAME VARCHAR2(255),
    PUBLISHER VARCHAR2(30),
    PUBYERA NUMBER(4)  DEFAULT TO_CHAR(SYSDATE,'YYYY')
    
);
SELECT * FROM BOOK;
INSERT INTO BOOKCATEGORY VALUES (100,'ö��','3�� �ι���');
INSERT INTO BOOKCATEGORY VALUES (200,'�ι�','3�� �ι���');
INSERT INTO BOOKCATEGORY VALUES (300,'�ڿ�����','4�� ���н�');
INSERT INTO BOOKCATEGORY VALUES (400,'IT','4�� ���н�');


INSERT INTO BOOK VALUES (100,'100A01','ö������ ��','��������',2017);
INSERT INTO BOOK VALUES (400,'400A01','�̰��� DB�̴�','��������',2018);



--##############[    DCL    ]###############
  --���� �߰� 
CREATE USER KIM IDENTIFIED BY tiger; --KIM ����, ����� tiger ����.
--���� �ο�.
GRANT CREATE SESSION, CREATE TABLE TO kim;
GRANT SELECT ON EMP TO kim;
SHOW USER;

--���� ��Ż.
REVOKE SELECT ON EMP FROM KIM;
DROP USER KIM cascade;

  
  
  
  