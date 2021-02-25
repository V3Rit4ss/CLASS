# # # 8장. 데이터 시각화 # # #

# 1.시각화 개요. : 원본 데이터,분석된 결과 데이터를 그래프로 표현.(사용자에게 효과적으로 정보전달이 목적.)


#1.1 R 의 그래픽 시스템.

#(1)방법 : base graphics system = 전통적인 함수 이용. 정교한 그래프 이용시 노력 필요.
                                  #그래프 종류별 함수가 각기 달라 정교한 그래프 이용시 노력 필요.
                                  #R 프로그램이 만들어질때 생긴 기본적인 언어.


#(2)방법 : grid graphics system = base graphics system 한계 극복을 위해 탄생한 패키지.(ggplot2)
#유연한 그래프 환경 제공.


#ggplot(data=mtcars, aes(x=wt, y=mpg)) <=[그래프 초기화] +

# ex.
library(ggplot2)
ggplot(data=mtcars, aes(x=wt, y=mpg)) + 
  geom_point() +              #산점도.
  labs(title= "그래프 첫 예제") +
  geom_smooth()               #추세선:파란선, 회색: 신뢰구간.


# 1.2 그래프 함수의 종류들.
# 고수준 그래프 함수 : plot(산점도), barplot(막대), boxplot(박스그래프프), hist(히스토그래프), pie(원)
#  그래프 함수를 호출할때 마다, 그래프영역에 새로운 그래프를 시작.

# 저수준 그래프 함수 : lines, ablisne(회귀라인) , point, text, ...
#그래프 함수를 호출할때 마다, 새로운 그래프를 생성하지 않고, 이미 그려진 그래프위에 점, 라인, 글씨 등 가 나타난다.


#1.3 그래프 파라미터. : bty(박스유형), ...~
# (1) par() : 그래프를 조정하거나 특성을 지정.  [선굵기, 종류, 글꼴, ...~ ]
# par() 함수의 리턴값은 실행전의 특성을 리턴한다.


?cars
cars # 차속도와 제동거리.
#plot(cars$speed, cars$dist) cars 하나만 써도 무방.
plot(cars)

oldpar <- par(bty = 'L') #oldpar 에 o 형태의 박스모양이, par에는 L 로 되어있다. 실행은 딱 한번만.
#bty => ("O", "L", "7", "c", "u", "]") 이렇게 많은 모양들이 있다. n 을 넣으면 그래프 박스가 사라진다.
?par
plot(cars)
plot(iris)
par(oldpar) #oldpar 속성으로 바뀜.
plot(cars) # 고수준 그래프 함수.


#fit <- lm(cars$dist ~ cars$speed) cars$ 왠만하면, 안쓴다.
fit <- lm(dist ~ speed, data=cars)
abline(fit, col=2) #저수준 그래프 함수. col = 색상. "red" 이렇게도 가능.
fit



#par 함수의 다른 파라미터 사용 예.
x <- 1:100
y1 <- rnorm(100) #평균0이고 표준편차가 1인 수 100개 추출. => 표준정규분포. 실행할때마다 값이 달라짐.
# 표준정규분포는 평균이0 이고 표준편차가 1인 수 이어야만 한다.
#rnorm 정규분포
y2 <- rnorm(100)+100 #평균 100 이고 , 표준편차는 1인 수 100개. => 정규분포.

#한번만 실행해야함 !!
oldPar <- par(mar=c(5,5,5,5)) # => 그래프 여백(하 , 좌, 상, 우)
?par #해당 파라미터가  궁금하면 도움말의 도움을 받아서 Graphical Parameters을 보고 알아보자.
#?par => pch 해석문에서 point 클릭.-> pch values 확인.
plot(x, y1, pch=0, type='b', col=4)  #n + 추세선 = 추세선만 한다던지 활용가능. 
#pch=0 -> ㅁ , 1:o , 2:세모 3:+ , 4:x 5:다이아몬드... 문자해당 문자.
#type = p:점, l:선, b: 점선동시, h:히스토그램, s:계단모양, n:좌표찍지 않음.

#col= 1:black, 2:red , 3:green, 4:blue, 5:cyan, 6:purple, 7: yellow, 8:gray ~~~~

colors()  # col='  '  에 들어갈수있는 종류 657가지.

#눈금 조정.
#y좌표 눈금조정 = ylim,    x좌표 눈금조정 = xlim. yaxt='n' y축눈금 삭제. xaxt ='n' x축 눈금 삭제. 
#bty => ("O", "L", "7", "c", "u", "]") 이렇게 많은 모양들이 있다. n 을 넣으면 그래프 박스가 사라진다.
#ylab ='' => '' 값에 아무것도 안넣으면 y라벨의 이름이 사라진다.
plot(x, y1, pch=0, type='b', col='red', ylim= c(-8,2), yaxt='n', bty='n', ylab='')
#side : 1.하 2.좌 3.상 .4.우 ,  at= 위치 <-(어디에 그릴껀지.)
?axis
axis(side=2, at=c(-2,0,2))  #고수준 그래프를 뛰운상태에서 실행시켜야한다. 눈금표시.

#red lien(y1) 을 2.좌에 line = 2 만큼 떨어져서 at = 0 y1눈금중 0위에 위치. , 글자색 red.
mtext('red line(y1)', side = 2, line = 2, at=0, col=2)

#고수준 그래프영역중 기존영역을 지우지 않고 덮어서 그려짐.
par(new = TRUE)
plot(x, y2, pch=1, type = 'b', col='blue', yaxt='n', ylim= c(98,108), ylab = '', bty='n')

axis(side=4, at=c(98,100,102))
mtext('blue line(y2)', side = 4, line= 2, at=100, col='blue')

par(oldPar) #그래프 영역 설정 원상 복구.


#2. 고수준 그래프 함수.
#2.1 plot : type에 따라 여러 유형의 그래프를 그림 => 산점도 그래프 함수.
?plot
#las = 축 눈금라벨 방향. 0= 축과 평행, 1=가로, 2= 축과 수직, 3=세로
plot(cars, main='speed and stopping Distance of cars', xlab='speed(mph)', ylab='stopping distances(ft)',
     las=1)

# 2행 3열로 그래프영역분리하고, type 속성에 따른 그래프 그리기
oldPar <- par(mfrow= c(2,3)) #한번만.
plot(cars, type='p', main='p타입') #산점도
plot(cars, type='l', main='l타입') #추세선
plot(cars, type='b', main='b타입') # p타입+l타입 (겹치지 않게.)
#plot(cars, type='c', main='c타입') #
plot(cars, type='s', main='s타입') #계단타입
plot(cars, type='n', main='n타입') #안 그려짐.
plot(cars, type='o', main='o타입') #선과 점 겹치게.
par(oldPar) #원상 복귀 확인법은 이 문장을 실행 시키고 위에 아무 그래프 하나 실행 시키면 확인 가능.


#2.2 barplot : 막대 그래프.
head(VADeaths)
VADeaths
#main = 그래프 제목,  legend= 오른쪽 상단 상자. : 범례. , angle= 막대그래프에 칠할 빗금의 각도
barplot(VADeaths, main='버지니아주 사망율', font=2,   #density = 막대그래프안에 칠할 선의 갯수
        border='red', legend= row.names(VADeaths),
        angle= c(10,30,50,70,120),
        density=50,col=rainbow(5))

#beside = TRUE 의 그래프.
barplot(VADeaths, main='버지니아주 사망율', font=2, 
        border='red', legend= row.names(VADeaths),
        angle= c(10,30,50,70,120),
        density=50,col=rainbow(5), beside=TRUE)




#2.3 boxplot = 사분위 그래프.
InsectSprays
boxplot(InsectSprays$count)
boxplot(count~spray, data=InsectSprays, col=cm.colors(6))
#tapply(InsectSprays$count, InsectSprays$spray, median) 이 문장보다 그래프가 가독성이 더 높다.




#2.4 hist = 히스토그램.(도수분포표)
x <- c(1 ,1 ,2 ,2 ,2 ,3 ,4 ,4)
hist(x)
h <- hist(x, breaks = c(0,1,2,3,4))
#breaks = 구간.
h

text(h$mids, h$counts, h$counts, adj= c(0,0), col = 'red')
#adj 글자 위치 조정.
text(h$mids, h$counts, h$counts, adj= c(1,0), col = 'blue') # 가운데를 기점으로 왼쪽1
text(h$mids, h$counts, h$counts, adj= c(0,1), col = 'green')
text(h$mids, h$counts, h$counts, adj= c(1,1), col = 'black')
text(h$mids, h$counts, h$counts, adj= c(0,-.5), col = 'purple') # -0.5 <=> -.5 가능. 


islands #1만 평방마일을 주요 대륙 넓이 정보.
class(islands) # numeric 타입.
is.vector(islands) #벡터타입.
hist(islands)
hist(sqrt(islands), breaks = c(2,35,70,100,140)) #극한치를 줄여준다. sqrt = 루트값.




#2.5 pie .
pie.sales <- c(0.1,0.3,0.2,0.15,0.1,0.15)
sum(pie.sales)
#전체르 1로 맞춘다.
names(pie.sales) <- c('c','java','python','R','oracle','hadoop')
pie.sales
#col= 값을 안주면 기본 값이 들어간다. + 반시계방향으로 데이터값 자리가 잡힌다.
pie(pie.sales, clockwise = T, col=c('red','orange','green','white','cornsilk','yellow')) #1시 부터 시계방향.
#col= 값을 줄때 데이터 수 보다 적은 값을 주면 그 색상을 반복해서 다 채운다.
pie(pie.sales, clockwise = T, col=rainbow(6))


#2.6 mosaicplot -> 그렇게 많이 쓰이지는 않는다.
#dataset 에 있는 Titanic
Titanic
class(Titanic) #데이터테이블 형태와 테이블 형태와 다르다.


mosaicplot(Titanic , color = T)
mosaicplot(~Sex+Age+Survived, data=Titanic, color=T)



#3. 저수준 그래프 함수
#3.1 point 
plot(-4:4, -4:4, type='n')
points(rnorm(100),rnorm(100),col='brown',pch=3) #x,y 축 들이 있어야 그려진다. 난수라서 랜덤으로 점이 찍힘.
rnorm(100)  # 평균이 0이고 표준편차가 1인 표준정규분포 데이터 100개 난수 생성.


#3.2 lines : 선.
plot(cars, main='speed & dostance')
#회귀식을 만들어보려고 한다.
fit <- lm(dist~speed, cars)
fit #y = 3.932*x - 17.579(y절편.) 실측데이터 기준으로 해야함.
lines(cars$speed, 3.932*cars$speed-17.579, col='blue')

#3.3 abline : 회귀식 선.
abline(fit, col='red', lty='dashed')
?par #에서 lty 확인 할수있음.
#lty = line 의 스타일.  "blank", "solid", "dashed", "dotted", "dotdash", "longdash" ... ~


# 3.4 text(x, y, [출력할 text], [그외 옵션들.])
plot(1:5,1:5, type='n')
text(3,3, 'A',adj=c(0,0), col='red') #3,3 위치에 A라는 글자 , adj위치에 따라 생기고 색은 red.
text(2,4, expression(hat(beta) == (X^t*X)^{-1} * X^t*y), cex=2, adj=c(0,0),)


#4. ggplot2 패키지 함수.
install.packages("ggplot2")
library(ggplot2)
#1단계.  그래프 초기화.(데이터셋, 변수설정) ggplot . 그 자체로는 그래프 표현x.
ggplot(data=mtcars, aes(x=wt, y=mpg))

#2단계.  그래프의 결과물에 대응하는 geom 함수.
ggplot(data=mtcars, aes(x=wt, y=mpg)) + 
  geom_point()

#3단계.  그래프의 제목,부제목, 캡션, 축이름 등 부가 요소를 추가. =labs함수
# + 기호를 이용해서 함수들을 연결하는 방식으로 그래프  생성.
ggplot(data=mtcars, aes(x=wt, y=mpg)) +  # aes 가 geom_point() 안에 계속 계승이 된다.
  geom_point()+
  labs(title = 'wt & Fuel consumption',
       x = 'weight(1,000lbs)',
       y = 'Fuel consumption (miles per gallon)',
       subtitle = '(차량 무게와 연비와의 관계)',
       caption = 'source : mpg datasets')

#=====조정.

ggplot(data=mtcars, aes(x=wt, y=mpg)) +  # aes 가 geom_point() 안에 계속 계승이 된다.
  geom_point(aes(size=mpg, color=cyl))+
  labs(title = 'wt & Fuel consumption',
       x = 'weight(1,000lbs)',
       y = 'Fuel consumption (miles per gallon)',
       subtitle = '(차량 무게와 연비와의 관계)',
       caption = 'source : mpg datasets')



#예제.
# x : iris$Petal.Length, y : iris$Petal.width의 산점도
#점의 색상은 종에 따라서 다르게 그리시오.
ggplot(data=iris, aes(x=iris$Petal.Length, y=iris$Petal.Width)) +
  geom_point(aes(color=iris$Species))
#scale함수.
ggplot(data=iris, aes(x=iris$Petal.Length, y=iris$Petal.Width)) +
  geom_point(aes(color=iris$Species)) +
  scale_color_manual(values = c('black','red','orange')) +
  labs(title = "iris 데이터의 산점도",
       x = "꽃잎 길이", y = "꽃잎 너비") +
  coord_cartesian(ylim = c(0,2)) + #전체를 표시하는게 아니라 특정구간만 표시하게.
  geom_smooth() #추세선.


#geom_smooth() understands the following aesthetics (required aesthetics are in bold): -> aes 가 계속 계승이 된다.
# 태양복사량이 증가하면 오존량도 증가하나?
head(airquality)
#airquality$Ozone 과 airquality$Solar.R의 관계를 표현하는 산점도
# 월별로 점의 색상을 달리 표현해라. #x= Ozone, y= Solar.R 가능.
ggplot(data=airquality, aes(x= airquality$Ozone, y= airquality$Solar.R))+
  geom_point(aes(color=airquality$Month))+ #=> Removed 42 rows containing missing values (geom_point).결측치 빼고 나타난다. 
  labs(title= '오존량과 태양복사량과의 관계')+  #geom_point(aes(color=Month)) 가능.
  geom_smooth(method ='lm') #geom_smooth() -> 적합도선.

?geom_smooth
#geom_smooth(method ='lm') 회귀식 인데 그래프를 보면 알겠지만 적합하지 않다.



#예제2 #style = par에서 pch 와 같음.
#4.1 선점도, 적합도, text ..~
ggplot(data=mtcars, aes(x=wt, y=mpg)) + #초기화
  geom_point(pch = 25, color='blue', bg='red', size=2, stroke=2) + #선점도
  geom_smooth(method = 'lm', color='red', size=2, linetype=2) + #적합도
  geom_text(label=rownames(mtcars), hjust=0, vjust=0, size=3, nudge_y = 0.5)+ #text.
  labs(x= '차량무게(1.000lbs)',
       y= '연비',
       title='차량무게와 연비와의 관계',
       subtitle='부제목',
       caption= '참조:datasets의 mtcars')
#`geom_smooth()` using formula 'y ~ x' 지정을 안해줘서 대충 알아서 나타난다.
#회색구간 = 신뢰구간.  geom_smooth(method='lm') 직선으로 바뀜.(회귀식.)
#shape = par에서 pch 와 같음.
# pch = 21~25 은 배경색 바꿀수 있음. # ?color() = 색상의 종류들. #stroke = 테두리 굵기. #size = 크기
?par
?geom_smooth #안에 linetype 있으니 한번 봐보자.
?geom_text

#4.2 히스토그램. 팩터변수만 가능.
head(mtcars)
dim(mtcars)#차원
str(mtcars)#구조
mtcars$cyl <- factor(mtcars$cyl, levels = c(4,6,8), #cyl 를 factor 변수로 변환.
                     labels = c('4 cylinders',
                                '6 cylinders',
                                '8 cylinders'))
#팩터 변수로 바뀌었는지 확인.
head(mtcars)
str(mtcars)

#`stat_bin()` using `bins = 30`. Pick better value with `binwidth`. 너무많아서 에러.
ggplot(data= mtcars, aes(x= mpg)) + #초기화함.
  geom_histogram() +
  facet_grid(cyl~.)+   #=> 3개의 패널에 그리는 함수.  #실린더별로 그룹화.
  labs(title = 'cyl에 따른 연비 히스토그램',
       x= '연비', y= '횟수')
#mpg는 연속성(팩터변수가 아니라서). 범주형은 팩터변수.



#히스토그램은 연속형 자료형에서 도수분포표 (범주형의 도수분포는 불가)
ggplot(data = mtcars, aes(x=cyl)) +
  geom_histogram()
#범주형이라 안됀다. 그이유는 cyl 의 데이터는 연속성이 아니고 범주형(팩터변수)라서 이다.
#원래는 아니였는데 팩터변수로 변환했기때문.
ggplot(data = mtcars, aes(x=cyl)) +
  geom_bar() #범주형은 bar 그래프에서 가능.


#ggplot2::mpg 데이터셋에서 displ 도수분포표. (class 에 따라 그래프의 생상을 달리 표현.)
?geom_histogram
str(mpg$displ) #연속성인지 범주형인지 확인.
ggplot(mpg, aes(x = displ)) + #data= 생략가능.
  geom_histogram(aes(fill = class)) + #aes=displ 가 상속되어서 내려오니 안써도 되는데 위에 없으면 아래에서는 무조건 넣어야한다.
  theme(axis.text.x = element_text(color = 'red', size = 15),  #x축 2,4,6 색상을 red로, 폰트 크기 조정.
        axis.line = element_line(color = 'black', size = 2),  #x,y축들의 선의 색상과 굵기 조정.
        axis.text.y = element_blank(),  #y축의 숫자 표시값을 안보이게
        panel.background = element_rect(fill = 'lightblue',
                                        linetype = 'dotted', color = 'black'),  #그래프의 배경색과 테두리선을 dotted로, 색상은 블랙.
        plot.background = element_rect(fill = 'lightgreen')) #plot 의 배경색 조정.



ggplot(mpg, aes(x= displ)) +                      #binwidth(변의넓이) = 0.1  : 10%정도로 막대들 사이가 떨어진다.
  geom_histogram(aes(fill=class), binwidth = 0.1) + #fill='red' 를 하고싶으면 aes밖에 빼야함 geom_histogram(fill='red')
  labs(title = "Histogram with Auto Bining",
       subtitle = "(Engine Displacement across Vehicle Classes)") +
  theme(legend.position = "bottom") #top , left, right, bottom 가능.


ggplot(mpg, aes(x=displ)) +
  geom_histogram(aes(fill = class),                #bins 막대 갯수.
                     bins=5, color = "black")    #bins aes함수 밖에. 빈의 갯수 지정.(지정하지않으면 기본값 : 30개)
                               #binwidth를 지정하면 bins는 무시. 



#4.3 상자도표 (ggplot)
ggplot(iris, aes(y = Sepal.Length)) +
  geom_boxplot() # geom_boxplot.

boxplot(iris$Sepal.Length)$stat #boxplot.
#$stat 4.3보다 작은값, 7.9보다 큰값=>(이상치) 를 처리를 할지 말지 확인후 해결.


#종별로 Sepal.Length의 차이가 있는지를 보고 싶을때
tapply(iris$Sepal.Length, iris$Species, mean) #도표 표현.
ggplot(iris, aes(y=Sepal.Length, x=Species)) + #시각화 표현. 
  geom_boxplot(aes(fill=Species), col="dimgray") +
                 scale_fill_manual(values =c("red","yellow","blue"))   # #ff0000 인 rgb값, 특정 파레트값 넣어도 된다.

library(RColorBrewer)
display.brewer.all()
pal <- brewer.pal(8,'Set2') #색상 갯수 8개. Set2 가 들어간다. 대소문자, 스펠링 조심.
ggplot(iris, aes(y= Sepal.Length, x=Species)) +
  geom_boxplot(aes(fill=Species), col='dimgray') +
  scale_fill_manual(values = pal)

install.packages("gapminder")
library(gapminder)
table(gapminder$country)
dim(gapminder) #gapminder : 대륙별, 나라별, 인구와 GDP 데이터.

#대륙별로 gdp 차이가 있는지
str(gapminder)
table(gapminder$continent)

ggplot(gapminder, aes(x = continent, y= gdpPercap)) +
  geom_boxplot(aes(fill=continent)) +
  coord_cartesian(ylim = c(0, 30000))

#교수의 직급별(조교수, 부교수, 정교수) 연봉이 상의한지 확인.
install.packages("car")
library(car)
Salaries
dim(Salaries)
colnames(Salaries)


ggplot(Salaries, aes(x=rank, y=salary)) +
  geom_boxplot(aes(col=rank), fill = "lightyellow", notch = T) + # notch = T : 중위수에 대해서 95%신뢰구간이 나온다. #신뢰구간이 겹치는지 파악.
  geom_point(position = "jitter",col= 'blue', alpha= 0.3, pch=3) + #먼저 부른 도표에 따라 표시위치가 다르다. 한마디로 boxplot 을 위에 두고싶으면 나중에 선언.
  geom_rug(col='dimgray', sides="r")  #sides = "r" 오른쪽. 이걸 안쓰면 기본값인 왼쪽에.
#geom_rug = 관측값의 밀도 상태표현. 데이터가 많은곳은 조밀조밀, 적은곳은 뜨문뜨문.
#alpha 투명도.
#position = "jitter" : 산점도를 분산해서.


#mtcars 데이터 cyl 개수에 따른 연비 mpg의 95% 중위수 신뢰구간을 표현한 상자도표를 시각화 하시오.
?mtcars #어느 데이터에 있는지 확인.
head(mtcars)
str(mtcars$cyl) #cyl 의 변수 확인.

ggplot(data=mtcars, aes(y=cyl, x=mpg, fill=cyl)) + #x,y 축의 선언 순서를 달리해서 표현 가능.
  geom_boxplot(notch = T)


#4.4 바이올린 도표 : boxplot과 밀도도표를 합쳐놓은 느낌.
#합창부 단원의 키와 성악부part의 관계

singer <- lattice::singer
head(singer)
View(singer)
str(singer) #voice.part 가 팩트변수로 확인되어있다.

ggplot(data = singer, aes(x=voice.part, y=height)) +
  geom_boxplot()

ggplot(data = singer, aes(x=voice.part, y=height)) +
  geom_violin(fill="honeydew2") +
  geom_boxplot(width = 0.3 , fill = "green")


#4.5 밀도 도표.
head(mtcars,1)
#실린더 수 (cyl)에 따른 연비(mpg)의 밀도도표.
ggplot(mtcars, aes(x= mpg, fill= cyl))+  #채워져야 하니 y대신 fill.
  geom_density()+
  labs(title = "밀도도표",
       x= "Miles per Gallon") +
  theme(legend.position = c(0.8,0.8)) #도표의 0 ~ 도표우상단을 1 로 기준으로 해서 도표안에다 넣을수 있다.


#4.6 추세선 (시계열에서 데이터의 흐림 표현.)

economics
colnames(economics)
#시간(date)에 따른 실업률(unemploy)
ggplot(data = economics, aes(x=date, y=unemploy)) +
  geom_line() +  #추세선.
  geom_smooth(method = "lm")  #적합도선 (method = "lm") 직선으로 표현.



#4.7 막대도표 (geom_bar함수,  geom_col함수)
#도수분포표 : 막대도표, 히스토그램 모두.
 #히스토그램 : 연속형 자료를 계급으로 나누너 계급별 도수를 나타냄.
              #geom_histogram()
 #막대그래프 : 범주형 자료의 빈도를 나타냄.
              #geom_bar() , geom_col()


#mpg 데이터셋에서 manufacturer(제조사) 별로 빈도표를 나타내고자 한다
str(mpg$manufacturer) #char. 캐릭터 라서 범주형.

ggplot(mpg , aes(x = manufacturer)) + 
  geom_bar() #geom_histogram() => 불가능.

ggplot(mpg, aes(x= manufacturer)) +
  geom_bar(stat = 'count') #stat = 'count' 생략가능. x축의 빈도를 시각화.

str(mpg$class)

ggplot(data = mpg, aes(x = manufacturer, fill = class))+
  geom_bar() +
  theme(legend.position = "top",
        axis.text.x = element_text(angle=60, vjust = 0.5)) +  #angle 기울기 = 45 . 45도. #vjust 0. 제일 아래,  1= 상단.  x의 이름 위치 조정.
        scale_fill_manual(values = topo.colors(10)) + #scale_fill_manual 은 class의 최소 갯수 이상으로 써야함.
        labs(title="제조사 별 class 빈도표")



#다이아몬드 품질별 데이터.
?diamonds
head(diamonds)
str(diamonds)
dim(diamonds)
table(diamonds$cut)

#geom_bar 사용.  다이아몬드 품질(cut)별 반도수 시각화

ggplot(diamonds, aes(x=cut, fill = cut,col=cut)) +
  geom_bar(stat="count") + #,stat="count" 생략 가능.
  scale_fill_manual(values = topo.colors(5)) +
  scale_color_manual(values = rainbow(5))


#다이아몬드 품질별 색상 갯수.
table(diamonds$cut, diamonds$color)
table(diamonds$color)

library(dplyr)
x <- diamonds %>% 
  group_by(cut, color) %>% 
  summarise(n = n() )

class(x) #  "grouped_df" "tbl_df"     "tbl"        "data.frame"

#cut 별로 한번에 그래프로 시각화.

diamonds %>% 
  group_by(cut, color) %>% 
  summarise(n = n() ) %>% 
  ggplot(aes(x= cut, fill = color, y=n)) +
  geom_bar(stat = "identity") #y 값이 있으면 stat = "identity" 기입.

?geom_bar


diamonds %>% 
  group_by(cut, color) %>% 
  summarise(n = n() ) %>% 
  ggplot(aes(x= cut, fill = color, y=n)) +
  geom_col() # geom_col() <==> geom_bar(stat = "identity") 서로 같다.
 

#cut별, color별 막대그래프.
diamonds %>% 
  group_by(cut, color) %>% 
  summarise(n = n() ) %>% 
  ggplot(aes(x= cut, fill = color, y=n)) +
  geom_bar(stat = "identity", position = 'dodge') # , position = 'dodge'

diamonds %>% 
  group_by(cut, color) %>% 
  summarise(n = n() ) %>% 
  ggplot(aes(x= cut, fill = color, y=n)) +
  geom_col(position = 'dodge')
#다이아몬드의 품질별, table 별 빈도수 시각화.
diamonds %>% 
  group_by(cut, table) %>% 
  summarise(n =n()) %>% 
  ggplot(aes(x = cut, y= n, fill=table)) +
  geom_bar(stat = "identity") +
  facet_wrap(~cut) #cut별로 시각화를 달리그림림

#============================================ 
diamonds %>%  #가독성이 너무 안좋다.
  group_by(cut, table) %>% 
  summarise(n =n()) %>% 
  ggplot(aes(x = table, y= n)) +
  geom_bar(stat = "identity") +
  facet_wrap(~cut) + 
  coord_cartesian(ylim =c(0, 3000) , xlim=c(50,80))




#다이아몬드 품질(cut)별 table 의 종류 갯수
length(table(diamonds$table)) #table 종류는 127
#pc를 껐다면 밑에 두개를 실행시켜서 로드시킨다.
library(ggplot2)
library(dplyr)

diamonds %>% 
  group_by(cut, table) %>% 
  summarise(n = n()) %>% 
  group_by(cut) %>% 
  summarise(n = n()) %>% 
  ggplot(aes(x = cut, y=n , fill = cut)) +
  #geom_bar(stat = "identity")
  geom_col()  


diamonds %>% 
  group_by(cut) %>% 
  summarise(n = n_distinct(table)) %>%  #cut별 table 종류 갯수
  ggplot(aes(x = cut, y=n , fill = cut)) +
  #geom_bar(stat = "identity")
  geom_col()            


#4.8 그래프를 파일에 저장.
#(1) basic 그래프, ggplot2 그래프 모두 저장.
jpeg('iris.jpg') #iris.jpg 그림파일 생성성
boxplot(iris$Sepal.Length)
dev.off()
getwd() #저장소.

png('iris.png', width = 300, height = 150)
ggplot(iris, aes(x= Sepal.Length, y= Sepal.Width)) +
  geom_point()+
  facet_wrap(~Species)
dev.off()


#(2) ggplot2 그래프에서만 저장할 수 있는 방법.
ggplot(iris, aes(x= Petal.Width, y= Petal.Length, col=Species)) +
  geom_point(aes(size= Petal.Width), pch = 3, alpha=0.5) 
ggsave("outData/iris.jpg")




#4.9 차트 분할 출력.
install.packages("gridExtra")
library(gridExtra)
#oldPar <- par(mfrow= c(2,3)) #한번만.
g1 <- ggplot(iris, aes(x= Petal.Width, y= Petal.Length, col=Species)) +
  geom_point() 
g1

g2 <- ggplot(iris, aes(x= Sepal.Width, y= Sepal.Length, col=Species)) +
  geom_point() 
g2


grid.arrange(g1,g2, ncol=2)


#5. 산점도 행렬
plot(iris[-5])
pairs(iris[-5], panel = panel.smooth) #panel = panel.smooth 추세선 추가.



