# # # 6장. 데이터베이스 이용 # # #

# SQL 문으로 데이터프레임과 DB테이블 이용.

rm(list=ls(all.names= T))
#1 SQL 문을 이용한 데이터프레임 처리
install.packages("sqldf")
library(sqldf) #의존하는 패키지들이 매우많다.
# ‘fastmap’,‘bit’,‘cachem’ ... , 등을 의존한다.
library(sqldf)
#sqldf() 함수를 통해 데이터프레임을 DB의 테이블처럼 사용가능.

sqldf("select * from iris")

#중복행 제거하여 한번만 출력(iris 의 종을 출력하라.)
sqldf("select distinct Species from iris") #distinct 중복제거
names(table(iris$Species))
library(dplyr)
iris %>% 
  group_by(Species) %>% 
  summarise()

#행 제한조건 설정. (virginica 종만 가져와라)
sqldf("select * from iris where species=='virginica'")  #sql문은 대소문자 구분안하니 대문자로 하던 소문자로 하던 상관무. R은 대소문자 구문함.
iris[iris$Species == 'virginica',]
iris %>% 
  filter(Species == 'virginica')

#컬럼에 . 이 내포한 경우 =  `` -> '' , "" 아니라 물결표시 에 있는것 이다.
#virginica 종 이면서 sepal.Length가 7.5 초과한 데이터만 출력.
sqldf("select * from iris where Species == 'virginica' and `Sepal.Length` >7.5") #(1) (` 필.드명 `) 사용 [  . 때문에 이렇게 쓰인다.]
iris[iris$Species == 'virginica' & iris$Sepal.Length >7.5,] #(2)
iris %>% 
  filter(Species == 'virginica' & Sepal.Length >7.5) #(3)



#종별 Sepal.Length의 합을 출력.
sqldf("select Species, sum(`Sepal.Length`)from iris group by Species")

tapply(iris$Sepal.Length, iris$Species, mean)
by(iris$Sepal.Length, iris$Species, mean)
library(doBy)
summaryBy(Sepal.Length~ Species, iris, FUN=mean)
aggregate(iris$Sepal.Length, by=list(iris$Species), mean)


#정렬 (Sepal.Length가 1~5등, 6~10등) limit 은 0번부터 시작한다.
sqldf("select * from iris order by `Sepal.Length` limit 5 ") #0번째부터 5까지.
sqldf("select * from iris order by `Sepal.Length` limit 5, 5") #5번째부터 5까지.


#sql함수(mySQL함수) 사용 : Petal.Length, Petal.Width의 평균과 표준편차 열2개 함수도 2개
sqldf("select avg(`Petal.Length`) as mean_Length , stdev(`Petal.Length`) as st_Length , avg(`Petal.Width`) as mean_Width , stdev(`Petal.Width`) as st_Width from iris")
apply(iris[,c('Petal.Length','Petal.Width')], 2, mean)
apply(iris[,c('Petal.Length','Petal.Width')], 2, sd)
apply(iris[,3:4], 2, mean); apply(iris[,3:4], 2, sd)




#sql함수(mySQL함수) 사용 : 종에 따른 Petal.Length, Petal.Width의 평균과 표준편차
sqldf("select Species, avg(`Petal.Length`) 
      as mean_Length , stdev(`Petal.Length`) 
      as st_Length , avg(`Petal.Width`) as mean_Width , stdev(`Petal.Width`) as st_Width from iris group by Species")

summaryBy(Petal.Length+Petal.Width~Species, iris, FUN = c(mean,sd))

sqldf("select round(avg(`Petal.Length`),2) from iris") #소수점 몇자리까지 나타나게 할것인지

iris %>% 
  summarise(mean = round(mean(Petal.Length),2))


#조인.
#조인 하기전 작업 디렉토리 경로확인 or 수정(해당 파일이 있는 경로 or 작업하던 경로).
getwd() #작업 디렉토리 경로를 출력.
setwd() # 작업 디렉토리 경로를 변경.
getwd() #변경된 작업디렉토리 확인.

emp <- read.csv("Data/emp.csv", header = T)
colnames(emp) #열 이름 확인/
head(emp) # 확인.

dept <- read.csv("Data/dept.csv")
head(dept)

#사번, 이룸, 직책, 월급, 부서번호, 부서이름.
sqldf("select empno, ename, job, sal,emp.deptno, dname from emp, dept where emp.deptno=dept.deptno")

sqldf("select empno, ename, job, sal, e.deptno, dname from emp e , dept d where e.deptno=d.deptno")


#사번,이름, 부서번호, 부서이름 # emp e join dept d d랑 e  조인 하겠다. mysql 문법.
sqldf("select empno, ename, e.deptno, dname from emp e join dept d on e.deptno=d.deptno")


rm(list=ls())
emp
dept

#2. 오라클 데이터베이스 연결
# 연결전 작업. :자바를 설치하고 환경설정(JAVA_HOME), 작업디렉토리(getwd()) 에 ojdbc6.JAR를 넣기.
getwd() #디렉토리 경로 확인.
#패키지 설치 및 로드 : JDBC
install.packages("RJDBC")
library("RJDBC")
library(RJDBC)
#드라이버 로드(from JAVA). = 드라이버 클래스 로드(from R)
drv <- JDBC("oracle.jdbc.driver.OracleDriver", classPath = "ojdbc6.jar")
drv

#데이터베이스 연결.
con <- dbConnect(drv, "jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott","tiger")
con
#SQL 전송(select 문 일때.) + 결과 받기  = 데이터프레임만 받는다.
emp <- dbGetQuery(con, "select * from emp")
emp

class(emp)
summary(emp)
head(emp)
tail(emp)
emp[1:2,'EMPNO']


#전송 안하고 특정 table 전체 데이터 조회
dept <- dbReadTable(con, "dept") #테이블 명.
dept
class(dept) #데이터프레임.


#SQL전송(update, insert, delete) -DB 데이터 수정.
dbSendUpdate(con, "insert into dept values (60,'it','PUSAN')")
dbSendUpdate(con, "UPDATE DEPT SET LOC='hongkong' WHERE DEPTNO=60")
dbSendUpdate(con, "DELETE FROM DEPT WHERE DEPTNO>=50" )


#연결해제. select 문은 상관은 별로 없지만, update,delete,insert 는 꼭 연결을 해제해줘야한다.
dbDisconnect(con)


#드라이버 언로드 : DB 연결 해제시 자동 언로드 됨.
dbUnloadDriver(drv) #위에서 연결 해제를 했기에 FALSE 가 나온다.

#패키지 언로드. = 혹시 모를 충돌방지 위함.
#library("RJDBC")
#library(RJDBC)
detach("package:RJDBC", unload = T)



#3.  MySQL 데이터베이스 연결.
# MySQL Workbench 에서 
# ALTER USER '아이디'@'localhost' IDENTIFIED WITH mysql_native_password BY '비밀번호';
# ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'mysql';

install.packages("RMySQL")
library(RMySQL)
drv <- dbDriver("MySQL")
drv
con <- dbConnect(drv, host="127.0.0.1", dbname="kimdb", user="root", password="mysql")
con

rs <- dbSendQuery(con, "select * from personal")
rs
personal <- fetch(rs,n=-1)
personal
class(personal)

dbDisconnect(con) #연결해제
dbUnloadDriver(drv)#드라이버 언로드 : DB 연결 해제시 자동 언로드 됨.
personal



