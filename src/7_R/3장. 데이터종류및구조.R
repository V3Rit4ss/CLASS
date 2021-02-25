# # 3 장 . R 데이터 종류 및 구조 # # #

#1. 데이터 종류 : 기본데이터 타입(문자,숫자,logical(boolean)= 스칼라타입
        # 팩터, 벡터, 리스트, ★행렬, 배열, ★데이터프레임, 날짜, 특별한 값(결측치, ...)
#2. 기본데이터 타입 : charactor, numeric, logical
a <- "Hello"
a <- "Hello
R" # \nR 붙음 또는 \n 을 넣어도 댐. 
a

cat(a) # print와 비슷, \n을 수행
cat('a값은',a)
b <- 10.1
b <- 10
strB <- as.character(b) #char 로 바꿔라. (as.~~() ) *타입으로 형변환함수.
strB
c <- TRUE;
c
is.logical(c) #is.~() : ~형 이나 값을 물어보는 함수.
#methods(is) -> is.~()


class(strB)
class(b)
class(a) #class()함수는 타입을 알고싶을때
class(c)

str(a) # str() 함수는 R의 내부구조를 간결하게 표시.
str(b)
str(c)


#3. 특별한 값(Null, NA:결측치(값을 안넣음), NaN, Inf(인피니티))
result <-0
add <- function(a,b) {
  result<<- a*5+b  #전역변수 result 에 할당. function 에서만 먹는
#  return(result)
  return() # 리턴을 지정안하면 null 로 되네.
}
(temp <- add(1,2)) # 일반변수 temp에 할당.
(temp <- add(a=1, b=2))
(temp <- add(b=10, a=5)) # b=10 , 5 나머지에 알아서 들어감.
(temp <- add(a=1, b=3)) # NULL : Empty value 
is.null(temp) #is.~ = 타입이냐?

d <- c(2 ,4 ,NA ,6 ,NaN ,10/0) #vector(동일자료형 집합)
d
# NA (결측치) 관련 함수
#is.na(d) 결측치의 여부. NA가 있으면 TRUE
#complete.case(d) NA가 없으면 TRUE
#na.omit(d) : 결측치 제외
#na.pass(d) : NA여부 상관없이 처리.

is.na(d[3]) #d의 3번째는 결측치냐? 라고 알려주는. TRUE/FALSE
is.na(d)
?is.na
complete.cases(d)
na.omit(d)
na.pass(d)
mean(d) # 결측치가 들어가있으면 평균치 값을 구하지 못한다. 그래서 NA 로 나온다.
?mean
d <-c(2,3,4,5,NA,12) #12를 넣을때와 안넣었을때 차이점을 봐보자.
mean(d, na.rm=TRUE)
boxplot(d) #시각화 중 하나.

# 4. 팩터(factor) : 범주형 데이터 = 명명식,순서식에 쓰인다.
gender1 <- c('남','남','여')
gender1[3]
class(gender1)
gender1[4] <- '중성' # 이렇게 값이 추가되는걸 막고싶을때.
gender1
gender1 <- factor(c('남','남','여'), levels=c('남','여'))
class(gender1) # 캐릭터형 으로 안나오고 팩터형으로 나옴
gender1[3] # 남과여 중에 여. 이다.
gender1
str(gender1)
gender1[4] <- '중성' # 추가가 안되는지 확인해보자.
gender1 #결측치가 들어갔다.

level <- factor(c('좋음','보통','보통'), levels = c('싫음','보통','좋음'),ordered=TRUE)
level
level <- ordered(c('좋음','보통','보통'),levels=c('싫음','보통','좋음'))
level
level[4] <-'몰라'
level
nlevels(level) #level 변수의 범주 갯수 수수
nlevels(gender1)
levels(level) #level 변수의 범주들
gender1 <- c('남','남','여')
class(gender1)
gender1 <- as.factor(gender1) #5장 전처리 에서 더 자세히.
gender1


# 5.구조형 변수와 복합형 변수 = 변수하나에 여러 값을 가져야함.

#(1) 구조형 변수 : 동일자료형이 여러개 ex.)벡터, 행렬(회귀식 용어), 배열
#(2) 복합형 변수 : 서로 다른 자료형을 가질 수 있다. ex.)리스트, 데이터프레임(csv파일을 가지고 할때)

#6. 벡터 : 동일자료형의 '집합'.
data <- c(11,22,33,'test')
data #숫자 , 문자를 동시에 넣으면 문자로 된다.
data <- c(11,22,33, TRUE) # 숫자, logical -> 숫자로.(T:1, F:0)
data
data <- c(TRUE,'test') #logical 과 문자는 문자로.
data

data <- c(1,2,3) #1 인덱스 부터 시작.
data[4] <- 40 #배열이 아니라 언제든지 아무거나 추가가능.
data

#행과 열 졍보 조회
NROW(data) #항목의 갯수
length(data) #항목의 갯수

data <- c(1:100) #1~100까지 넣음.
data #[1] [26] ~ 라고 나오는건 한줄에 다 안나올때 해당값의 인덱스 자리를 알려주는것이다.

data <- c(1:4)
data
names(data) <-c('A열','B열','C열','D열')
data

#특정한 값 조회
data[1] #첫번째 값을 조회 하고싶을때. (첫번째 값 반환.)
data['A열'] # A열 값 반환
data[c(1,2)] #첫번째 값과 두번째 값 반환
data[c(1:2)] # 첫번째 부터 두번째 값까지의 값 반환.
data[c('A열','B열')] #A열B열 값 반환
data[-2] #음수일 경우 2번째 제외.
data[data>2] #2보다 큰 값만 반환.
data[c(TRUE,FALSE,FALSE,TRUE)] #TRUE 인 열의 값만 반환.
2 %in% data #data 안에 2가 포함되어 있는지 여부. 있으면 TRUE. 없으면 FALSE T/F

#q1 시험점수 변수를 만들고 출력하고 전체 평균을 구한 후 출력.
# 80,60,70,50,90, 미응시.
# yi, kim, yun ,lim, lee, park

jumsu <- c(80,60,70,50,90,NA)
jumsu #print(jumsu), cat(jumsu) 출력.
print("시험점수는") # "" 등장.
cat("시험점수는") # "" 없음.
cat(jumsu)
(avg <- mean(jumsu)) #na 값이 나옴
help(mean)
(avg <- mean(jumsu, na.rm= TRUE)) #na값이 있을때 평균 내기.
names(jumsu)
names(jumsu) <- c('yi', 'kim', 'yun' ,'lim', 'lee', 'park')
jumsu
jumsu[jumsu>80]



# 벡터를 만들때 c(~~) 로 했는데 다른것도 있다.
class(jumsu) # class함수 이용시 벡터요소의 하나하나의 타입을 알려줌.
is.vector(jumsu) #jumsu 가 벡터이냐? TRUE.

#6.1 character()
charArr <- character() # charArr length 가 0인 벡터
is.vector(charArr)
length(charArr)
charArr <- character(5) #length가 5인 벡터
charArr
charArr[1] <- '안녕'; charArr[2]='R'; charArr[3]='수업중'
charArr
charArr[10] <- '테스트'  #도중에 뛰어넘겨서 값을 넣으면 NA 가 들어간다.
charArr
#6.2 numeric()
intArr <- numeric()
class(intArr)
is.vector(intArr)
intArr[1] <- 1
intArr[3] <- 3 #[2] 에 안넣고 [3] 에 값을 넣으면?
intArr # 2번은 결측치가 되어진다.
#6.3 logical()
logicalArr <- logical(2) #length 가 2인 logical 벡터
logicalArr[1] <- TRUE
logicalArr[2] <- FALSE
logicalArr[3] <- T
logicalArr

#6.4 seq() #순서 객체를 만드는 함수.
?seq
a <- seq(from= 1,to= 10)
a <- seq(from= 1, to= 10, by=2) #1~10까지 2씩 증가.
a <- 1:10
is.vector(a)
seq(10, -10, -2) #10 ~ -10 까지 -2씩.
seq(0,1 ,0.1)
seq(1,9, by=pi)

#6.5 rep() : 반복객체를 만드는 함수
rep(1:4, each= 2) #11 22 33 44
rep(1:4, c(1,2,3,4)) # 1 22 333 4444
rep(1:4, each= 2, len=6)
rep(1:4, times=2) # 1234 1234


#6.6 벡터의 연산. ( + , - , * , / ,결합,교집합,합집합,차집합,비교연산)

a <-c(1,2,3)
b <-c(10,20,30)
a+b
a-b
a^b
a*b
a%%b #나머지 연산자.
c(a,b) #벡터의 결합.

a<-c(1,2,3)
b<-c('Hello','R')
c<-c(TRUE,FALSE)
(z<-c(a,b,c)) # 타입이 달라서 문자로 결합됨. (다른 타입의 벡터 결합시. 타입이 바뀜.)

a <- append(a,c(4,5,6)) #123 (456)추가.
a <- append(a, 7)
a
a[8] <- 8
a

#벡터의 집합 연산. : 합집합, 교집합, 차집합, 비교
a <- c(1,2,3,4,5,6)
b <-c(2,4,6,8,10,12)
union(a,b) #합집합. 1 2 3 4 5 6 8 10 12
intersect(a,b) #교집합   2 4 6
setdiff(a,b) #차집합  1 3 5
setequal(a,b) #비교
setequal(a, c(intersect(a,b),setdiff(a,b)))

#7. 리스트

student <- list(name='홍길동',age=25)
student
student $name #원하는거 조회.
studentVector <- unlist(student)
studentVector
#studentVector 를 아래처럼 만든것처럼 똑같다.
s <- c('홍길동',25)
names(s) <- c('name','age')
s
student <- as.list(s) #as.list() : list형으로 형변환.
student
student$name #student['name']
student[1] #$name [1] 홍길동
student[[1]] #[1] 홍길동
student$age <- NULL #age 제거.
student

NROW(student) #age 제거되어서 항목의 갯수 1.
length(student) #age 제거되어서 항목의 갯수 1.


#8. 행렬

colMatrix <- matrix(1:15, nrow=5, ncol=3) #data =1:15 1~15. 
colMatrix #5행 3열 짜리.
?matrix # matrix(data = NA, nrow = 1, ncol = 1, byrow = FALSE, dimnames = NULL)
colMatrix <- matrix(1:15, nrow=5, byrow= FALSE)
colMatrix
rowMatrix <- matrix(1:15, nrow=5, byrow= T, dimnames = list(c('R1','R2','R3','R4','R5'), c('C1','C2','C3')))
rowMatrix
dim(rowMatrix) #행과 열의 수
nrow(rowMatrix)#행 수
#NROW(rowMatrix) 대소문자 구분x
ncol(rowMatrix)#열 수 
#NCOL(rowMatrix) 대소문자 구분x
dimnames(rowMatrix) # 행,열 이름.
rownames(rowMatrix) #행이름
colnames(rowMatrix) #열이름

# 행이름과 열이름 수정.
dimnames(rowMatrix) <- list(c('1월','2월','3월','4월','5월'), c('kim','lee','choi'))
dimnames(rowMatrix)
rowMatrix


#행렬의 곱을 이용하여 선행회귀식 도출.

x <- c(2,4) #공부량
x
y <- c(40,60) #점수

X <- matrix(c(x, rep(1, NROW(x))),nrow=2, ncol=2, byrow=FALSE )
X #matrix 는 대문자로 표시한다.

Y = matrix(y, ncol=1)
Y
# x %*% ab = Y
# solve(x) %*% x %*% ab = solve(x) %*% Y
ab <- solve(X) %*% Y # solve() 역행렬.
ab
ab[1] #x의 기울기.
ab[2] #절편.
plot(x, y)
lines(x, x*ab[1]+ab[2])

x <- c(32,64,96,118,126,144,152.5,158) #독립변수
y <- c(18,24,61.5,49,52,105,130.3,125) #종속변수수

X <- matrix(c(x, rep(1, NROW(x))), ncol=2)
X
Y <- matrix(y, ncol=1)
Y
# X %*% ab = Y
#solve(X) #정방행렬이 아니라 역행렬 불가.
#전치행렬을 곱해서 정방행렬.
t(X)
t(X) %*% X #2행 8열 %*% 8행 2열 => 2행2열 정방행렬.

# X %*% ab = Y
# t(X) %*%  X %*% ab = t(X) %*% Y
# solve(t(X) %*% X) %*% t(X) %*% X %*% ab = solve(t(X) %*% X) %*% t(X) %*% Y
# ab = solve(t(X) %*% X ) %*% t(X) %*% Y
ab = solve(t(X) %*% X) %*% t(X) %*% Y
ab
plot(x, y)
lines(x, x*ab[1]+ab[2])

#다변량 에서의 회귀분석 도출.
x1 <- c(60,65,55) #몸무게
x2 <- c(5.5,5.0,6.0) #키
x3 <- c(1,0,1) #흡연유무
y <- c(66,74,78)
X <- matrix(c(x1,x2,x3), ncol=3)
X
Y <- matrix(y, ncol=1)
Y
# X %*% ab = Y 
#solve(X) %*% X %*% ab = solve(X) %*% Y
# ab = solve(X) %*% Y
ab = solve(X) %*% Y
ab


#몸무게 80kg , 키 6.5ft, 금연 . 수명?
80*ab[1] + 6.5*ab[2] + 0*ab[3]

# 행렬 연산 (+,-,*,/,%%, ~ , %*% ) %*% :행렬 곱.
a <- matrix(1:4, nrow=2 , ncol=2)
a
b <- matrix(seq(10,40,10), nrow = 2, ncol=2)
b
a + b # 같은행 같은열 끼리만 연산.
a * b
a ^ b
a %% b #나머지연산.

# 행렬연산 중 행렬 곱(%*%) ncol : 열. nrow : 행.
payMatrix <- matrix(c(12000,26000,18000), ncol=3)
payMatrix #1행 3열
dimnames(payMatrix) <- list(c('시간당 수당'),c('철수','영희','말자'))
payMatrix
workerMatrix <- matrix(c(c(5,4,9),c(7,3,2)), ncol=2)
workerMatrix #3행 2열
dimnames(workerMatrix) <- list(c('철수','영희','말자'),c('1월','2월'))
workerMatrix

cost <-payMatrix %*% workerMatrix #1x3 %*% 3x2 => 1x2
cost
rownames(cost) <- c('인건비')
cost

# 9. 배열.

dataArray <- array(1:24, dim=c(3,4,2)) #3행4열 2면 3차원배열열
dataArray
dim(dataArray) #차원의 크기 조회 가능.
nrow(dataArray) #행 수 조회.
NROW(dataArray)
ncol(dataArray) #열 수 조회
NCOL(dataArray) ## 대소문자 구분 없음. 이것들만.
length(dataArray) # 요소의 갯수

dimnames(dataArray) <- list(c('1행','2행','3행'), c('1열','2열','3열','4열'), c('x면','y면'))
dataArray
dim(dataArray) <- c(3,8) #3x4x2 = 3x8
dataArray #차원을 변경하면 이름지정한것이 사라진다.
dim(dataArray) <- c(8,3) #이러한것을 reshape.
dataArray
attr(dataArray, 'dim') <- c(3,8) #이것도 reshape
dataArray

#\\\\\\\\\\\\ 10. 데이터프레임 \\\\\\\\\\\\
# (1) 데이터프레임 생성.
student_id <- c('20211','20212','20213','20214')
student_name <- c('Jin','Eric','Den','Kei')
student_eng <- c(60,85,90,95)
student_kor <- c(100,95,95,80)
student_gender <- c('남','여','남','여')
student_data <- data.frame(student_id,student_name,student_eng,student_kor,student_gender)
student_data
# == 데이터 프레임. ==

#(2)데이터 프레임에 열 추가및 삭제.

student_data$mat <- c(100,100,99,98)
student_data
class(student_data$student_gender) #성별 타입 뽑아보기. 이렇게하면 지멋대로 바뀌기에 형변환 해줘야함.
student_data$student_id <- NULL #열 삭제.
student_data

# (3) 열의 형변환
student_data$student_gender <- as.factor(student_data$student_gender)
class(student_data$student_gender)
str(student_data) # str : 구조보기.
summary(student_data) # 통계요약.

#(4) 열 이름 변경.
student_data

#rename 을 쓰기전 reshape 안에있는 rename이라 패키지 다운을 먼저 해야함.
install.packages("reshape")
library("reshape")
#require("reshape") 라이브러리 를 하던 require 를 하던 똑같음.
student <- rename(student_data, c("student_name"="name"))
student <- rename(student, c("student_eng"="eng","student_kor"="kor","student_gender"="gender"))
student

names(student_data) <- c ('name','eng','kor','gender','mat') # 윗 방법과 이 방법이 있는데 이 방법이 많이쓰임.
student_data


#(5) 데이터 프레임 합치기
#행 단위로 합치기 rbind
newStudent <- rbind(student_data, student)
newStudent

#열 단위로 합치기 cbind
student
student_id
id = data.frame(student_id)
id
student <- cbind(id,student)
student
names(student) <- c ('id','name','eng','kor','gender','mat')
student

student

#부분 데이터 조회
student <- rbind(student, student) #2번 실행 -> 16행
student
nrow(student)
student[1,1] #1행1열.
student[1,'id'] # 1행 'id'열.
student[1,] # 1행 전체. 데이터만.
student[,1] #1열 전체 데이터만.
student[c(1:3),] # 1행부터 3행까지.
student[,c(2,3,4,6)] # 2,3,4,5,6 열의 데이터만.
student[c(-2, -4, -6),] #2,4,6 행외의 모든 데이터만.
student[,c(-1,-5)] #1열과 5열외의 모든 데이터터
student[c(1:3),c(-1,-5)] #1행부터 3행까지 에서 1열과 5열을 뺀 나머지 데이터.

#국어점수가 90점 이상인 데이터
help(subset)
subset(student, subset=(student$kor ==100))
subset(student, student$mat > 99) #subset= 생략가능.
subset(student, select = c(1,4)) #1열과 4열 데이터.
subset(student, select = c(-1,-4)) # 1열과 4열을 제외한 데이터.
subset(student, select = c('name','kor','mat')) # 'name','kor','mat'열 만.

#수학점수가 99점 이상인 여학생만 출력.
subset(student, subset = (student$mat >= 99 & student$gender == '여'))

#처음 5행만.
student[c(1:5),]
head(student)

#처음 3행만
head(student, 3)

edit(student)

emp <- read.csv(file.choose()) #탐색기에서 선택한 csv파일을 emp변수 할당.
emp
head(emp)
class(emp)

#1.직원 이름만 출력하기.
emp$ename
emp[,2]
emp[,2,drop=FALSE] #데이터프레임 형태로 반환.
emp[,'ename']
emp[,'ename',drop=FALSE]

#2. 직원이름,job ,sal 만 출력하기.
subset(emp, select = c('ename','job','sal'))
subset(emp, select = c(2,3,6))
emp[,c(2,3,6)]
emp[,c('ename','job','sal')]

#3. 이름이 KING 인 사원의 empno, job, hiredate, sal
subset(emp, subset=(ename == 'KING'), select = c('empno', 'job', 'hiredate', 'sal'))

#4. sal이 2000이상인 직원의 empno,ename,sal
subset(emp, subset= (emp$sal >= 2000), select= c ('empno','ename','sal'))


#5.sal이 2000부터 3000사이인 직원의 ename,sal
subset(emp, subset= (emp$sal >=2000 & emp$sal <= 3000), select=c ('ename','sal'))


#11. 타입 판별 및 타입 변환.
tail(emp,6)
tail(emp)
class(emp) #emp 전체 타입.이 무엇인지.
str(emp) #하나하나의 타입이 무엇인지.
emp$deptno <- as.factor(emp$deptno)
str(emp) # deptno 가 factor로 바뀐걸 볼수있다.

class(iris)
edit(iris)
str(iris) #다운받은 데이터는 factor로 안되어있다.
iris$Species <- as.character(iris$Species) #초반 데이터형태로 형변환.
str(iris) #이때의 Species는 factor 가 아니라 그룹핑을 안한다. 
iris$Species <- as.factor(iris$Species) #그룹핑을 하기위해 형변환.
str(iris) # Factor w/ 3 levels "setosa","versicolor",..: 1 1  leves의 종류중에 생략된것을 보고싶을때 아래처럼.
levels(iris$Species)

#타입 판별
class(iris$Species)
is.factor(iris$Species)
str(iris$Species)


#12. 문자열과 날짜

name <- "Eric"
length(name) #문자의 갯수가 아닌 요소의 갯수로 나옴.
nchar(name) #문자의 갯수.

names <- c('Eric','Larray','Curly')
nchar(names) # 각 이름의 문자 갯수.
length(names) #names 의 요소 갯수.

#하위 문자열 추출하기 : substr
?substr
substr('ABCDEF',1,4) #1~4번째 문자 추출
substr('ABCDEF',4,10) #1~10번째 문자 추출, 없는문자는 ""로 처리
substr(names, 1,2) #names 안에 각각의 문자 1~2번째 추출.

#names 안에 각각의 이름의 맨 마지막자리 앞 글자, 맨마지막글자.
#결과: "ic","ay","ly"
substr(names, nchar(names)-1, nchar(names))

#문자열 연결하기. : paste, paste0 (숫자0)
names <- c("Eric","Larray","Curly")
paste(names,'loves','starts', sep= '_') #사이사이에 _ 붙음.
paste(names,'loves','starts', sep= '_', collapse = ', and ')
paste0(names,'loves','starts') #딱 달라붙음.

#문제.
name <- c("Yun","Lim","Lee"); hobby <- c("swim","sleep","eat")
#결과 : Yun의 취미는 swim 이고 , Lim의 취미는 sleep, Lee의 취미는 eat.
cat(paste(name, hobby, sep = '의 취미는', collapse="이고,"))

#문자열 분할 (구분자 분할하기)
path <- 'hong/hadoop/data/spech.csv'
strsplit(path, '/')
customerInfo <- 'jin@naver.com,010-0000-0000,seoul Korea'
strsplit(customerInfo, ',010-0000-0000,')

customers <- c('jin@naver.com,010-0000-0000,seoul Korea', 'yun@naver.com,02-000-0000, pusan Korea'
               ,'su@naver.com,02-0000-0000, Inchon Korea')
strsplit(customers, '[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}')

#문자열 대체. : sub(oldstr, newstr, string) , gsub(oldstr, newstr, string)

s <- 'Curly is the smart one. Curly is fuuny, too.'
sub('Curly','Eric',s)
gsub('Curly','Eric',s)
gsub(' ','',s) #스페이스바 없애는.


#외적 : outer = 문자열의 모든 쌍별 조합 만듬.
a <- c ('aa','bb','cc')
b <- c ('11','22','33')
outer(a,b, FUN='paste')
outer(a,b, FUN='paste', sep=' ~ ')


#날짜
Sys.Date() #시스템으로부터 현재시간을 가져옴.
today = Sys.Date()
class(today)
#%Y :  년도 4자리 %y : 년도2자리. %m : 월 %d : 일.
thatday = as.Date("21-04-30",'%y-%m-%d')
thatday
today < thatday #연산 가능.

if(today < thatday){
  cat('today보다 thatday 후')
}


#실습예제.
# [1]
# 1) 행과 열에 대한 다양한 참조 방식을 사용하여 데이터를 조회.
# * iris 데이터의 차원확인, 
dim(iris)

#rm(list=ls()) 값을 실수로 넣을때 다시 저장되어 있는 변수 및 오브젝트 지우기

#컬럼이름 확인, 
colnames(iris)
names(iris)
#구조확인, 
str(iris)
#속성들.
colnames(iris)



# 2) 행과 열 정보를 조회.
# * iris 의 요약통계 정보
summary(iris)

# * 꽃받침의 길이 처음 10개 조회.
head(iris)
head(iris$Sepal.Length, 10)
iris[c (1:10),'Sepal.Length']
iris[c (1:10),'Sepal.Length', drop=FALSE] #데이터프레임 형식으로 출력.


# 3) 부분 데이터셋을 추출.
# * virginica종 만 추출.
levels(iris$Species)
virginica <- iris[iris$Species == 'virginica',]
virginica <- subset(iris, iris$Species == 'virginica')
virginica <- subset(iris, subset=(iris$Species == 'virginica'))
virginica <- subset(iris, subset=iris$Species == 'virginica')
head(virginica)

# * setosa종 만 추출.
setosa <- iris[iris$Species =='setosa',]
setosa <- subset(iris,iris$Species == 'setosa')
setosa <- subset(iris, subset = (iris$Species == 'setosa'))
setosa <- subset(iris, subset = iris$Species == 'setosa')
head(setosa)

# 4) 추출한 부분 데이터셋을 다시 결합.
rbind(virginica, setosa)

# [2] setOsa종 의 꽃받침(Sepal)의 폭과 길이 부분 데이터 셋을 추출.
subset(iris, subset = (iris$Species == 'setosa'), select = c('Sepal.Length','Sepal.Width'))

# [3] 작업내용에 따른 급여가 차등 지급.(행렬문제.)
# A작업은 시급 12000원, B작업은 시급 26000원, C작업은 시급 18000원 입니다.
# 두 사람이 각 작업을 수행하는 데 있어서 실제 작업한 시간이 작업 내역에 따라 다릅니다. 갑
# 은 A작업을 5시간, B작업을 4시간, C작업을 9시간
# 그리고 을은 A작업을 7시간, B작업을 3시간, C작업을 2시간 작업 했습니다.
# 갑과 을의 급여를 계산하세요.
pay <- matrix(c(12000,26000,18000), ncol=3)
pay
dimnames(pay) <- list(c('시급'),c('A작업','B작업','C작업'))
pay
work <- matrix(c(c(5,4,9),c(7,3,2)), ncol=2)
dimnames(work) <- list(c('A작업','B작업','C작업'),c('갑','을'))
work

salaray_cost <- pay %*% work
salaray_cost
rownames(salaray_cost) <- c('급여')
salaray_cost

# 힌트 : 행렬 두 개, 작업당 급여를 저장하는 행렬, 근무자들이 근무한시간
# 행렬의 곱은 %*% 를이용한다.
# 계산한 갑과 을의 급여는 각각 326000원, 198000원 입니다.