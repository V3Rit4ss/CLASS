# # # 7장. 데이터 처리성능 향상 # # #

# 7장의 내용 : [1]plyr 패키지 (apply 계열), [2]데이터 구조 변경(melt, cast= 자주 쓰는 함수), [3]데이터테이블
iris[iris$Sepal.Length>7.5 & iris$Petal.Length>5,]
#detach("package:dplyr", unload= T) 혹시 모를 퉁돌 예방.
# 1. plyr 패키지 : 데이터 분할, 함수 적용등을 사용하는 함수 포함.
# apply(), lapply(), sapply() 들은 보강 할 수 있다.
install.packages("plyr")
library(plyr) # 메모리 억세스.
#xyplyr(.data, group ...)  #ex. adply= array로 받아서 df로, ddply= df로 받아서 df로. ~~~


apply(iris[,1:4],2 , mean) #mean(iris[,1])
apply(iris[,1:4], 2, function(col){mean(col)})
 
sapply(iris[,1:4], mean)  # function(col){mean(round(col))} 대신 mean 해도 된다.
sapply(iris[,1:4], function(col){mean(col)})
sapply(iris[,1:4], mean(round)) # 이것이 안돼서 두번째 예시처럼 function 으로 했다.

x <- data.frame(v1 = c(4,9,16),   #2 , 3 ,4 의 평균
                v2 = c(16,81,196))  #4, 9, 14 의 평균 들을 구할것이다.
x
apply(x, 2, function(col){mean(sqrt(col) ) }) #sqrt 는 제곱근 구할때 하지만, sqrt 끼리 계산해서 function 을 사용한다.
#adply에레이,리스트 형태로 받아서. == apply(iris[1:4], 2, sum), sapply() ... 비슷.
?adply 
adply(.data=iris[,1:4], margins=2, function(col){sum(col)})



#ddply == summaryBy(Sepal.Length+Sepal.Width~Species, iris, FUN=mean) 비슷.
ddply(.data=iris, .(Species), function(group){
  data.frame(SL.mean = mean(group$Sepal.Length),
             SWmean = mean(group$Sepal.Width))
})

#summarise, = 4가지 정도 쓴다. = 뒤에 나오는 변수들만 출력.
#transform ~ = 기존에 iris 데이터와 뒤에 나오는 변수들을 같이 출력.
ddply(iris, .(Species), summarise, SLmean=mean(Sepal.Length),SWmean = mean(Sepal.Width))

ddply(iris, .(Species), transform, SLmean=mean(Sepal.Length),SWmean = mean(Sepal.Width))

head(iris)


dfx <- data.frame(group =c(rep('A',8),rep('B',15),rep('C',6)),
                  gender = sample(c('M','F'), size =29, replace =TRUE),#복원추출
                  age = round(runif(29, min=18, max=54)) )
dfx

runif(29) #29번 난수 발생. 
round(runif(29, min=18, max=54))


ddply(dfx, .(group, gender), summarise, mean = round(mean(age),2), sd=round(sd(age),2))
ddply(dfx, .(group, gender), transform, mean = round(mean(age),2), sd=round(sd(age),2))


library("doBy")
summaryBy(age~ group+gender, dfx, FUN=c(mean,sd))



#2. 데이터 구조 변경 (melt, cast 함수)
View(airquality)
#?airquality
library(reshape2)
install.packages("reshape2")
airquality.melt <- melt(airquality, id= c('Month','Day'), na.rm = TRUE) #결측치 제거.
head(airquality.melt)
View(airquality.melt) # 확인.

airquality[airquality$Month ==5 & airquality$Day == 1,]
subset(airquality, Month == 5 & Day == 1) # 위아래 같음.
#melt 를 통해 바뀐 구조.
airquality.melt[airquality.melt$Month == 5 & airquality.melt$Day == 1,]
subset(airquality.melt, Month == 5 & Day == 5) #결측치 확인됨.

#melt 된 데이터를 원상복구 : dcast vs acast 
airquality.dc <- dcast(airquality.melt, Month+Day~variable) #Month,Day 가 변수로.
head(airquality.dc)


airquality.ac <- acast(airquality.melt, Month+Day~variable) #Month와 Day 가 행이름으로 잡힌다.
head(airquality.ac)
airquality.ac['5_1',]


# 3.데이터 테이블 = 짧고 유연한 구문 사용을 위해 데이터 프레임에서 상속 받음.

flights_df <- read.csv("Data/flights14.csv")
head(flights_df)
class(flights_df)
install.packages("readx1")
library(readx1)
exam <- read_excel("Data/exam.xlsx")
class(exam)

install.packages("data.table") #fread() :csv파일을 데이터테이블로 받는 함수.
library(data.table)
flights <- fread("Data/flights14.csv")
View(flights)
class(flights)


#flights_df (데이터프레임) , flights (데이터테이블)+데이터프레임.
# flights (데이터테이블)+데이터프레임. 도 flights_df 을 이용한 문장 가능.
#데이터테이블의 출력은 =  알아서 몇개만 위에 나오고 중간 생략후 마지막 몇개만 보여준다. 
#데이터프레임의 출력은 = 처음부터 어느정도만 보여주고 나머지는 생략했다고 나온다.  이 둘의 시간차이가 느껴진다.
#1. origin이 JFK이고 month가 5월인 모든 행을 resul에 얻는다
(result <- flights_df[flights_df$origin=='JFK' & flights_df$month==5,]) #or
result <- subset(flights_df, origin=='JFK' & month==5)

#===flights (데이터테이블)+데이터프레임.

result <- flights[origin == 'JFK' & month ==5]  #or
result <- flights[origin == 'JFK' & month ==5,] #& month ==5`,`]   데이터프레임 형식.


#2. 처음 두 행을 resul에 얻는다
result<-flights_df[1:2,]  #or
result <- head(flights_df, 2)


#===flights (데이터테이블)+데이터프레임.
result <- flights[1:2]  #or
result




#3. origin으로 오름차순, desc로 내림차순으로 정렬하여 출력 => 알파벳 순으로 정렬해야한다. 

flights_df[order(flights_df$origin, desc(flights_df$dest)), ]
flights_df[order(flights_df$origin, -flights_df$dest), ]  # dest(목적지)변수는 문자라 이 문장은 불가능
# +) 문자형이라' - ' 앞에 못 붙힌다.


#===flights (데이터테이블)+데이터프레임.
order(flights$origin, -flights$dest)# 이 상태에서의 ' - ' 불가. dest 가 문자형이라 불가능.
flights[order(flights$origin, -flights$dest)] # 이 상태에서의 ' - ' 가능.
# flights[order(origin, -dest)] # flights$ 생략 가능.







#4. arr_delay열만 출력
flights_df[, 'arr_delay']#or    # 벡터 형태로 출력
flights_df[, 'arr_delay', drop=F]#or    # 데이터 프레임 형태로 출력
subset(flights_df, select='arr_delay') # 데이터 프레임 형태로 출력



#===flights (데이터테이블)+데이터프레임.
flights[, arr_delay]#or    # 벡터 형태로 출력 , '' "" 생략 가능. 한열만.
#flights[, c( arr_delay, dep_delay)] # 두열 이상 할때 c() 추가.
subset(flights, select = arr_delay)






#5. year열부터 dep_time열까지 출력
head(flights_df,2) # 찾고자 하는 해당 열 확인.
colnames(flights_df)# 찾고자 하는 해당 열 확인.

flights_df[,1:4]#or
flights_df[,c('year','month','day','dep_time')]#or
flights_df[,c('year':'dep_time')] #데이터 프레임은 이 문장 불가
subset(flights_df, select=c(1:4))#or
subset(flights_df, select = c('year','month','day','dep_time'))#or
subset(flights_df, select = c('year':'dep_time')) #데이터 프레임은 이 문장 불가


#===flights (데이터테이블)+데이터프레임.
flights[, year:dep_time]#or     # '' "" 생략 가능,  : 가능.
subset(flights, select = c(year:dep_time))



#6. year열과 dep_time열 출력
head(flights_df,2) # 찾고자 하는 해당 열 확인.
colnames(flights_df)# 찾고자 하는 해당 열 확인.

flights_df[, c(1,4)] #or
flights_df[, c('year','dep_time')] #or
subset(flights_df, select = c(1,4)) #or
subset(flights_df, select= c('year', 'dep_time'))


#===flights (데이터테이블)+데이터프레임.
flights[,  year,dep_time]#or
flights[,  list(year,dep_time)]#or   # c벡터형으로 나오기때문 list 와 .() 을 많이 쓴다.
flights[   ,  .(year,dep_time)]     #->  '[   ,  ' 모든행 조건없이 다 출력. 
                                    # ->  [   ,  .(year,dep_time)] 해당 열만 출력해.



#7. arr_delay열과 dep_delay열을 출력하되 열이름을 delay_arr과 delay_dep로 변경
temp <- flights_df[,c('arr_delay','dep_delay')]
names(temp) <- c('delay_arr','delay_dep') # 이거나
colnames(temp) <- c('delay_arr','delay_dep') # 저거나 헷갈릴까바 이것만 이렇게 함.
temp



#===flights (데이터테이블)+데이터프레임.
flights[, .(delay_arr = arr_delay,delay_dep = dep_delay)] # flights[, .(B = A, Y = X)] A 를 B 로. X를 Y 로. 이름 변경.




# 8. 지연시간(arr_delay, dep_delay모두 0미만인 비행이 몇 번인지 출력 #0 은 시간 딱 맞게 출발. 음수값은 지연 시간임. 양수값은 빨리오거나 가거나 한 시간.
nrow(flights_df[flights_df$arr_delay<0 & flights_df$dep_delay<0,]) #[이 문제의 조건.]



#===flights (데이터테이블)+데이터프레임.
flights[arr_delay<0 & dep_delay<0, .(cnt = .N)]  #.(변수이름 = .N) 갯수.




# 8-1 지연시간의 합이 0 미만인 비행이 몇번인지 출력
nrow(flights_df[flights_df$arr_delay+flights_df$dep_time <0,])




#===flights (데이터테이블)+데이터프레임.
flights[arr_delay+dep_time <0, .(cnt = .N)]


#9. 6월에 출발 공항이 JFK인 모든 항공편의 도착지연 및 출발지연 시간의 평균을 계산
apply(subset(flights_df, flights_df$origin=='JFK' & flights_df$month==6, select = c('arr_delay', 'dep_delay')), 2, mean)
# or
apply(subset(flights_df, origin=='JFK' & month==6, select = c('arr_delay', 'dep_delay')), 2, mean) 
# subset(flights_df, origin=='JFK' & month==6, select = c('arr_delay', 'dep_delay')) =>  변수로 빼서 하면 더욱더 짧아짐.


#===flights (데이터테이블)+데이터프레임.
flights[origin == 'JFK' & month == 6, .(mean(arr_delay),
                                        mean(dep_delay))] # 변수 이름을 안넣음.






#10. 9번의 결과에 title에 mean_arr, mean_dep로 출력
x <- apply(subset(flights_df, origin=='JFK' & month==6, select = c('arr_delay', 'dep_delay')), 2, mean)
names(x) <- c('mean_arr', 'mean_dep')
x



#===flights (데이터테이블)+데이터프레임. .(출력해야할 열들.)
flights[origin =='JFK' & month == 6, .(mean_arr = mean(arr_delay),
                                       mean_dep = mean(dep_delay))]



#11. JFK 공항의 6월 운항 횟수
nrow(subset(flights_df,origin=='JFK' & month==6))


#===flights (데이터테이블)+데이터프레임.
flights[origin =='JFK' & month == 6, .(.N)] #or
flights[origin =='JFK' & month == 6, .(cnt = .N)] # 변수이름 지정.



#12. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 출력
subset(flights_df, subset = (origin=='JFK' & month == 6 ), select = c('arr_delay','dep_delay'))
subset(flights_df, origin == 'JFK' & month == 6, select = c('arr_delay','dep_delay'))
flights_df[flights_df$origin == 'JFK' & flights_df$month == 6, c('arr_delay','dep_delay')]


#===flights (데이터테이블)+데이터프레임.
flights[origin =="JFK" & month ==6, .(arr_delay,dep_delay)] #or . 을 안쓰면.
flights[origin =="JFK" & month ==6, c(arr_delay,dep_delay)] #or 벡터형으로.
flights[origin =="JFK" & month ==6, list(arr_delay,dep_delay)] #c(), list() 를 쓰면 식을 못쓰니 주의.


#13. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 제외한 모든 열 출력
subset(flights_df, subset = (origin == 'JFK' & month == 6), select = -c(5,7)) #or
subset(flights_df, subset=(origin == 'JFK' & month == 6), select=c(-5,-7)) 
subset(flights_df, subset = (origin == 'JFK' & month == 6), select = -c('arr_delay','dep_delay'))# =>데이터프레임은 불가.



#===flights (데이터테이블)+데이터프레임. #list 앞 - 불가.
flights[origin =='JFK' & month == 6, -c(arr_delay,dep_delay)] #벡터형태. #or
flights[origin =='JFK' & month == 6, -c('arr_delay','dep_delay')] # 데이터프레임 형태.


#14. 출발 공항(origin)별 비행 수 출력 (JFK 81483 LGA 84433 EWR 87400)
table(flights_df$origin)


#===flights (데이터테이블)+데이터프레임.
flights[, .(cnt = .N), by = .(origin)]





#15. 항공사코드(carrier)가 AA에 대해 출발공항별 비행횟수 계산
table(subset(flights_df, carrier == 'AA')$origin)


#===flights (데이터테이블)+데이터프레임.
flights[carrier == 'AA', .(cnt = .N), .(origin)] #14번에서의 by= 생략 가능.



#16. origin, dest별로 비행횟수 출력
table(flights_df$origin, flights_df$dest)


#===flights (데이터테이블)+데이터프레임.
flights[, .(cnt = .N), .(origin,dest)]  #by= 그룹화.



#17. 항공사코드(carrier)가 AA에 대해 origin, dest별로 비행횟수 출력
table(flights_df[flights_df$carrier == 'AA',]$origin, flights_df[flights_df$carrier == 'AA',]$dest) #or
table(subset(flights_df, carrier == 'AA')$origin, subset(flights_df, carrier == 'AA')$dest)



#===flights (데이터테이블)+데이터프레임.
flights[carrier == 'AA', .(cnt = .N), by= .(origin, dest)]




#18. 항공사 코드가 AA에 대해, origin, dest, 월별 평균arr_delay, 평균 dep_delay 출력
library(doBy)
summaryBy(arr_delay+dep_delay~origin+dest+month, subset(flights_df, carrier == 'AA'), FUN=mean)





#===flights (데이터테이블)+데이터프레임.
flights[carrier == 'AA', .(mean_arr = mean(arr_delay),
                           mean_dep = mean(dep_delay)), by= .(origin,dest, month)]



#19. dep_delay>0가 참이거나 거짓, arr_delay>0가 참이거나 거짓인 각각의 비행횟수
table(flights_df$dep_delay>0, flights_df$arr_delay>0)
# (출발 or 도착)딜레이가 있는 , 없는.


#===flights (데이터테이블)+데이터프레임.
flights[, .(cnt = .N ), by= .(dep_delay>0, arr_delay>0)]



#20. Origin==“JFK”에 대해 월별 최대 출발 지연 시간 출력(month로 정렬)
sort(tapply(subset(flights_df, origin == 'JFK')$dep_delay, subset(flights_df,origin == 'JFK')$month, max))




#===flights (데이터테이블)+데이터프레임.#keyby = sort 하면서 정렬.
x <- flights[origin == "JFK", .(max = max(dep_delay)), by=.(month)]
x[order(x$max)]

