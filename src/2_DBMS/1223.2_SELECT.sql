-- [II] select 문    -- 은 주석 처리다.   SQL은 대소문자 구분이 없기에 대문자로 고정.
SELECT * FROM TAB;   -- 현계정 SCOTT이 가지고 있는 테이블들 ( 컨+엔터 하면 밑에 표시해줌)
SELECT * FROM DEPT; --DEPT테이블의 모든 열과 모든 행을 볼수있다.
SELECT * FROM EMP; -- EMP테이블의 모든행 모든열 보여주는.
SELECT * FROM TAB;  --SCOTT 이 소유하고있는 테이블을 전부 보여줌
SELECT * FROM DEPT; --DEPT 테이블 데이터 전체 보여줌
DESC DEPT;   --DEPT 테이블의 구조보기.
SELECT * FROM EMP;
SELECT EMPNO, ENAME, SAL , JOB FROM EMP;
SELECT empno AS "사번", ename AS "직원 이름", job AS "직업" FROM emp; -- 별명을 지어줄때
SELECT empno 사번, ename 이름, job 직업 FROM emp;  --AS 가 있던 없던 ""가 있던 없던 가능.
SELECT empno AS NO, ename AS NAME, job FROM emp; --한글 , 영어 둘다 가능.
SELECT empno, ename, job FROM emp;      -- 사번과 이름 직업만을 보고싶을때.

--3. WHERE 절 (조건) 비교연산자를 이용
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP  --특정한 열에
    WHERE SAL=3000;  -- SAL 이 3000인 행만 출력함.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL!= 3000;    
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL^= 3000;  --셋다 다르다 라고 한다.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<> 3000;  

--10번 부서인 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE DEPTNO=10;  
--ENAME 이 'FORD'인 직원의 모든 필드를 출력
SELECT * FROM EMP WHERE ENAME='FORD';  --데이터는 대소문자 구별 가능.
select * from emp where ename='ford';   --안나옴.
-- 급여가 2000이상 3000미만인 직원의 모든 필드를 출력.
SELECT * FROM EMP WHERE SAL>= 2000 AND SAL<3000;  --AND => &  OR => |
--비교연산은 숫자 , 문자, DATE형 (날짜) 모두 가능.
SELECT * FROM EMP WHERE ENAME < 'F';  --이름이 F보다 작은 사람 뿌려라.  ABCDE 로 시작하는 사람 뿌려줌.
-- 라 보다 작은 사람 뿌려라 = 가나다 이름만 나옴.
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';  --81년도 보다 작은사람 뿌려라
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';  --82년도 보다 크고  82년 12.31 보다 작은 사람들.
--날짜 표시법 셋팅
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD';  --날짜 타입 바꿈.
--연봉이 2400이상인 직원의 ENAME , SAL , 연봉 출력(연봉=SAL*12)  '' 데이터. ""별명
SELECT ENAME 이름, SAL 급여, SAL*12 연봉 FROM EMP WHERE SAL*12>2400 ORDER BY 연봉;  --WHERE 절에는 별명을 넣을수가없다. 
 -- 1프롬절 2웨얼 절 3셀렉트절 4오더절  셀렉절에 별명을 선언 했기때문에 오더절에서 별명선언을 한것을 알아서 쓸수있다 --ORDER BY 절에는 별명 가능.      
--5. 산술 표현식  아무대서나 가능.
SELECT ENAME, SAL , SAL+300 UPGRADESAL FROM EMP;
--모든사원의 사원명, 월급(SAL),연봉(SAL*12+COMM(상여금))
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM,0) FROM EMP; --널값 대신 대치값 지정한걸 넣어라
--산술연산의 결과는 NULL을 포함하면 결과는 NULL -> NVL(NULL 일수도 있는 필드명, 대치값)  둘의 타입이 같아야함.
DESC EMP;  -- COMM 유형이 NUMBER 라서 넘버만 들어간다.
--모든사원의 사원명, 월급(SAL), COMM ,연봉(SAL*12+COMM(상여금)) COMM이 NULL이면 0으로 하자.
SELECT ENAME, SAL, NVL(COMM, '0$'), SAL*12+NVL(COMM, 0) FROM EMP;  --'0$' 넘버 타입이 아니라 안댐. 하려면 형변환 해야함.
--모든 사원의 사원명(ENAME), 상사의 사번(MGR) 상사가 없으면 CEO 출력불가  =0으로 출력해보자
SELECT ENAME, NVL(MGR, 0) FROM EMP;
--연결 연산자.( || ) = 열이나 문자를 연결함.
SELECT ENAME || ' 은 ' || JOB || ' 이다'  FROM EMP;
 --"SMITH IS CLERA" 로 출력되고 TITLE EMPLOYEES 라고 모든 직원 출력
 SELECT ENAME || ' IS ' || JOB EMPLOYEES FROM EMP;
 --중복제거  = DISTINCT
 SELECT DISTINCT JOB FROM EMP;   --셀렉과 잡 사이에.
 SELECT DISTINCT MGR FROM EMP;
 
--중간 연습문제.
--1. emp 테이블의 구조 출력
DESC EMP;
--2. emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;
--3. 현 scott 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB;
--4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO, ENAME ,SAL, JOB, HIREDATE FROM EMP;
--5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000 ;
--6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME , JOB, HIREDATE FROM EMP WHERE HIREDATE>='81/02/01';
--7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB='SALESMAN';
--8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB!='CLERK'; -- != , <> , ^= 세개중 아무거나.
--9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL <=3000;
--10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;
--11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL>=3000;
--12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME ,JOB, SAL FROM EMP WHERE SAL>=2500 AND JOB='MANAGER';
--13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력
SELECT ENAME || '은(는) '||JOB||'업무이고 연봉은'||(SAL*12+NVL(COMM,0)) || '다' FROM EMP;

--8번. SQL 연산자. 	DISTINCT : 중복제거 
--SAL 이 1500이상이고 3000이하면 사번, 이름, 급여 출력 을 SQL 연산자로 써보자
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL <=3000;
--필드명 BETWEEN A AND B (A~B까지 , A와 B 포함.) 문자와 데이트형도 가능.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
--82년도에 입사한 직원의 모든 필드를 출력.
SELECT EMPNO, ENAME , JOB, HIREDATE FROM EMP WHERE HIREDATE>='81/01/01' AND HIREDATE<= '82/12/31';
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31'; --앞에 데이터가 작아야함.
--이름이 A~C로 시작하는 사람.
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D';  --컨 + D 를 하면 싹다 지움.  자바에서는 한줄지우기.
                                                    -- ENAME != 'D' D를 빼고~
--부서번호 (DEPTNO) 가 10,20 인 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO =20;
SELECT * FROM EMP WHERE DEPTNO IN (10,20);  --IN 연산자
                                                    
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20); --부서번호가 10과 20이 아닌 사람들.
-- EMPNO 가 7902, 7788 7566 인 사원의 모든 필드.
SELECT *FROM EMP WHERE EMPNO IN (7902, 7788, 7566);
--이름이 M 으로 시작하는 사원의 모든 필드.  M_(언더바는 한글자수.) ,  M% 0글자 이상. 
SELECT * FROM EMP WHERE ENAME LIKE 'M%'; --0글자 이상.  라이크는 문자에 많이 쓰인다.
-- 이름에 N이 들어가는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%N%';  -- 앞과 중간 뒤에 들어가는 애들을 찾아준다.
--이름이 S 로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S';
--이름에 %가 들어가는 사원의 모든 필드
INSERT INTO EMP VALUES (9999,'A%',NULL,NULL,NULL,9000,9000,40);--해당 테이블의 모든 값을 넣어야한다.
--기존의 테이블에 없는 데이터를 넣을라면 INSERT INTO 테이블 VALUES (테이블 정보칸 갯수에 맞게.);
SELECT * FROM EMP;
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';  --% 가 연속으로 있는거는 이렇게.
ROLLBACK; --(DML 데이터 조작어를 취소) 
SELECT * FROM EMP;  --A% 추가된것이 취소댐.
--SAL 이 5로 끝나는 사원의 모든 필드.   VACHAR 문자.
SELECT * FROM EMP WHERE SAL LIKE '%5';  --문자도 데이트형도 되긴함.
--입사년도가 82년인 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE >='82/01/01' AND HIREDATE <= '82/12/31' ;
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31' ;
SELECT * FROM EMP WHERE HIREDATE LIKE '82/__/__' ;
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';

SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('1982/01/01','YYYY/MM/DD') AND TO_DATE('1982/12/31', 'YYYY/MM/DD');
--타임존 이 다르면 이렇게 해서 바꿔줘야 한다.

--1월에 입사한 사원의 모든 필드 출력  '%/01/%'
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
--상여금이 없는 사원의 모든 필드 출력.
SELECT COMM FROM EMP; --COMM 이 어떻게 있는지 본다.
SELECT * FROM EMP WHERE COMM=0 OR COMM IS NULL;  --널값을 뽑고싶으면 IS NULL 로 해야함.
--상여금이 있는 사원의 모든 필드 출력.
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM!=0;   --널도 아니고 0도 아닌 값들.

--9.정렬 (오름차순, 내림차순)
SELECT ENAME , SAL FROM EMP ORDER BY SAL; --오름차순 정렬   ORDER BY SAL(ASC); 가로안은 생략 가능함.
SELECT ENAME , SAL FROM EMP ORDER BY SAL DESC; -- 내림차순 정렬
--SAL 이 높은 순으로 출력(단, 같은 SAL 일 경우 입사일 최신 순으로 정렬.)
SELECT * FROM EMP ORDER BY SAL DESC, HIREDATE ; --SCOTT 과 FORD 의 입사일 차이에 따라 오름과 내림차순.
SELECT * FROM EMP ORDER BY SAL DESC, HIREDATE DESC; --위와의 차이는 입사일기준으로 빠른날짜의 오름내림차순.
SELECT * FROM EMP ORDER BY SAL DESC, HIREDATE DESC, ENAME;  -- 이름순서대로 가나다라 ABCD 
SELECT * FROM EMP ORDER BY ENAME;
--이름,연봉(SAL*12+COMM)을 출력 (연봉이 높은 순 으로) --ORDER BY 연봉(별명) DESC; 이렇게 가능.
SELECT ENAME, SAL*12+NVL(COMM,0) 연봉 FROM EMP ORDER BY SAL*12+NVL(COMM,0) DESC;
--이름,연봉이 2000이상인 직원의 이름,연봉을 출력 (연봉이 높은순) --WHERE 절에는 계산식을 넣어야함. 별명 넣는거 불가.
SELECT ENAME, SAL*12+NVL(COMM,0) 연봉 FROM EMP WHERE SAL*12+NVL(COMM,0) >= 2000 ORDER BY 연봉 DESC;


--지금까지한 모든 것들의 문제들.

--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 3000 ORDER BY SAL;
 
--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO = '7788' ;

--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME ,SAL FROM EMP WHERE (SAL*12+NVL(COMM,0)) >= 24000 ORDER BY SAL;

--4.	EMP 테이블에서 hiredate가 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 
--ename,job,hiredate을 출력하는 SELECT 문장을 작성 (단 hiredate 순으로 출력)
SELECT ENAME , JOB, HIREDATE FROM EMP WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' ORDER BY HIREDATE;

--5.	EMP 테이블에서 deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN (10,20) ORDER BY ENAME;

--6.	EMP 테이블에서 sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
-- (단 HEADING을 employee과 Monthly Salary로 출력)
SELECT * FROM EMP;
DESC EMP;
SELECT ENAME employee , SAL "monthly" FROM EMP WHERE SAL >= 1500 AND DEPTNO IN (10,30);

--7.	EMP 테이블에서 hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY/MM/DD') LIKE '1982&';
--날짜형 -> 문자형 TO_CHAR(HIREDATE, 'YYYY/MM/DD') = '1982/02/14'
--문자형 -> 날짜형 TO_DATE('1982/12/12','YYYY/MM/DD') =날짜형으로 바뀜.
 
--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME , SAL FROM EMP 
            WHERE (ENAME BETWEEN 'C' AND 'Q') AND ENAME != 'Q' ORDER BY ENAME; --Q 까지 했을때 AND ENAME!='Q' 로하면 Q는 빠짐.

--9.	EMP 테이블에서 comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 
--출력하는 SELECT 문을 작성
SELECT ENAME , SAL, COMM FROM EMP WHERE COMM>SAL*1.1;

--10.	EMP 테이블에서 job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT * FROM EMP WHERE (JOB = 'CLERK' OR JOB = 'ANALYST') AND SAL NOT IN (1000, 3000, 5000) ;
SELECT * FROM EMP WHERE JOB IN('CLERK' , 'ANALYST') AND SAL NOT IN (1000, 3000, 5000);
SELECT * FROM EMP WHERE (JOB = 'CLERK' OR JOB = 'ANALYST') AND NOT ( SAL IN (1000,3000,5000));

--11.	EMP 테이블에서 ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 
--모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND (DEPTNO = 30 OR MGR = 7782);

--12.	사원 테이블에서 입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/__/__';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE BETWEEN '81/01/01' AND '81/12/31';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE BETWEEN TO_DATE('1981/01/01' , 'YYYY/MM/DD')
                                                                        AND TO_DATE('1981/12/31' , 'YYYY/MM/DD');
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'YYMMDD') BETWEEN '810101' AND '811231';  
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'YYMM') BETWEEN '8101' AND '8112';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = '81' ;
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY') = '1981';

--13.	사원 테이블에서 입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 
-- 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/__/__' AND JOB != 'SALESMAN';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81%' AND JOB!='SALESMAN';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = '81' AND JOB != 'SALESMAN';
--14.	사원 테이블의 사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
-- 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE ;

--15.	사원 테이블에서 사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';

--16.	사원 테이블에서연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME , SAL*12 "연봉"  FROM EMP WHERE SAL*12 >= 35000;


