--[ XI ]  �ε��� : 
SELECT * FROM USER_INDEXES;   -- ��ųʸ��信 ��������� ������ �ε��� ����
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; 
SELECT * FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01;  --1�� ���� (28��) , 2�� (56);
SELECT COUNT(*) FROM EMP01;
INSERT INTO EMP01 SELECT *  FROM EMP01; --12�� ���� (22����). �Ǽ��� �� 92���� �� �� �������;;;
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG',40);
INSERT INTO EMP01 SELECT * FROM EMP01;  -- ������ ����� ������ ���⼭ 180���������� ��.
DESC EMP01;
SELECT * FROM EMP01 WHERE ENAME='HONG'; -- 0.041��.
--�ε��� ������ ������ȸ
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME);
SELECT * FROM EMP01 WHERE ENAME='HONG'; -- 0.01��
DROP INDEX IDX_EMP01_ENAME; --�ε��� ����.
SELECT * FROM USER_INDEXES; --�ε��� ���� ���� Ȯ��, ���̺��� ������ �����.
DROP TABLE EMP01; --Ʈ���� ���� �����Ǽ� ���� �ɸ�������.
