# # # 4장. R 프로그래밍 : 제어문, 연산자 ,function # # #

# 1.제어문
# 1.1 조건문
# (1) if문
num <- 9
if(num%%2 == 0){ # 나머지 = %%
  cat(num, '은 짝수')
} else {
  cat(num, '은 홀수')  #print (paste(num, '은 짝수')) 로 해줘야하고 
}  # cat 은 '' "" 생략해서 출력해준다.


# (2) ifelse() 함수.  (3항연산자.)
#"num %2 ==0" "짝":"홀"
ifelse(num%%2==0, "짝","홀")

(nums <- c(10,9,16,17,20))
ifelse(nums%%2==0, "짝","홀")
result <- ifelse(nums%%2==0, "짝","홀")

m <- matrix(c(nums,result),ncol=5, byrow = TRUE, dimnames = list(c('수','홀짝'), c('1회','2회','3회','4회','5회')))
m


# (3) switch() 함수
switch(2, "red","green","blue") # green 으로 리턴값 받음.
x <- switch (4,"red","green","blue") # 리턴값이 없어서 NULL
x

#사용자로부터 color값을 받아 해당 color 를 출력.
?readline
?as.integer
colorValue <- as.integer(readline(prompt = "컬러값은? (red:1, green:2, blue:3)")) 
colorValue #스트링이 들어가있음.
class(colorValue)
color <- switch (colorValue, "red","green","blue")
color

color <- readline(prompt = "컬러는 (red,green,blue)")#콘솔창에서 한줄만 받는.
color
colorValue <- switch(color, "red"=1, "green"=2, "blue"=3)
cat('선택한 색상',color,'의 색상값은',colorValue)


#문제. 점수(50~100)를 입력 받아서 학점을 계산하는 프로그램 구현.
#100 = perfect,  90=A , 80=B, 70=C, 60=D, 50=F

jumsu <- as.integer(readline(prompt = "학점은?(50~100)"))
jumsu

grade <- switch ((as.integer(jumsu/10)-4),"perfect","A","B","C","D","E")
grade

getgrade <- function(){
  jumsu <- as.integer(readline(prompt = "학점은?(50~100)"))
  grade <- switch ((as.integer(jumsu/10)-4),"perfect","A","B","C","D","E")
  cat('입력한 점수는',jumsu,', 학점은',grade)
}
getgrade()


#1.2 반복문 : for, while, repeat
#(1) for문 = for-in 문 과 비슷하다.
#-----
1:10
seq(1,10)
seq(10)
#----벡터.

x <- c(-2,5,4,8)
for(val in x) {
  cat(val,'\t')  
}
count <-0
for(val in x) {
  if(val%%2==0){
    count = count+1;
  }
}
count

#10회 반복.
for(val in 1:10){
  cat(val, '안녕하세요')
}

#문제.. factorial 계산 함수를 작성.
# fact(3) #결과 : 3! = 6
# fact(-3) # 결과: 음수값을 위한 팩토리얼은 존재하지 않는다.
# fact(0) #결과: 0! = 1

fact <- function(num){
  result = 1
  if(num<0){
    cat('음수값을 위한 팩토리얼은 존재하지 않습니다.')
  }else if(num==0){
    cat('0!=1')
    #return(1)
  }else {
    for(i in num:1){
      result = result * i
    }
    cat(num,'! = ',result)
    #return(result)
  }
}
fact(4)
fact(0)
fact(100)


rm(list=ls()) #지움.
fact(4) #그래서 안댐.
#다른 파일의 패키지 사용할수있게 하는.
source('fact.R',encoding = 'utf-8')

getwd() #현재의 working 디렉토리.
setwd("E:/WDS/BigDataUI/data/src/07.R") #다른 경로의 디렉토리를 현 디렉토리로.
getwd() # 바뀌었는지 확인.



# (2) while문. = 조건이 참이면 반복.
i <- 1
while(i<6){
  print(i)
  i= i+1
}


# (4) repeat : 반복
i <- 1
repeat{
  if(i>6)
    break;
  print(i)
  i <- i +1
}


#(3) break, next(자바에서의 continue)
x <- 1
while(x<10){
  if(x==3)
    
    break;
  cat(x,'\t')
  x<- x+1
}

x <-1
while(x<10){
  x<- x+1
  #if(x==3) break;
  if(x==3) next;
  cat(x,'\t')
  
}



#2. 연산자.
x <- 1 #왼쪽으로 
1 -> x #오른쪽으로. 이 방법은 잘 안쓰임.

# 1.1논리 연산자. &, && , | , ||
TRUE & TRUE
TRUE && TRUE
#하나일때는 위의 상황 둘다 같다.

x <- c(T,T,F,F)
y <- c(T,F,T,F) #1번은 1번끼리 비교.

x & y # 모든요소를 싹다 체크함.
x && y #첫번째 요소만 체크함.

x | y # 모든요소를 싹다 체크함.
x || y #첫번째 요소만 체크함.



# 1.2 중위 연산자. 
5 + 8
'+'(5,8) #위아래 같음.

'%add%' <- function(x,y){
  return (x+y)
} #%add% 연산자를 만듬.


'%add%'(3,9)
70 %add% 900
#내가 만든 연산자.

c <- c(10,23,30)
10 %in% c # 10이 c 안에 있느냐?
strings <- c('Hello','world','R')
strings %in% 'R' #하나하나 계산하는.

# %o% : 외적.  %*% : 내적.(행렬의 곱)

# 내적.
a <- c(2,3,4)
b <- c(10,20,30)
a %o% b


#외적 : outer = 문자열의 모든 쌍별 조합 만듬.
a <-c('1','2','3')
b <-c('a','b','c')
outer(a,b,FUN=paste)


a <- c ('aa','bb','cc')
b <- c ('11','22','33')
outer(a,b, FUN='paste')
outer(a,b, FUN='paste', sep=' ~ ')


matrix.a <- matrix(1:6, nrow = 3, ncol=2)
(matrix.a <- matrix(1:6, nrow = 3, ncol=2))
(matrix.b <- matrix(1:6, nrow = 3, ncol=2))
matrix.a %*% matrix.b #불가.

solve(matrix.a) #'a'은 반드시 3 행 2열의 정방행렬이어야 합니다



#3. 함수 #function 은 return.이 필요함.
pow <- function(x,y){  #선언한 x,y 갯수에 맞춰야함.
  return(x^y); #두가지 이상의 값을 리턴 못함.
  
}
pow
pow(2,4)



# 가변인자 함수 total()  total(1)  total(2,3,4)
total <- function(...){ #... 세개를 넣어야함. 그래야 가변인자가 싹 들어감.
  args <- list(...)
  sum <- 0
  for(val in args){
    sum <- sum+val
    cat(val,'의 합은 ', sum, '\n' )  #보고싶으면 이렇게.
  }
  return(sum)
}
total()
total(3)
total(10,2,3,6)


# 재귀호출. : 함수내에서 자기함수를 호출하는 함수
rm(list = ls())
fact <- function(num){
  if(num<0){
    return()
  }else if(num==1){
    return(1)
  }else{
    return(num * fact(num-1))
  }
  
}
fact(3)
# fact(3) -> 6(3!)을 리턴하는 걸 만들꺼임.
# fact(3) = 3 * fact(2)
      #  = 3 * 2 * fact(1)
      # = 3 * 2 * 1
#fact(num) = num * fact(num-1) (단, num이 1보다 클 때, fact(1)=1 ) 




# 4. R환경
?environment
environment() #<environment: R_GlobalEnv> 환경이름.
ls()
f <- function(f_x){ 
  g <-function(g_x){
    print('g함수 안')
    print(environment())  
    print(paste('g함수 영역에서의 변수들',ls()))
  }
  g(5)
  print('f 함수 안')
  print(environment())
  print(paste('f함수 영역에서의 변수들',ls()))
  #cat('f함수 영역에서의 변수들',ls())
}

f(10)  
  


# 문제.

is.prime <- function(num){
  flag = FALSE
  if(num == 2) {
    return(TRUE)
  }else if(num>1){
    flag = TRUE
    for(i in 2:(num-1)){
      if((num%%i)==0){
        #cat(i,'는',num,'의 약수라서 소수 아니야','\n')
        flag = FALSE
        break;
      }
    }
  }
  return(flag)
}
is.prime(6)












