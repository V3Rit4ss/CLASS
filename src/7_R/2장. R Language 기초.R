
# # # 2장. R Language 기초 # # #

# 1.도움말 기능.
# 1.1 도움말
iris
edit(iris)
?iris # 도움말 출력
help(iris)

# 1.2 검색기능.
??iris
help.search('iris')

# 1.3 패키지 도움말
library(help="datasets")

#1.4 함수 도움말
methods(as) # 형변환 함수들.
as.integer(1.25)
?as.integer
example("as.integer") # 간단한 예제 출력하기.

data <- c(10,20,30)
mean(data) # 평균을 구하는 함수.
?mean
example(mean) # 열이름, 행이름, 타입.

# 6.주석과 자동완성
# = 주석
# 자동완성 : Tab
R.version  # 프로그램 정보.


 #1.5 정보 조회
edit(iris)
attributes(iris)
#열이름 : $names
#타입 : $class
#행 이름 : $row.names

##2. 패키지
# R 내에 기본패키지가 있다. 기본패키지 외의 패키지는 다운받을수 있다.
# 1. 패키지 설치.(기본패키지 외에 다른것을 받는것.)
  # 1. 패키지 설치. : install.package("패키지명")
  # 2.설치된 패키지를 메모리에 로드. : library("패키지명")
  # 3.패키지 내의 데이터나 함수들 막 사용.
  # 4. 패키지 언로드 : detach("package:패키지명", unload=TRUE)
detach("package:datasets", unload=TRUE)
iris
install.packages("arules")
library("arules")
?apriori
detach("package:arules", unload=TRUE)

#데이터의 경우는 메모리에 패키지 로드없이 사용가능.
iris <- data(list="iris",package="datasets")
data(iris, package = "datasets")
iris

#변수 다 삭제.
ls() #엘에스
rm(list=ls())

##3. 변수
# 변수 : 들어갈수있는 특수문자 _, . 사용가능.
# 할당 : <-, <<- 
result <- 0 # 전역 변수 result 
class(result) #타입을 알고싶을때.
# typeof(result) 잘 안나옴.
add <- function(a,b){
#  result <- a+b # 지역변수가 댐. 이공간안에서만 쓰임.
  result <<- a+b #전역변수에 할당.
  return(result)
}

add(10, 20)
result

#변수 목록 조회
ls()

x<-10
y<-10
(z<-x+y)
ls() #변수들 출력. (시스템 히든 변수는 제외)
?ls
ls(all.names = TRUE) #히든변수도 포함. 히든변수란? ".random.seed" . 이있으면 히든변수
# 보이지가 않는 히든변수이다.

#4. 출력
result
print(result) #[1] 인덱스라 보면 된다. R은 인덱스가 1부터 시작.
(z <- z+10) # 값을 추가하고 바로 출력 하고싶을때.(이안에 변수를 넣는다.)

paste('Hello','world') #hellp world
paste('result 값은',result)
#print('result 값은',+result); #앞의 타입은 스트링 . 뒤의 타입은 스트링x 따라서 에러뜸.

paste('Hello','world',sep=',') #sep 디폴트값은 두개의 값 사이에 [ , ]추가
1:3 # 1~3 까지.
paste(c(1,2,3),c('하나','둘','셋'), sep='은') 
paste(c(1,2,3),c('하나','둘','셋'), sep='은', collapse=' / ')

month.name
(nth<-paste(1:12, c('st','nd','rd',rep('th',9) ),sep=''))
paste(month.name, nth, sep='은 ',collapse=" ; ")

#5. 변수 삭제
rm(z) # z변수 한개 삭제.
rm(list=ls()) #히든변수 외 일반변수 삭제.
# rm(list=ls(all.names = TRUE)) 히든변수 까지 삭제가능하나. 이렇게 안하고
# 오른쪽 상단의 빗자루를 클릭하면 다 삭제된다.

#6.
# ~.R : R 스크립트 파일(R실행 코드 저장.)
# ~.RData : R작업공간
# ~.Rhistory : 콘솔창에 실행한 R 명령어들의 history 저장.

# 문제1. kor 에 '한국','일본','미국'
#       use 에 'Korea','Japen','America'
# 출력은 한국:Korea, 일본:Japen, 미국:America
#         "한국:Korea" "일본:Japen" "미국:America"

kor <- c('한국','일본','미국') #동질자료형
usa <- c('Korea','Japen','America')
(str <- paste(kor,usa, sep=':', collapse = ', '))
(strVector <- paste(kor,usa,sep=':'))

# 문제2. MASS::Cars93 데이터들 출력해 보세요.
#패키지는 대소문자 구분함. 오로지 대문자만, 패키지.
# MASS 가 없는상태라 받고 시작해야함.

Cars93 # 안되면 , 패키지 로드하기.
library(MASS) # 안되면, 패키지 설치하기.
install.packages("MASS")
library(MASS)
Cars93
edit(Cars93)
head(Cars93) #1~5행 까지만 봄.
