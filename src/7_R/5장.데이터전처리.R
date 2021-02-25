# # # 5장 . 데이터 전처리 # # #

# 1. 파일 입출력

#1.1 시스템 인코딩 조회
Sys.getlocale() #윈도우 운영체제면 cp949 . 다른운영체제는 다를수있음.

#1.2 write.table = 데이터를 파일에 저장.
iris
class(iris)
write.table(iris, file='outData/iris.csv',sep=',')
write.table(iris, file='outData/iris.csv',sep=',',row.names = FALSE) #,row.names = FALSE) 로우넘버 빼고.
head(iris)
InsectSprays
str(InsectSprays)
write.table(InsectSprays, file='outData/Insect.csv',sep=',') #',' , 하나만. 주의

#1.3 read.table = 파일을 읽어 데이터프레임 형태로 저장. #encoding = 'uft-8' 한글이 없으니 안써도 상관x , fileEncoding ='cp949' 도 상관 x
irisData <- read.table('outData/iris.csv',sep=',',header = TRUE, encoding = 'uft-8')#, stringsAsFactors = TRUE) # header = TRUE 맨 상단의 값은 header다.
# stringsAsFactors = TRUE 스트링도 팩터로. 하지만 스트링전체가 다 바뀌어서 조심. iris 의 스트링은 Species 만 있으니 괜찮음.
head(irisData)
tail(irisData)
str(irisData)
irisData$Species <- as.factor(irisData$Species)
irisData$Species <- factor(irisData$Species,levels = c('setosa','versicolor','virginina'))
iris$Species
str(iris$Species) #factor로 바뀌어있나 확인.
nrow(iris)
summary(iris)



#1.4 write.csv
write.csv(iris, file = 'outData/iris1.csv')
write.csv(iris, file = 'outData/iris1.csv', quote = FALSE) #"" 때고싶으면. 메모장으로 볼때. "" 붙음


#1.5 write.csv
newData <- read.csv('outData/iris1.csv', header = TRUE, stringsAsFactors = T) #sep = 만 안쓰고 위에서 한 irisData <- read.table ~~  나머지는 같다.
str(newData)   # , stringsAsFactors = T => Species 만 chr 인 스트링이라 이렇게 해도 댐. 
head(newData)
summary(newData)


#1.6 cat : 분석 결과 등을 저장할때.
irisSummary <- summary(newData)
class(irisSummary)
irisSummary[1,]

nrow(irisSummary) #6행이 있다.
cat('iris 요약 : ', '\n', file='outData/irisSummary.txt', Encoding='utf-8') #이거부터 실행.

for(i in 1:nrow(irisSummary)){ #6 = nrow(irisSummary) 이니까 6대신 넣음.
  cat(irisSummary[i,],'\n',file='outData/irisSummary.txt', append = T ) #영어만 있으면 인코딩 utf 뺀다.
} 

#cat('iris 요약 : ', '\n', irisSummary, file='outData/irisSummary.txt', append = TRUE, Encoding='utf-8')


#2. apply 계열 함수 적용.

# 2.1 apply : 
#iris 데이터의 열별 평균, 행별 평균. (합계, 분산, 표준편차, 최소값, 최대값,중앙값)
#apply(대상자료, 1또는2, 함수) 1은 행별 함수 수행, 2는 열별 함수 수행.
head(iris[,1:4])
head(iris[,-5])
apply(iris[,1:4], 1, mean) # 행별 평균.
apply(iris[,-5], 2, mean) # 열별 평균.

#setosa종 과 versicolor 종과 virginica 종을 분류 하고 각각의 열별 평균 구하기.
setosa <- subset(iris, iris$Species == 'setosa')
head(setosa)

versicolor <- subset(iris, subset = (iris$Species == 'versicolor'))
head(versicolor)

virginica <- subset(iris, subset = iris$Species == 'virginica')
head(virginica)
     
apply(subset(iris, iris$Species=='setosa', select = -5),2, mean)
apply(subset(iris, iris$Species=='versicolor', select = -5),2, mean)
apply(subset(iris, iris$Species=='virginica', select = -5),2, mean)

#6개 함수.
apply(iris[,1:4],2, FUN=mean) #열별 평균
apply(iris[,1:4],2, FUN=sd) #열별 표준편차
apply(iris[,1:4],2, FUN=sum) #열별 합계
apply(iris[,1:4],2, FUN=median) #열별 중앙값
apply(iris[,1:4],2, FUN=min) #열별 최솟값
apply(iris[,1:4],2, FUN=max) #열별 최댓값

# == 벡터같은 행렬 스타일로 나온다.


#InsectSprays 에서 count 의 표준편차
sd(InsectSprays$count)
#iris 에서는 4개의 열이 있어서 불가.


name <- c('김','홍','최','이','박')
kor <- c(80,99,55,60,10)
eng <- c(20,85,30,68,12)
mat <- c(70,65,80,60,80)
student <- data.frame(name,kor,eng,mat)
student

#학생별 평균 , 과목별 평균

apply(student[,-1], 1, mean) #학생별 평균.
student[,-1]
apply(student[,-1], 2, mean) # 과목별 평균.


#2.2 lapply : list apply(결과도 list)
x <- list(a=1:10, beta=exp(-3:3), logic= c(T,F,F,T)) #항목별 평균 할때
x

exp(-3:3) #e의-3승 부터 e의3승 까지 출력되는 지수함수.

lapply(x, mean)
lapply(x, quantile) # 분위수.
lapply(x, quantile, 1:3/4)


#2.3 sapply : lapply 와 유사하나 결과가 행렬이나 벡터로 반환.
sapply(x, mean)
sapply(x, quantile)
sapply(x, quantile, 1:3/4)


fivenum(0:10) #최솟값0 최댓값10 을 넣음. 그걸 5개구간으로 나눠서 출력함.
i39 <- sapply(c(3:9), seq)
i39

sapply(i39, fivenum)
lapply(i39, fivenum)

# 문제. iris데이터를 lapply 와 sapply 를 이용하여 Sepal.Length~ Petal.width까지의 평균을 구하라.
irisList <- as.list(iris[,1:4])
irisList

lapply(irisList, mean)
sapply(irisList, mean)



# 2.4 vapply : sapply 와 같지만, = FUN의 모든 값이 특별 VALUE타입과 호환되는지 확인
vapply(irisList, mean, FUN.VALUE=numeric(1))
vapply(i39, fivenum, FUN.VALUE=c(numeric(1), numeric(1),numeric(1),numeric(1),numeric(1)))

citis <- c('Seoul','Busan','New York','Tokyo')
citis
nchar(citis[1])
sapply(citis, nchar)
lapply(citis, nchar)
vapply(citis, nchar, FUN.VALUE = numeric(1))



#2.5 mapply : apply 와 같으나 여러개의 인자를 함수에 전달.

rep(c(1,2,3),3) #반복.
rep(c(1,2,3),each=2,times=3) #each=, times= 생략 가능.
x <- c(1,2,3,4)
mean(x)

mapply(rep, x=1:4, times=4:1) #rep(1,times=4) rep(2,times=3) rep(3,times=2) rep(4,times=1)
mapply(rep, x=1:4, each=4:1)



#직업별 수입. # 0은 결측치라 대치값을 줄것임.
job <- c(3,3,5,2,2,3,5,3,4,4,6,3)
income <- c(4879,6509,4183,0,3894,0,3611,6454,4975,8780,0,4362)
cust <-data.frame(job,income)
cust

income.avg <- c(900,0,3500,3600,3700,3800,3900,4000)
income.avg
names(income.avg) <- 0:7
income.avg
income.avg[2] #하나 추출하고싶을때

zero2mean <- function(job,income){
 # return(ifelse(income==0,income.ang[as.character(job)],income))  밑에 많이 칠거를 3항연산자로 할수있다.
  if(income==0){
    return(income.avg[as.character(job)])
  }else {
    return(income)
  }
}
# for문으로 zero2mean(cust[1,'job'],cust[1,'income']) 을 하지않고 . 밑에 mapply 를 하면 된다.
#income2 필드를 만들어서. 결측치 대치함.
cust$income2 <- mapply(zero2mean, cust$job,cust$income)
cust




# 3.데이터 그룹화 함수 적용
#3.1 tapply: 그룹화 처리를 위한 apply
tapply(iris$Sepal.Length,iris$Species, mean) #팩터변수가 들어가야한다. mean 자리엔 6개 함수 들어감.
tapply(iris$Sepal.Length,iris$Species,sd) #표준편차.
boxplot(iris$Sepal.Length~iris$Species) #오른쪽 화면이 작아서 Error in plot.new() : figure margins too large 뜸.


#직업군별 평균 income을 출력.
cust

str(cust) #job이 factor 가 아니라 형변환해줘야한다.
cust$job <- as.factor(cust$job)
cust$job <-factor(cust$job, levels = 0:7)
tapply(cust$income2,cust$job, FUN=mean) #없는 그룹은 NA. 을 다른걸로 하고싶으면
tapply(cust$income2,cust$job, FUN=mean, default = -1) #default값은 NA 대체값.

datasets::InsectSprays
InsectSprays
head(InsectSprays) #앞에있는 5개만.
str(InsectSprays)
#spray의 종류에 따른 살충효과를 점검해보세요.
tapply(InsectSprays$count, InsectSprays$spray, mean)
tapply(InsectSprays$count, InsectSprays$spray, sd)
nrow(InsectSprays)
boxplot(InsectSprays$count~ InsectSprays$spray)

tapply(InsectSprays$count, InsectSprays$spray, FUN=c(mean,sd))#불가.
#tapply 단점.필드와 함수를 하나씩 밖에 못쓴다. => 보완 : summaryby

#3.2 by : 그룹화 처리를 위한 apply(다수의 필드를 사용가능하게 할 수 있다.)
#tapply(iris[,1:2](필드 2개인 상태.), iris[,5], mean)# 단점.
#by(InsectSprays$count, InsectSprays$spray, FUN=c(mean,sd)) 불가.
by(iris[,1:2], iris[,5], sum) #mean, sd 불가.
by(iris[,1:4], iris$Species, summary)
# cust 직업별 평균을 income, income2 를 한번에 하자.
by(cust[,c('income','income2')], cust[,'job'], summary)
#by (~~, summary)는 mean 대신 평균을 보여준다. (리스트 형식.)


## 데이터 프레임을 쓴다 하는 전제하에 사용함.##

#3.3 do by 패키지
# (1) summaryBy()
install.packages("doBy")
library("doBy") #"(doby)"따옴표 생략 가능.
summaryBy(Sepal.Length+Sepal.Width ~ Species, iris) # 함수명은 default mean
summaryBy(Sepal.Length+Sepal.Width+Petal.Length+Petal.Width ~ Species, iris, FUN=sd)
summaryBy(Sepal.Length+Sepal.Width+Petal.Length+Petal.Width ~ Species, iris, FUN=c(mean,sd))

#문. emp.csv파일의 데이터를 받아 부서별 급여, 상여금을 비교.
emp <- read.csv('Data/emp.csv',header = T, stringsAsFactors = F)
emp
str(emp$deptno)
emp$deptno <-as.factor(emp$deptno)
emp$deptno <- factor(emp$deptno, levels = seq(10,40,10))
names(emp)
summaryBy(sal+comm ~ deptno, emp, na.rm=T) #na.rm=T 결측치 빼고 평균 계산. 
#mean 말고 다른거 쓸려면 FUN= 다른함수.

# (2) orderBy : 정렬.
orderBy(~Sepal.Length, data = iris)#오름차순.  # ~Sepal.Length 기준하는곳. 
orderBy(~-Sepal.Length, data = iris) #내림차순.
orderBy(~Species+Sepal.Length, data = iris) # + Species, Sepal.Length 오름차순.
orderBy(~Species-Sepal.Length, data = iris) # - 내림차순.

#종별 , Sepal.Length 오름차순으로 정렬한 데이터를 Sepal.Length,Sepal.Width,Species 정렬.

orderBy(~Species+Sepal.Length, data = iris)[,c(1,2,5)]
orderBy(~Species+Sepal.Length, data = iris)[,c(-3,-4)] #둘다 같고 subset 을 이용해도 댐. 가능한 경우의수가 많음.


#Q1 emp 데이터셋에서. 월급이 적은순으로 ename, sal을 추출
orderBy(~sal, data = emp)[,c(2,6)]
#orderBy(~sal, data = emp)[,c('ename','sal')] 위아래 같은 결과임.

#Q2 월급이 적은 순 5명만 ename, sal
head(orderBy(~sal, data = emp)[,c('ename','sal')])



# (3) sampleBy
sampleBy(~Species, data = iris, frac = 0.2) #종별로.(group별) 20%씩. 표본추출(비복원 추출) #랜덤으로 임의추출.
# 그래서 실행할때마다 다름. 대부분 비복원 추출을 많이 이용한다.
sampleBy(~Species, data = iris, frac = 0.2, replace = T) #복원 추출. #실행할때 그 추출된것만 계속나옴.

sampleBy(~Species, data = iris, frac = 0.1, systematic = T) #계층적 추출.



#벡터 샘플링.
idx <- sample(1:150,10) #1~150개중에 10개 뽑음.
idx #idx <- sample(1:150,30) ;70) 30개 70개 씩 뽑아서 할수도있음.
iris[idx,] #임의로. 전체에서 10개 뽑기.

#4. formula (포뮬러) : ~ +
 ## lm() 선형회귀식 도출 함수.(독립변수,종속변수 : 명명식과 순서식이 아닌것들만.)
   ### 연속적 변수에서 사용.
x <- c(1,2,3,4,5) #공부량 (독립변수)
y <- c(20,41,59,81,99) # 정수 (종속변수) - 회귀분석 : lm()함수이용.
y1 <- c('F','F','F','P','P') # 당락여부(종속변수) - 로지스틱 회귀. glm()함수 이용. # 'F'스트링형 <=> F 둘다 해도댐. 

x <- c(2,4)
y <- c(40,60)

fit <- lm(y ~ x)  #matrix 사용안하면 lm() 으로.
fit
plot(x, y, col='blue')
lines(x, x*19.8+0.6, col='red') #x축 가지고 나타낸 예측치.
abline(fit, lty='dashed') #점선. 실제값.


#독립변수가 2개 
x1 <- c(1,2,3,4,5) #공부량.
x2 <- c(10,20,3,4,5) #기출문제 푼 갯수
y <- c(50,70,63,84,95) #종속변수.

fit <- lm(y ~ x1+x2) #x2를 추가하겠다. x1과x2의 상관관계가 없다라는 전제하에 써야함.
fit
#plot 3차원 도표는 불가.


#cars 
cars
?cars #datasets 에 있음.
#속도에 따른 제동거리의 관계를 회귀식으로 도출.

plot(cars$speed, cars$dist, col='purple')
# plot(cars) 데이터값이 두개뿐이라 이렇게 해도 가능.

fit <- lm(cars$dist ~ cars$speed) #이것보다 밑에있는 경우를 많이쓴다.
fit <- lm(dist ~ speed, data=cars)
fit

lines(cars$speed, cars$speed*3.932-17.579, col="red")
abline(fit, lty='dotted')




#5. 데이터 분리
#5.1 split.
iris.species <- split(iris, iris$Species) #list 형태로 .
iris.species
iris.species['virginica'] #하나만 출력.

iris.sepal <- split(iris, iris$Sepal.Length>5)
iris.sepal #TRUE 결과와 FALSE 결과 두개가 나온다.
iris.sepal['FALSE'] #FALSE 결과만 출력.
iris.sepal$FALSE
head(iris.sepal$'FALSE')

#5.2 subset
#문. setosa 종 중 Sepal.Length, Petal.Length 열 출력.
names(iris)
subset(iris, subset = (iris$Species == 'setosa'), select = c('Sepal.Length','Petal.Length')) #or c(1,3)


#문. setosa 종 중 Sepal.Length, Sepal.Width,Petal.Length,Petal.Width 열 출력.
subset(iris, subset = (iris$Species == 'setosa'), select = c('Sepal.Length','Sepal.Width','Petal.Length'))
subset(iris, subset = (iris$Species == 'setosa'), select = c(1:4))
subset(iris, subset = (iris$Species == 'setosa'), select = c(-5))
subset(iris, subset = (iris$Species == 'setosa'), select = -c(5))
subset(iris, subset = (iris$Species == 'setosa'), select = -5)

#나열한 subset 모두 가능.
#문. setosa 중 Sepal.Length가 4이상인 데이터.
subset(iris, subset = (iris$Species == 'setosa' & Sepal.Length>=4 ))
#조건이 두개이상이면 ' & ' 위에 처럼.

##subset 이 이렇게나 자주 사용하면 그만큼 중요하다는것임.


#6. 데이터 합치기. 

# 컬럼 합치기 cbind()
# 행 합치기   rbind()
#   병합      merge()

#6.1 cbind()
student.a <- data.frame(name=c('yi','kim'), score=c(100,90))
student.a
student.b <- data.frame(id=c(100,101), gender=c('여','남'))
student.b
(student <- cbind(student.a, student.b)) #열 합치기

#6.2 rbind()
student.a <- data.frame(name=c('yi','kim'), score=c(100,90))
student.b <- data.frame(name=c('park','choi'), score=c(75,86))
(student <- rbind(student.a, student.b))


#6.3 merge()
student.a <- data.frame(name=c('yi','kim'), kor=c(70,80))
student.b <- data.frame(name=c('yi','kim'), eng=c(60,77), mat=c(70,80))
(student <- merge(student.a, student.b)) #name 데이터가 똑같기에 무리없이 적용완료.

#name 이라는 데이터가 서로 다를때.
student.a <- data.frame(name=c('yun','kim'), kor=c(70,80))
student.b <- data.frame(name=c('yi','kim'), eng=c(60,77), mat=c(70,80))
(student <- merge(student.a, student.b, all=T)) #name= yi -> yun 으로 했을때 데이터손실이 됨.
# 따라서 all=T 로 NA값이 들어가고 이 값을 대치값으로 다시 변환하던지 하면 된다.


#7. 데이터 정렬.
#sort() : 정렬된 데이터 반환 / order() : 정렬된 데이터의 index 반환.
data <- c(10,30,100,1,3)
sort(data)
sort(iris$Sepal.Length) #오름차순.
sort(iris$Sepal.Length, decreasing = TRUE) #내림차순.

#order()
data <- c(10,30,100,1,3)
names(data) <- c('1번째','2번째','3번째','4번째','5번째')
data
sort(data)
order(data) #정렬된 데이터의 index값인 색인이 나온다.
data[order(data)] #sort(data) 와 같은 결과로 나온다.


#iris 데이터를 Sepal.Length를 기준으로 내림차순 정렬.
sort(iris$Sepal.Length, decreasing = T) #14번째 값이 제일작다.
order(iris$Sepal.Length, decreasing = TRUE) #4.3 
iris[order(iris$Sepal.Length, decreasing = TRUE), ] #', ' 1번째방부터 끝방까지.


#iris 데이터를 Sepal.Length(내림차순으로), Sepal.Width(오름차순으로.) 특정열 출력.
order(-iris$Sepal.Length, iris$Sepal.Width)
iris[order(-iris$Sepal.Length, iris$Sepal.Width), ]
iris[order(-iris$Sepal.Length, iris$Sepal.Width),1:4] #특정열 출력.
iris[order(-iris$Sepal.Length, iris$Sepal.Width), c(1,2,5)] #특정열 출력.


#emp 데이터셋에서 월급이 많은 순으로 ename, sal 을 추출.
emp[order(-emp$sal), c(2,6)]
# emp[order(-emp$sal), c('ename','sal')] 위아래

#emp 데이터셋에서 월급이 많은 top 5 의 ename, sal 을 추출.
head(emp[order(-emp$sal), c('ename','sal')], 5) #, 5 로 갯수 5개로 .

# emp[order(-emp$sal), c('ename','sal')][1:5,] head로 ..

#emp 데이터셋에서 월급이 적은 top 5 의 ename, sal 을 추출.
tail(emp[order(-emp$sal), c(2,6)], 5) #, 5 로 갯수 5개로 . ,숫자 의 따라 추출되는 갯수가 달라진다.
emp[order(-emp$sal), c('ename','sal')][nrow(emp)-5:nrow(emp),]
# R 에서는 head,tail 6개. 파이썬에서는 5개.



#8. 데이터프레임 이름 생략하기.
#8.1 with절, within절

iris.temp <- iris
iris.temp[c(1,3),1] <-NA #일부로 NA를 넣어서 NA가 있다고 가정을 만듬.
head(iris.temp,3)

#종별 중앙값. with 절 사용전.
split(iris.temp$Sepal.Length,iris.temp$Species) #결과는 list.
mps <- sapply(split(iris.temp$Sepal.Length,iris.temp$Species), median, na.rm=T)
mps


(mps <- tapply(iris.temp$Sepal.Length, iris.temp$Species, median, na.rm=T))
mps['setosa']
iris.temp$Sepal.Length2 <- ifelse(is.na(iris.temp$Sepal.Length), mps[iris.temp$Species], iris.temp$Sepal.Length)

head(iris.temp[,c('Sepal.Length','Sepal.Length2')]) #Length2 의 NA 값이 대체되었다.


iris.temp$Sepal.Length2 <- NULL # Length2의 데이터 삭제.
head(iris.temp) # 사라졌는지 확인.

# with절, within절 적용.
#with 절은 Sepal.Length의 결측치가 대치된 결과값을 반환
iris.temp <- with(iris.temp,{
  mps <- tapply(Sepal.Length, Species, median, na.rm=T)
  Sepal.Length <- ifelse(is.na(Sepal.Length), mps[Species], Sepal.Length)  
})
iris.temp

#within 절은 Sepal.Length의 결측치가 대치된 데이터프레임 셋이 반환.
iris.temp <- within(iris.temp,{
  mps <- tapply(Sepal.Length, Species, median, na.rm=T)
  Sepal.Length <- ifelse(is.na(Sepal.Length), mps[Species], Sepal.Length)  
})
head(iris.temp)



#8.2 attach()함수 , detach()함수
attach(iris) # 이 부분 아래는 iris$ 생략 가능.
summary(Species) 
Sepal.Length
tapply(Petal.Length, Species, mean)
detach(iris) # attach() 기능 해제.



#9. 데이터 집계
#9.1 table
table(iris$Species)
table(emp$ename) #factor 변수가 아니면 집계가 무의미.

head(InsectSprays)
#InsectSprays 데이터 셋에서 spray별 집계.
table(InsectSprays$spray)
#emp 데이터 셋에서 deptno별 집계.
str(emp$deptno)
emp$deptno <- factor(emp$deptno, levels = seq(10,40,10))
table(emp$deptno)



#9.2 aggregate : 데이터를 하위집합으로 분할하고 요약 통계 계산.
aggregate(iris[,1:4], by=list(iris[,5]), mean)



#보험회사의 고객들이 보험들을 청구하는 데이터에서 고객별 입원일을 조회.
cust_id <- c(1005,1002,1003,1004,1005,1001,1005,1002,1003,1005)
hos_day <- c(2,3,20,5,13,0,8,2,3,16)
length(cust_id)
length(hos_day)
#둘다 같은 10개로 들어갔는지 확인.

data <- data.frame(cust_id, hos_day)
day_per_cust <- aggregate(data$hos_day, by=list(data$cust_id), sum) #id 당 총 입원일.
day_per_cust
names(day_per_cust) <- c('cust_id','hos_day')
day_per_cust
day_per_cust[order(day_per_cust$hos_day),]
day_per_cust[order(-day_per_cust$hos_day),]


#아래가 다 같은 결과
aggregate(data$hos_day, by=list(data$cust_id), sum) # 대상 열이 하나 이상도 가능. FUN=은 하나만.
tapply(data$hos_day, data$cust_id, sum) #대상 열이 하나만 가능.

summaryBy(hos_day ~ cust_id, data = data, FUN=c(sum,mean)) #FUN= 안에 두개이상 가능.



#10. 조건으로 색인 찾기. : which()
subset(iris, iris$Species=='setosa') #조건으로 데이터를 추출한 방법.

which(iris$Species=='setosa') #조건으로 색인 추출출
iris[which(iris$Species=='setosa'),] #조건을 이용하여 데이터 출력.

which.max(iris$Sepal.Length)
iris[which.max(iris$Sepal.Length), ] #Sepal.Length가 제일 큰 row를 출력.










