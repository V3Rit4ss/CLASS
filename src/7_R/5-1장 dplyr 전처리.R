# # # 5-1. dplyr 패키지를 이용한 전처리 # # #
#1. 외부파일 read or write

#1.1 엑셀 파일 읽어오기. readxl 패키지 이용.  xls 구버전. xlsx 최신버전.
library(readxl)
require(readxl) #둘다 같은기능.

install.packages("readxl")

library("readxl")
getwd()
##
exam <- read_excel("Data/exam.xlsx") #절대경로를 가져와도 댐. 경로에서 \ 불가, \\ 가능. or /.
class(exam) #데이터프레임이면서 테이블형식이기도 한다.
exam <- as.data.frame(exam) #데이터프레임 형태로 완전히 바꾸면 table 성격이 사라진다.
head(exam)
nrow(exam)
exam[21,] <- data.frame(id=(1), class=1, math=90, english=90, science=99)
tail(exam)
exam$tot <- exam$math + exam$english + exam$science #파생변수를 추가함.
mean(exam$tot)
exam$grade <- ifelse(exam$tot>mean(exam$tot), '상','하') #파생변수를 상, 하 로 나눔.
apply(exam[,3:6], 2, mean)

#데이터 파일에 컬럼명이 없는 경우.
data <- read_excel("Data/data_ex.xls", col_names = FALSE) #컬럼명을 시스템에서 자동적으로 만들어진다.
data #해더가 없으면 데이터값의 맨 첫번째들이 해더가 되어버린다.
colnames(data) <- c('ID','gender','age','area')
data


#1.2 데이터 쓰기 (파일(csv)로 쓰기 vs 변수만 쓰기.)
# 파일 write 하는 법.
write.csv(exam, "outData/exam.csv", row.names = TRUE) # row.names =T 엑셀파일에 행번호도 같이 추가댐.


#변수로만 쓰이는 법.
save(exam, file="outData/exam.rda") #exam 변수를 파일로 저장함.
rm(list=ls(all.names = TRUE)) #모든 변수 삭제.
exam #변수 삭제되서 못불러옴.

#딥러닝할때 주로 쓰임.
load('outData/exam.rda') #환경창에도 뜸. 메모리에 올라가있으니 사용가능하다는 말.
exam


#2. 데이터 파악하기
mpg <- as.data.frame(ggplot2::mpg) #  => table 형과 데이터프레임형 혼합형을 데이터프레임형으로 만듬. 
head(mpg)
tail(mpg)
edit(mpg) #뷰창
View(mpg) #뷰창
dim(mpg)  #차원
summary(mpg) #최솟값, 1사분위수 , 중위수 ,3사분위수 ,최댓값

#head() 앞부분 6개만 , tail()뒷부분 6개만. , View() = edit() 뷰창에서 데이터 확인용.
#dim() 차원 , str() 구조, summary() 요약통계

#변수명 바꾸기 (cty -> city , hwy -> highway)
library(dplyr) #라이브러리 로드.
#없으면 install.packages("dplyr")

mpg <- rename(mpg, city=cty) #앞이 new 뒤가 old.
mpg <- rename(mpg, highway = hwy)
colnames(mpg)

#파생변수 생성.(계산식으로.)
head(mpg)
mpg$total = (mpg$city + mpg$highway)/2
head(mpg, 3)


#파생변수 생성.(조건식으로.)
#================================================== plot 시각화 종류와 약간의 설명.
boxplot(mpg$total) # (1) 박스플롯.
hist(mpg$total) # (2) 히스토그램.
#boxplot 보완 vioplot.
library("vioplot") #있는지 없는지 확인.
install.packages("vioplot") # 없으면 인스톨.
vioplot(mpg$total, col="red") #col= 색상.   #(3) 바이올린플롯

par(mfrow=c(1,3)) #시각화 그래프를 1행 3열로 출력하기 위함.
boxplot(mpg$total) # (1) 박스플롯.
hist(mpg$total) # (2) 히스토그램.
vioplot(mpg$total, col="red") #col= 색상.   #(3) 바이올린플롯
par(mfrow=c(1,1)) #플롯공간을 다시 원상복구 시켜야 함.

#==============================================


mean(mpg$total)
mpg$test <- ifelse(mpg$total >= mean(mpg$total), "pass", "fail")
table(mpg$test) #빈도표 출력.
hist(mpg$total) #막대그래프. 

?qplot
library(ggplot2)
qplot(mpg$test, color=mpg$test) #빈도 그래프

#문제1)혼자분석하기.
midwest <- ggplot2::midwest
  #데이터 파악하기, 파생변수 생성.
head(midwest) #table 형태이면서 데이터프레임형태.
midwest <- as.data.frame(ggplot2::midwest)
head(midwest)

#(1) 데이터특성 파악하기.
head(midwest)
View(midwest)
dim(midwest)
str(midwest)
summary(midwest)

#(2) 변수명 수정하기. [poptotal => total, popasian => asian]
colnames(midwest) #수정전에 컬럼이름이 무엇인지 확인.
midwest <- rename(midwest, total=poptotal) 
head(midwest) #또는 colnames 로 확인. 

midwest <- rename(midwest, asian=popasian)
head(midwest)



#(3) 전체인구 대비 아시아 인구 백분율 파생변수
midwest$ratioasian <- midwest$asian / midwest$total * 100
midwest[,c('total','asian','ratioasian')]
hist(midwest$ratioasian)

#(4) "large", "small"
hist(midwest$asian)
boxplot(midwest$asian)
boxplot(mpg$total)

mean(midwest$ratioasian) #평균이 48%
boxplot(midwest$ratioasian) #분포도 가 한쪽에 몰려있는걸 볼수있다. 
midwest$group <- ifelse(midwest$ratioasian>=mean(midwest$ratioasian),'large','small')

head(midwest[,c('total','asian','ratioasian','group')])#잘 되었는지 확인.
dim(midwest)



#(5)'large' 와 'small' 에 해당하는 지역이 얼마나 되는지 => 빈도표 확인.
table(midwest$group) #NA도 있으면 NA도 나옴.
nrow(midwest)


#3. 파악한 데이터를 dplyr 패키지를 이용하여 전처리 및 분석하기.

#filter()	:	행 추출
#	select()	:	열(변수) 추출
#	arrange()	:	정렬
#	mutate()	:	변수 추가(새필드)
#	summarise()	:	통계치 산출
#	group_by()	:	집단별로 나누기
#============================= 이 6개는 다같이 사용가능.순서도 없음.
#left_join() : 데이터합치기(열)
#bind_rows() : 데이터합치기(행)

#3.1 filter() = 조건에 맞는 데이터 추출.
exam <- read.csv("Data/exam.csv", header=T) #header= 있으면 T 없으면 F
exam
# %>% 단축키. ctrl+ shift + m
exam %>% filter(class==1)
#exam %>%  (들여쓰기.)
#  filter(class==1) 이 함수만 가독성을 위해 이렇게 한다.
#class 가 1이거나 2, 3 인 데이터추출.
exam %>% 
  filter(class==1 | class== 2 | class==3)
exam %>% 
  filter(class %in% c(1,2,3))
#================  %in% 를 이용한것이 많이 쓰인다. ====

#class 가 1이고, english 가 80 이상인 데이터 추출. '&'
exam1 <- exam %>% 
  filter(class == 1 & english >= 80)
exam1 #이렇게 데이터를 가지고 있어야 다음에 쓰일수도 있다. 이게 장점일수도.. 단점일수도 있음..


#3.2 select() : 필요한 변수 추출하기.

exam %>%  #exam 에 있는 변수만 들어감.
  select(class, english, math) # 추출하고자 하는 변수만 select함수안에 넣으면 된다.

exam %>% 
  select(-math) #' - ' 해당 변수만 제외하고 전체 출력.

#class 가 1과 2의 행 중에서 영,수 데이터만 출력.
exam %>% 
  filter(class %in% c(1,2)) %>% # <- 추가하고 써야한다
  select(english, math) #필터와 셀렉트 순서 바뀌어도 상관x.


#class가 1,2,3 행 에서 영,수 데이터만 앞 5개 만 추출.
exam %>%  #         c(1,2,3,) ,남기면 안댐.
  filter(class %in% c(1,2,3)) %>% 
  select(english, math) %>% 
  head(5) # <-앞 5개만. 6개면 그냥 head까지만 사용.



# 3.3 arrange() : 정렬하기.
exam %>% arrange(math) # 오름차순 정렬.
exam %>% arrange(desc(math)) #내림차순 정렬.1
exam %>% arrange(-math) # 내림차순 정렬.2
exam %>% arrange(class, -math) # class 내림차순.
exam %>% arrange(class, desc(math)) #class 오름차순 , class 가 같은경우 math 내림차순.

#id 가 1~10 인 학생의 영어,수학 성적을 영어성적 기준으로 오름차순으로 정렬하여 top6만 추출.
exam %>% 
  filter(id %in% c(1:10)) %>% 
  select(english, math) %>% 
  arrange(english) %>% 
  head



#3.4 파생변수 추가.=> mutate() : 변수 추가. 출력하는 값만 변화. exam 변화 x.
exam %>% 
  mutate(total = math + english + science) #total 이 추가가 됨. 
head(exam) # exam 에 추가가 되었는 지 확인, 하지만 추가가 되어있지않음.

exam %>% 
  mutate(total = math + english + science) %>% 
  filter(total>=150)


exam %>%  #파생변수를 한번에 두개이상 추가해서 분석하기.
  mutate(total = math + english + science, 
         avg = round((math + english + science)/3)) %>% 
  head
head(exam)


# 추가한 파생변수를 dplyr 코드에 바로 활용. dplyr 안에 %>% 있어서 활용가능함.
exam %>% 
  mutate(total = math + english + science, 
         avg = round((math + english + science)/3)) %>% 
  select(-id) %>% 
  arrange(desc(total)) %>% 
  head(3)


#3.5 요약하기 => summarise()
#summarise 안에 들어갈수 있는 요약함수들 : mean, sum, sd, min, max, median, n (카운트횟수.)
exam %>% 
  summarise(mean_math=mean(math))

exam %>% 
  summarise(mean_math=mean(math), #동시 추출 가능.
            mean_eng=mean(english),
            sd_math=sd(math), #=> 20.299~ 분포가 넓음. 
            sd_eng=sd(english))  #sd 표준편차. 12.87~ 분포가 좁음.

#3.6 집단별로 요약하기 group_by() + summarise()
exam %>% 
  group_by(class) %>% 
  summarise(mean_math = mean(math),
            n=n(),  #n= 행 갯수.
            max_eng = max(english)) %>% 
  arrange(mean_math)


# 문. class 별 수학,영어, 과학 의 평균을 출력.
exam %>% 
  group_by(class) %>% 
  summarise(mean_eng = mean(english),
            mean_math = mean(math),
            mean_sci = mean(science))


library("doBy")
summaryBy(math+english+science ~ class, exam) #자바소스에 넣을때 많이 쓰이는 방법.



#mpg 
mpg <- as.data.frame(ggplot2::mpg)
mpg

#회사별로 "suv 자동차의 도시 및 고속도로 통합 연비 평균을 구해 내림차순으로 정렬하고, top1~5 까지 출력.
 
mpg %>% 
  filter(class == 'suv') %>% # suv 자동차만.
  group_by(manufacturer) %>%  #회사별.
  mutate(total = (cty+hwy)/2) %>% #통합 연비 평균. 파생변수 생성.
  summarise(tot_mean = mean(total)) %>% 
  arrange(desc(tot_mean)) %>% 
  head(5)


#혼자서 해보기1 : mpg 데이터를 이용해 분석.
#Q1. 자동차 배기량에 따라 고속도로 연비가 다른지 알아보려고 합니다. 
# displ(배기량)이 4이하인 자동차와 5 이상인 자동차 중 어떤 자동차의 hwy(고속도로 연비)가 평균적으로 더 높은지 알아보세요.

#(1)dplyr 패키지 이용.
mpg
mpg %>% 
  mutate(group = ifelse(displ <=4 , "배기량 4이하", ifelse(displ >=5, "배기량 5이상", NA ))) %>%
  group_by(group) %>% 
  summarise(mean_total = mean(hwy)) %>% 
  filter(!is.na(group))

mpg %>% 
  filter(displ<=4 | displ>=5) %>% 
  mutate(group = ifelse(displ<=4, "배기량4이하", ifelse(displ>=5, "배기량5이상", NA))) %>% 
  group_by(group) %>% 
  summarise(mean_total=mean(hwy)) 

#===================================

#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
mpg
testMpg <- mpg
str(testMpg)
(displ1 <- subset(testMpg, subset = (testMpg$displ <= 4 )))
(displ2 <- subset(testMpg, subset = (testMpg$displ >= 5 )))

displ1_hwy<-tapply(displ1$hwy, displ1$displ, mean)
displ2_hwy<-tapply(displ2$hwy, displ2$displ, mean)  #summaryBy 에서 FUN=mean 생략 가능. 생략했을때 안되면 추가해야함.
mean(displ1_hwy)
mean(displ2_hwy)

#==============================

df <- mpg[(mpg$displ<=4 | mpg$displ>= 5),]

df$group <- ifelse(df$displ<=4, "배기량4이하", ifelse(df$displ>=5, "배기량5이상", NA))
head(df)
tapply(df$hwy, df$group, mean)
by(df$hwy, df$group, mean) # 다수개 열일때는 mean은 안되고 summary, sum 등 됨
summaryBy(hwy~group, df, FUN=mean) # 다수개 열과 다수개 함수 가능
aggregate(df$hwy, by=list(df$group), mean)


#Q2. 자동차 제조 회사에 따라 도시 연비가 다른지 알아보려고 합니다.
# "audi"와 "toyota"중 어느 manufacturer(자동차 제조 회사)의 cty(도시 연비)가 평균적으로 더 높은지 알아보세요.
#(1)dplyr 패키지 이용.
mpg %>% 
  filter(manufacturer %in% c('audi','toyota')) %>% 
  group_by(manufacturer) %>% 
  summarise(city_avg = mean(cty)) %>% 
  arrange(desc(city_avg))
#=========================

#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy 
mpg
testMpg <- mpg
testMpg
(audi <- subset(testMpg, subset = (testMpg$manufacturer == 'audi')))
(toyota <- subset(testMpg, subset = (testMpg$manufacturer == 'toyota')))
(cty_Avg1 <- tapply(audi$cty, audi$manufacturer, mean))
(cty_Avg2 <- tapply(toyota$cty, toyota$manufacturer, mean))

#==================
df <- mpg[mpg$manufacturer %in% c("audi", "toyota"),]
head(df)
tapply(df$cty, df$manufacturer, mean)
by(df$cty, df$manufacturer, mean) # 다수개 열 가능
summaryBy(cty~manufacturer, df, FUN=c(mean)) # 다수개 열과 다수개 함수
aggregate(df$cty, by=list(df$manufacturer), mean) #다수개열 가능


#Q3. "chevrolet", "ford","honda" 자동차의 고속도로 연비 평균을 알아보려고 합니다.
# 이 회사들의 자동차를 추출한 뒤 hwy 전체 평균을 구해보세요.
#(1)dplyr 패키지 이용.
mpg %>% 
  filter(manufacturer %in% c('chevrolet','ford','honda')) %>% 
  group_by(manufacturer) %>% 
  summarise(hwy_avg = mean(hwy))



#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
(chevrolet <- subset(testMpg, subset = (testMpg$manufacturer == 'chevrolet')))
(ford <- subset(testMpg, subset = (testMpg$manufacturer == 'ford')))
(honda <- subset(testMpg, subset = (testMpg$manufacturer == 'honda')))
(chevrolet_hwy <- tapply(chevrolet$hwy , chevrolet$manufacturer, mean))
(ford_hwy <- tapply(ford$hwy , ford$manufacturer, mean))
(honda_hwy <- tapply(honda$hwy , honda$manufacturer, mean))

mean(chevrolet_hwy, ford_hwy, honda_hwy)

#==============================
df <- mpg[mpg$manufacturer %in% c("chevrolet", "ford", "honda"),]
df <- subset(mpg, (mpg$manufacturer %in% c("chevrolet", "ford", "honda")) )
df <- subset(mpg, (manufacturer %in% c("chevrolet", "ford", "honda")) )
tapply(df$hwy, df$manufacturer, mean)
by(df$hwy, df$manufacturer, mean)
summaryBy(hwy~manufacturer, df, FUN=mean)
aggregate(df$hwy, by=list(df$manufacturer), mean)


#혼자서 해보기2.
# Q1. mpg 데이터는 11개 변수로 구성되어 있습니다. 이 중 일부만 추출해서 분석에 활용하려고 합니다.
# mpg 데이터에서 class(자동차 종류), cty(도시 연비) 변수를 추출해 새로운 데이터를 만드세요. 
#새로 만든 데이터의 일부를 출력해서 두 변수로만 구성되어 있는지 확인하세요.
#(1)dplyr 패키지 이용.
mpg

class_cty <- mpg %>% 
  select(class, cty)

class_cty #(원하는 데이터들 저장.)


#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
testMpg <- mpg
testMpg

(class_cty <- subset(testMpg, select = c(class, cty)))

#=============
mpg[,c('class','cty')]
subset(mpg, select=c('class','cty'))


#Q2. 자동차 종류에 따라 도시 연비가 다른지 알아보려고 합니다. 
#앞에서 추출한 데이터를 이용해서 class(자동차 종류)가 "suv"인 자동차와 "compact"인 자동차 중 어떤 자동차의 cty(도시 연비)가 더 높은지 알아보세요.

#(1)dplyr 패키지 이용.
#class_cty 안에 있는 데이터들 중에서 찾아야하니, class_cty %>% .
suv_cty <- class_cty %>% 
  filter(class == c("suv"))
suv_cty  

compact_cty <- class_cty %>% 
  filter(class == "compact")
compact_cty

mean(suv_cty$cty)
mean(compact_cty$cty) #compact 의 연비가 더 좋다.

#=================
table(mpg$class)
# (1) 방법
mpg %>% 
  filter(class %in% c('suv','compact')) %>% 
  group_by(class) %>% 
  summarise(mean_cty = mean(cty))


#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
df <- mpg[mpg$class %in% c('suv','compact') ,]
df
tapply(df$cty, df$class, mean)
by(df$cty, df$class, mean)
summaryBy(cty~class, df, FUN=mean)
aggregate(df$cty, by=list(df$class), mean)



# Q3. "audi"에서 생산한 자동차 중에 어떤 자동차 모델의 hwy(고속도로 연비)가 높은지 알아보려고 합니다. 
#"audi"에서 생산한 자동차 중 hwy가 1~5위에 해당하는 자동차의 데이터를 출력하세요.
#(1)dplyr 패키지 이용.
mpg %>% 
  filter(manufacturer == 'audi') %>% 
  arrange(-hwy) %>% # or desc(hwy)
  head(5) #tail 하위 뽑기.

#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
df<- mpg[mpg$manufacturer=='audi',]
head(orderBy(~-hwy, df),5)
head(df1[order(df$hwy, decreasing = T),],5)

#혼자서 해보기3.
#Q1. mpg 데이터 복사본을 만들고, cty와 hwy를 더한 '합산 연비 변수'를 추가하세요.
#(1)dplyr 패키지 이용.
mpgcopy <- mpg

mpgcopy <- mpgcopy %>% 
  mutate(total = cty + hwy)
mpgcopy

#==========
mpg %>% 
  mutate(total = cty+hwy)



#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy

df <- mpg
df$total <- df$cty + df$hwy
df

#Q2. 앞에서 만든 '합산 연비 변수'를 2로 나눠 '평균 연비 변수'를 추가세요.
#(1)dplyr 패키지 이용.
mpgcopy <- mpgcopy %>% 
  mutate(mean = total/2)
mpgcopy
#=========
mpg %>% 
  mutate(total = (cty+hwy)/2)


#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
mpg$total <- (mpg$cty+mpg$hwy)/2


#Q3. '평균 연비 변수'가 가장 높은 자동차 3종의 데이터를 출력하세요.
#(1)dplyr 패키지 이용.
mpgcopy %>% 
  arrange(desc(mean)) %>% 
  head(3)

#========
mpg %>% 
  mutate(total = (cty+hwy)/2) %>% 
  arrange(desc(total)) %>% 
  head(3)


#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
head(orderBy(~-total, mpg),3)
orderBy(~-total, mpg)[1:3,]
head(mpg[order(mpg$total, decreasing = T),],3)
head(mpg[order(-mpg$total),],3) # mpg$total앞에 -를 붙여 내림차순정렬을 할 수 있는 것은 total이 숫자이기 때문. 문자나 logical일 경우 아래와 같이 desc이용
head(mpg[order(desc(mpg$total)),],3)



#Q4. 1~3번 문제를 해결할 수 있는 하나로 연결된 dplyr 구문을 만들어 출력하세요. 데이터는 복사본 대신 mpg 원본을 이용하세요.
#(1)dplyr 패키지 이용.
mpg %>% 
  mutate(total = cty + hwy , mean =total/2) %>%  # mutate(total = (cty+hwy)/2) %>% 
  arrange(desc(mean)) %>% 
  head(3)

#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
head(orderBy(~-total, mpg),3)
head(mpg[order(mpg$total, decreasing = T),],3)


#혼자서 해보기4.
#Q1. mpg 데이터의 class는 "suv", "compact" 등 자동차를 특징에 따라 일곱 종류로 분류한 변수입니다. 어떤 차종의 연비가 높은지 비교해보려고 합니다. 
#class별 cty 평균을 구해보세요.
#(1)dplyr 패키지 이용.
mpg %>% 
  group_by(class) %>% 
  summarise(cty_avg = mean(cty))


#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
tapply(mpg$cty, mpg$class, mean)
by(mpg$cty, mpg$class, mean)
summaryBy(cty~class, mpg)
aggregate(mpg$cty, by=list(mpg$class), mean)


#Q2. 앞 문제의 출력 결과는 class 값 알파벳 순으로 정렬되어 있습니다. 
#어떤 차종의 도시 연비가 높은지 쉽게 알아볼 수 있도록 cty 평균이 높은 순으로 정렬해 출력하세요.
#(1)dplyr 패키지 이용.
mpg %>% 
  group_by(class) %>% 
  summarise(cty_avg = mean(cty)) %>% 
  arrange(desc(cty_avg))

#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy

# (2) 방법 - tapply - sort
sort(tapply(mpg$cty, mpg$class, mean), decreasing = TRUE)
# (2) 방법 -  tapply - order
result <- tapply(mpg$cty, mpg$class, mean)
class(result) # array 형태
result[order(result, decreasing = T)]

tapply(mpg$cty, mpg$class, mean)[order(tapply(mpg$cty, mpg$class, mean), decreasing = T)]
# (2) 방법 - by -sort
sort(by(mpg$cty, mpg$class, mean), decreasing = T)
# (2) 방법 - by -order
by(mpg$cty, mpg$class, mean)[order(by(mpg$cty, mpg$class, mean), decreasing = T)] # 가독성을 올리려면 결과를 변수로 뺌
result <- by(mpg$cty, mpg$class, mean)
result[order(result, decreasing = T)]

# (2) 방법 - summaryBy - order
result <- summaryBy(cty~class, mpg)
result # result가 data.frame 형태
result[order(result$cty.mean, decreasing = T),]
# (2) 방법 - summaryBy - orderBy
orderBy(~-cty.mean, result)
# (2) 방법 - aggregate - order
result<-aggregate(mpg$cty, by=list(mpg$class), mean)
result
result[order(result$x, decreasing = T),]
orderBy(~-x, result)


#Q3. 어떤 회사 자동차의 hwy(고속도로 연비)가 가장 높은지 알아보려고 합니다. hwy 평균이 가장 높은 회사 세 곳을 출력하세요.
#(1)dplyr 패키지 이용.
mpg %>% 
  group_by(manufacturer) %>% 
  summarise(hwy_avg = mean(hwy)) %>% 
  arrange(-hwy_avg) %>% 
  head(3)


#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
result <-aggregate(mpg$hwy, by=list(mpg$manufacturer), mean)
result # result가 data.frame형태
head(result[order(result$x, decreasing = T),] , 3)
result[order(result$x, decreasing = T),][1:3,]
head(orderBy(~-x, result), 3)

#Q4. 어떤 회사에서 "compact"(경차) 차종을 가장 많이 생산하는지 알아보려고 합니다. 각 회사별 "compact" 차종 수를 내림차순으로 정렬해 출력하세요.
#(1)dplyr 패키지 이용.
mpg %>% 
  group_by(manufacturer) %>% 
  filter(class == "compact") %>% 
  summarise(count = n()) %>%  #n() 안에 아무것도 안넣는다.  summarise(cnt = n()) %>%  cnt 변수이름이다.
  arrange(-count)


#(2)apply 계열 함수 이용 : tapply, summaryBy(doBy), aggregate , by, order, orderBy
df <- mpg[mpg$class=='compact',]
df <- subset(mpg, mpg$class=='compact')
df <- subset(mpg, class=='compact')
df
sort(table(df$manufacturer), decreasing = T)



#4. 데이터 합치기 
#열 합치기 : cbind,  left_join(cbind 를 못 쓰이거나 할때 쓰인다.)
#행 합치기 : rbind, bind_rows (rbind 를 못 쓰이거나 할때 쓰인다.)
#cf. merge.

#4.1 열 합치기 (가로 합치기)
test1 <- data.frame(id=c(1,2,3,4,5),
                    midterm = c(70,80,90,95,99))
test2 <- data.frame(id=c(1,2,3,4,5),
                    final = c(90,80,70,60,99),
                    teacherid = c(1,1,2,2,3))
teacher <- data.frame(teacherid =c(1,2,3),
                      teachername = c('Kim','Park','Ryu'))

cbind(test1, test2) #id 가 두개라 쓰기가 좀 그럼.
merge(test1, test2) # 중복된거 하나로 합쳐짐. 그래서 id 가 하나만 나옴.
left_join(test1,test2, by='id') # merge 랑 같은걸로 알겠지만, 다르다.
test2 # test2 와 teacherid cbind 불가.

left_join(test2, teacher, by="teacherid") 
merge(test2, teacher, by="teacherid") 


#(2)
test1 <- data.frame(id=c(1,2,3,4,5),
                    midterm = c(70,80,90,95,99))
test2 <- data.frame(id=c(1,2,3,4,5),
                    final = c(90,80,70,60,99),
                    teacherid = c(1,1,2,2,4))
teacher <- data.frame(teacherid =c(1,2,3),
                      teachername = c('Kim','Park','Ryu'))

cbind(test1, test2) #id 가 두개라 쓰기가 좀 그럼.
merge(test1, test2) # 중복된거 하나로 합쳐짐. 그래서 id 가 하나만 나옴.
left_join(test1,test2, by='id') # merge 랑 같은걸로 알겠지만, 다르다.
test2 # test2 와 teacherid cbind 불가.

left_join(test2, teacher, by="teacherid") 
merge(test2, teacher, by="teacherid", all= T) # NA 모두 처리해라.



#4.2 행 합치기.(세로 합치기)
#(1)
group_a <- data.frame(id= c(1,2,3,4,5),
                      test = c(60,70,80,90,95))

group_b <- data.frame(id= c(6,7,8,9,10),
                      test = c(90,95,94,93,92))


rbind(group_a, group_b) # 두 데이터프레임의 변수가 같을 경우.
bind_rows(group_a, group_b) # 위아래 같은 결과.



#(2)
group_a <- data.frame(id= c(1,2,3,4,5),
                      test1 = c(60,70,80,90,95))

group_b <- data.frame(id= c(6,7,8,9,10),
                      test2 = c(90,95,94,93,92))


rbind(group_a,group_b) # 에러가 난다. => 두 데이터프레임의 변수가 일부 같지 않을 경우.
bind_rows(group_a, group_b) # NA값이 잡힌다. 변수가 같지 않아도 합쳐진다.
merge(group_a,group_b) # 그냥 하면 안됀다.
merge(group_a,group_b, all= T) # 이렇게 해야 한다.



#5. 데이터 정제하기. = 결측치(NA), 이상치 = boxplot 했을때 얇은 선보다 위에있거나 제일 아래에 있거나 할때.
#5.1 결측치 정제하기.
df <- data.frame(name=c('Kim','Yi','Yun','Ma','Park'),
                 gender= c('M','F',NA,'M','F'),
                 score= c(5,4,3,4,NA),
                 income= c(2000,3000,4000,4500,4600))
df
is.na(df) #결측지 확인. (TRUE = NA)
dim(df)
length(df)
table(is.na(df))
table(is.na(df$gender))
table(is.na(df$score))

na.omit(df) #결측치가 하나라도 있으면 그 행 모두 제거. 간편하나, 같은 행의 분석에 필요한 열의 정보까지 손실된다는 단점이 있음.

library(dplyr)
df %>% 
  filter(!is.na(score)) %>% 
  summarise(mean_score= mean(score)) 

mean(df$score, na.rm=T) # 결측치 를 제거하고 평균을 냄.

tapply(df$score, df$gender, mean, na.rm= T ) # 결측치 를 제거하고 평균을 냄.
#mean 자리에 오는 6개 함수 뒤에 모두 na.rm= T 가능.

#결측치를 대체하기(대부분 평균값이나, 중앙값으로 대체한다.)
x <- c(1,1,2,2,3,3,3,4,4,5,5,100) #100 같은 값을 이상치라 한다.
mean(x) # 평균값.
median(x) #중앙값.

exam <- read.csv("Data/exam.csv", header = T ) #header = T 기본값이라 헤더가 없으면 = F.
exam 
table(is.na(exam)) # 결측치가 하나도 없는 상태.
colnames(exam)
exam[c(3,8,15),'math'] <- NA #인위적으로 math에 결측치 넣기.
exam[1:2, 'english'] <- NA # 인위적으로 english에 결측치 넣기.

table(is.na(exam)) # 결측치는 인위적으로 5개가 들어가있다.
apply(exam[3:5], 2, mean, na.rm=T)
tapply(exam[,3], exam$class, mean, na.rm=T)


exam %>% 
  summarise(math = mean(math, na.rm= T),
            english = mean(english, na.rm=T),
            science = mean(science, na.rm=T))

#결측치들을 중앙값으로 대체.
exam$math # 결측치 확인.
exam$math <- ifelse(is.na(exam$math),median(exam$math, na.rm = T), exam$math) # 중앙값으로 대체.
exam$math <- ifelse(is.na(exam$math),round(mean(exam$math, na.rm = T)), exam$math) #평균값으로 대체.
exam$math #결측치 대체됨.

exam$english #결측치가 있는지 확인.
exam$english <- ifelse(is.na(exam$english), round(median(exam$english, na.rm = T)), exam$english)
#소숫값이 생긴이유 : 데이터가 짝수개 이면 소수값이 생긴다. 따라서 round() 로 감싸줬다.
round(exam$english)

table(is.na(exam))

#결측치가 없으면 다시 처음부터.
exam <- read.csv("Data/exam.csv")
exam [c(1,3,8), 'math'] <- NA
exam[1:2, 'english'] <- NA
exam[1, 'science'] <- NA
head(exam)

median <- round(apply(exam[3:5], 2, median, na.rm=T))
median['math']; median['english']; median['science']

exam <- within(exam,{ #결측치 대체하기 위한 블록
  math <- ifelse(is.na(math), median['math'], math)
  english <- ifelse(is.na(english), median['english'], english)
  science <- ifelse(is.na(science), median['science'], science)
  })
table(is.na(exam)) # exam 안에 결측치 갯수 확인.
colSums(is.na(exam)) #변수별 결측치 갯수 확인.


#결측치 대체 방법2 (dplyr 패키지 이용) 하지만 대부분 방법1을 주로 쓴다.
colSums(is.na(exam)) # 윗 방법이나 아래방법 둘중에 하나 한번만 해야 한다.
median['math']; median['english']; median['science']
exam <- exam %>% 
  mutate(
    math = ifelse(is.na(math), median['math'], math),
    english = ifelse(is.na(english), median['english'], english),
    science = ifelse(is.na(science), median['science'], science)
  )
colnames(exam) <- c('id','class','math','english','science')
exam  # 좀더 직관적이다.



#5.2 이상치 정제 [이상한 값 이상치.]
#(1) 극단적인 이상치(정상범위 기준에서 훨씬 벗어난 값.)
#(2) 논리적인 이상치(성별에 남여가 아닌 값.)
#이상치는 결측치로 대체

#논리적인 이상치.
outlier <- data.frame(gender= c(1,2,1,3,2),
                      score= c(90,95,100,99,101))
table(outlier$gender)
#gender = 1은 남, 2는 여, 3은 이상치 처리.
outlier$gender <- ifelse((outlier$gender!=1 & outlier$gender!=2), NA, outlier$gender)
outlier$gender <- ifelse(outlier$gender==3, NA, outlier$gender)
outlier



#scoer 가 100초과하는 경우 이상치 처리.
outlier$score <- ifelse(outlier$score>100, NA, outlier$score)
outlier



#(2) 정상범위 기준으로 많이 벗어난 이상치 : 상하위 0.3% = 극단치. 또는 평균+3*표준편차
mpg <- as.data.frame(ggplot2::mpg)
mpg$hwy
mean(mpg$hwy)+3*sd(mpg$hwy) # 이것보다 크면 이상치.
mean(mpg$hwy)-3*sd(mpg$hwy) # 이것보다 작으면 이상치.


result <- boxplot(mpg$hwy)$stats #$stats 통계치.
result[1] ; result[5]  #1 하위 극단치 경계, 5 상위 극단치 경계.
mpg$hwy <- ifelse(mpg$hwy>result[5] | mpg$hwy<result[1], NA, mpg$hwy) 
table(is.na(mpg$hwy)) # 3개가 이상치 있다.




#혼자 해보기 (5) mpg 에 price_fl 변수 추가.
#(1)
mpg <- as.data.frame(ggplot2::mpg)
colnames(mpg)
mpg$fl
table(mpg$fl)
head(mpg,2)
fuel <- data.frame(fl=c('c','d','e','p','r'),
                   kind = c('CNG','diesel','ethanol E85','premium','regular'),
                   price_fl=c(2.35,2.38,2.11,2.76,2.22))
fuel
#(1)방법
mpg <- left_join(mpg, fuel[,c('fl','price_fl')], by='fl')
mpg
#(2) 방법
mpg <- merge(mpg, fuel[,c('fl','price_fl')], by='fl')
head(mpg,2)

#(1)방법
result <- subset(mpg1, select = c('model','fl','price_fl'))
head(result, 5)
#==============
mpg %>% 
  select(model, fl, price_fl) %>% 
  head(5)

#(2)방법
mpg[1:5, c('model','fl','price_fl')]

#혼자해보기 6.
mpg
table(mpg$drv)
mpg[c(10, 14, 58, 93), "drv"] <- "k" # drv 이상치 할당
mpg[c(29, 43, 129, 203), "cty"] <- c(3, 4, 39, 42) # cty 이상치 할당

boxplot(mpg$cty)$stats
table(mpg$drv) # 이사치 확인.
mpg$drv <- ifelse(mpg$drv=='k', NA ,mpg$drv )
table(mpg$drv)
#== 위아래 ifelse 구문 딱 한번만 해야하며, 다른 함수들로 새로운 시도를 할려면 mpg 데이터를 처음부터 다시 불러와서 실행 할것.
mpg$drv <- ifelse(mpg$drv %in% c('4','f','r'), mpg$drv, NA)
table(mpg$drv)


colSums(is.na(mpg))
table(is.na(mpg$drv))
table(mpg$drv)
table(mpg$drv, useNA='ifany') # NA 갯수까지 나옴
table(mpg$drv, exclude = NULL)# NA 갯수까지 나옴


#	Q2. 상자 그림을 이용해서 cty에 이상치가 있는지 확인하세요. 상자 그림의 통계치를 이용해 정상 범위를 벗어난 값을 결측 처리한 후 다시 상자 그림을 만들어 이상치가 사라졌는지 확인하세요.
result <- boxplot(mpg$cty)$stats # 상자 그림 생성 및 통계치 산출
mpg$cty <- ifelse(mpg$cty < result[1] | mpg$cty > result[5], NA, mpg$cty)
table(is.na(mpg$cty))
boxplot(mpg$cty) # 이상치 boxplot에서 사라짐

#	Q3. 두 변수의 이상치를 결측처리 했으니 이제 분석할 차례입니다. 이상치를 제외한 다음 drv별로 cty 평균이 어떻게 다른지 알아보세요. 하나의 dplyr 구문으로 만들어야 합니다.

mpg %>%
  filter(!is.na(drv) & !is.na(cty)) %>%  # 결측치 제외
  group_by(drv) %>%                      # drv별 분리
  summarise(mean_hwy = mean(cty))        # cty 평균 구하기

tapply(mpg$cty, mpg$drv, mean, na.rm=T)
by(mpg$cty, mpg$drv, mean, na.rm=T)
library(doBy)
# summaryBy만 drv가 NA인 그룹도 평균을 내서 미리 NA 제외
summaryBy(cty~drv, mpg[!is.na(mpg$drv),], FUN=mean, na.rm=T)
aggregate(mpg$cty, by=list(mpg$drv), mean, na.rm=T)