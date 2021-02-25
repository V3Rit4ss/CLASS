show tables; -- select * from tab; 
show databases; -- database 들의 리스트
-- DCL 
create user user01 identified by 'password';
grant all on *.* to user01; -- 권한 부여 . 이거나 아래나 둘중하나
grant all privileges on *.* to user01;   -- 위아래 둘중하나
flush privileges;

-- 권한 박탁.
revoke all on *.* from user01;
revoke all privileges on *.* from user01;
drop user user01;  -- 유저 삭제.

-- 데이터베이스로 들어감.
show databases;
create database kimdb;  -- 새로운 kimdb 데이터베이스 생성댐.  , 있는데 또 만들면 오류남.
show databases;
use world; -- world 데이터베이스로 들어가는 명령어.
use kimdb; -- kimdb 데이터베이스로 들어가는 명령어.   서로 왔다갔다 할수있음.
select database(); -- 현재 들어와있는 데이터베이스를 알려줌.
select * from personal;
desc personal;
alter user 'root'@'localhost'
	identified with mysql_native_password BY  'mysql';