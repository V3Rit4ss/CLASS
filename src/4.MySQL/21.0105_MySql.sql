-- 계정생성, 권한부여, 권한박탈, 계정삭제(DCL)
-- MYSQL 과 SQL 차이점.
-- DDL(제약조건,시퀀스 없음) , 
-- DML ( OUTER JOIN, AND = && , OR = || ,일부단일행함수  ) --. . 주석은 --하고 스페이스바
-- JAVA 에서 쓸 데이터 넣고 연습해보기  --하이브에서는 mysql 를 쓰는데 소문자로들 쓴다.
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

create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique, -- 널포함 가능. 널값이 아닐경우 유일한 값 check
    sal numeric(7, 2) check(sal>0),
    hiredate datetime default now(),  -- now 가 현재의 날짜와 시간까지 가지고있는.
    comm numeric (7, 2) default 0
);
drop table if exists emp; 

create table emp(
	empno numeric(4) ,
    ename varchar(20) not null,
    nickname varchar(20) , 
    sal numeric(7,2),
    hiredate datetime default now(),  
    comm numeric (7, 2) default 0,
    primary key(empno),
    unique (nickname),
    check(sal>0));
insert into emp (empno, ename, nickname, sal) values (1111,'홍','천사',9000);
select * from emp;
drop table if exists emp;

-- major (mCODE (pk): 시퀀스처럼 하고싶음., mNAME, mOFFICE)
-- student (sNO, sNAME, mCODE)
create table major(
	mCode int primary key auto_increment, -- 시퀀스처럼 할려면 이렇게 .
    mName varchar(20),
    mOffice varchar(30)

);

create table student (
	sNo int primary key,
    sName varchar(20),
	mCode int  references major(mCode) -- mysql은 옆에다 쓰면 안대고 아래에.
);
select * from major;
select * from student;

insert into major (mName, mOffice) values ('컴공','704호');  -- mCode는 자동적으로 증가값이 들어가기떄문에 선언 x
insert into major (mName, mOffice) values ('경영','702호');
insert into major (mName, mOffice) values ('빅데이터','701호');
insert into major (mName, mOffice) values ('기계','705호');
select * from major;
insert into student values (1111,'홍',1);
insert into student values (1112,'김',2);
insert into student values (1113,'박',2);
insert into student values (1114,'이',5);

select * from student;
drop table if exists student;
drop table if exists major;

create table major(
	mCode int primary key auto_increment, -- 시퀀스처럼 할려면 이렇게 .
    mName varchar(20),
    mOffice varchar(30)

);

create table student (
	sNo int ,
    sName varchar(20),
	mCode int,   -- mysql은 옆에다 쓰면 안대고 아래에.
    primary key(sNo),
    foreign key(mCode) references major(mCode)
);

-- 학번, 이름, 학과명, 사무실 
select  sNo, sName,m.mCode, mName, mOffice from major m ,student s where s.mCode=m.mCode;
																-- where s.mCode(+)=m.mCode mysql 에서는 안댐
-- left outer join
select sNo, sName, m.mCode, mName, mOffice from student s right outer join major m
		on s.mCode=m.mCode;  -- (+) 하고싶은 왼,오른 골라서 outer join major m 'on s.mCode=m.mCode'
        
-- 자바 (JDBC) 수업시간에 쓸 테이블
        
drop table if exists division;
create table division(
	dno int , -- 부서번호
    dname varchar(20),  -- 부서명
	phone varchar(20), -- 부서전화
    position varchar(20), -- 부서위치
    primary key(dno)
);

drop table if exists personal;
create table personal (
	pno int,		-- 사번
    pname varchar(20) not null, -- 사원명
	job varchar(20) not null, -- 직책
	manager int, -- 상사의 사번
	startdate date, -- 입사일. 시간은 안들어감. 들어가게 할려면 datetime
    pay int, -- 급여
    bonus int, -- 상여금
    dno int , -- 부서 번호.
    primary key(pno),
    foreign key(dno) references division(dno)
);
select * from division;
select * from personal;
desc division; -- 오라클의 desc 보다 보기가 더 좋다.

insert into division values (10, 'finance','02-716-1006','신촌');
insert into division values (20, 'research','02-707-7777','용산');
insert into division values (30, 'sales','02-816-8886','동작');
insert into division values (40, 'marketing','02-555-5555','강남');

commit; -- 오라클과 동일한 작동.


insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);

select * from personal;

commit;
-- DML (select , update, delete, insert)

-- select문 (and 연산자는 && 또는 and)
-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal;


-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal where pay between 2000 and 5000;


-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname,dno from personal where dno=10 || dno=20; -- dno in (10,20)
select pno, pname,dno from personal where dno in (10,20);

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
 select pno,pname,pay from personal where bonus is null order by pay desc;


-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select * from personal;
 select pno, pname, dno, pay from personal order by dno,pay desc; 


-- 6. 사번, 이름, 부서명
select * from division;
select pno, pname, dname from personal p, division d where p.dno=d.dno;


-- 7. 사번, 이름, 상사이름
select w.pno, w.pname, m.pname "상사이름" from personal w, personal m where w.manager=m.pno ;

SELECT W.ENAME, W.SAL, DNAME, M.ENAME MANAGER
  FROM EMP W, EMP M, DEPT D 
  WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pno, w.pname, m.pname "상사이름" from personal w left outer join personal m on w.manager=m.pno;
select * from personal;

-- 8-1 사번, 이름, 상사이름(상사가 없는 사람도 출력, 상사가 없을 경우 없음 이라고 출력.) 오라클의 NVL대신 이렇게.
select w.pno, w.pname, ifnull(m.pname, '없다') from personal w left outer join personal m on w.manager=m.pno;

select w.pno, w.pname, if(m.pname is null, '없다', m.pname) from personal w left outer join personal m on w.manager=m.pno;

-- left outer join
select sNo, sName, m.mCode, mName, mOffice from student s right outer join major m
		on s.mCode=m.mCode;  -- (+) 하고싶은 왼,오른 골라서 outer join major m 'on s.mCode=m.mCode'

-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal where pname like 's%';
select pname from personal where substr(pname, 1, 1)='s';
select pname from personal where instr(pname, 's')=1;


-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, dname, m.pname "상사" from personal w, personal m, division d 
	where w.manager=m.pno && w.dno=d.dno;


-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay) ,max(pay) from personal  group by dno;


-- 12. 부서명, 급여평균, 인원수
select dname, round(avg(pay)), count(*) from personal p , division d where p.dno=d.dno group by dname;
select * from personal;


-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay) ,count(*) from personal group by dno having count(*) >=4 ;


-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay from personal
	where pay=(select max(pay) from personal);


-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno from personal where pay>(select avg(pay) from personal);


-- 16. 14번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pno, pname,pay,dname from personal p, division d where p.dno=d.dno and pay = (select max(pay) from personal)
	order by dname, pay desc;


-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
-- 서브쿼리 이용.
select pname, pay, dno, (select avg(pay) from personal where p.dno=dno) from personal p
	where pay > (select avg(pay) from personal where p.dno=dno);
-- inline view 이용
select pname, pay, dno from personal; -- (1)
select dno, avg(pay) avgsal from personal group by dno; -- (2)
select pname, pay, s.dno, avgsal from personal p, (select dno, avg(pay) avgsal from personal group by dno) s
	where p.dno=s.dno && pay>avgsal;

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay, dname from personal p ,division d where p.dno=d.dno 
	and startdate=(select min(startdate) from personal);


-- 19. 이름, 급여, 해당부서평균
select pname, pay, round((select avg(pay) from personal where dno=p.dno), -1) "부서평균" from personal p;


-- 20. 이름, 급여, 부서명, 해당부서평균
select pname, pay , dname, (select avg(pay) from personal where dno=p.dno) "부서평균" from personal p, division d
	where d.dno=p.dno;


-- oracle 에서의 단일행 함수 와  mysql 컬럼함수 의 다른점.
select concat(pname,'은 ',job,'이다') from personal; 
-- 오라클의 연결 연산자 || 못하고 concat 으로 계속 넣을수있다.

select round(356.98, 1);  -- 한행짜리는 from 생략 가능.
select year(startdate), month(startdate), pname from personal;  -- 해당 기간 추출
select monthname(stardate) from personal;  -- 월 이름을 추출 
select dayname(stardate) from personal;  -- 요일 추출.
-- date_format에서 포멧글자.
-- %y 21 (년도 2자리) %Y 2021(년도 4자리.)
-- %m 월이름 (January, ~) %m (01월,02월~) %b 짧은 월이름.(Jan , ~) %c 월 수(1,2,3,~12)
-- %e 일 (1,2,3,4~) %d (01,02,03~)
-- %H 24시간,  %h 12시간, %p (오전오후) %i분 %s초
-- now() = sysdate
select date_format(now(), '%y"년"%c"월"%d일 %p %h시 %i분 %s초');     -- to_char 대신 date_format

-- personal 이름, 입사일(1980년 1월 9일 출력)
select pname, date_format(startdate, '%y년 %c월 %e일') from personal;

-- 시스템으로부터 현재 날짜, 시간을 가져오는 명령어.
select sysdate();
select now();
-- 시스템으로 부터 현재 날짜만.
select current_date(); 
select curdate();

-- 시스템으로부터 현재시간.
select current_time();
select curtime(); 

-- 시스템으로부터 
-- format()
select format(pay, 1) from personal; -- 숫자가 소수점 1자리. -- 3자리마다 , 를 찍는다.
select format(pay, 0) from personal; -- 3자리마다 , 를 찍는다.

-- personal 이름, 급여 , 급여3000이상인지 아닌지 여부 출력.
select pname, pay,if(pay >=3000, '높다' , '낮다') from personal;


-- top - n 구문의 다른점.
select pname, pay from personal order by pay desc;
-- limit n (1~n 등 까지.)
select pname, pay from personal order by pay desc limit 5;

-- limit n1, n2 (n1번째부터 n2개.) n1번째란, 처음 0번째를 뜻함.
-- 4~6 등까지 limit 3,3
select pname, pay from personal order by pay desc limit 3,3;
-- 6~9 등까지 limit 5, 4
select pname, pay from personal order by pay desc limit 5,4;
-- 1~3등까지. limit 0, 3
select pname, pay from personal order by pay desc limit 0,3;
select pname, pay from personal order by pay desc limit 3;



































