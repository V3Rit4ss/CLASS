SHOW USER;
SELECT * FROM TAB;
SELECT * FROM DBA_TABLES; --DBA ������ �ƴ϶� ���ٺҰ�.
SELECT * FROM USER_TABLES; --�� ������ �����ִ� ���̺� ����
SELECT * FROM ALL_TABLES; --���ٰ����� ���̺� ����
SELECT * FROM ALL_TABLES WHERE TABLE_NAME='EMP';
SELECT * FROM SCOTT.EMP; --��������� EMP���̺� ����
EXIT;  --���� ����.
SHOW USER;
SELECT * FROM SCOTT.EMP;  --���� ��Ż �� ���� �Ұ�.
SELECT * FROM ALL_TABLES WHERE TABLE_NAME='EMP';
EXIT;