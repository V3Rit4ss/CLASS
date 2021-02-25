# # # 14장 지도 시각화 # # # 

#1.미국 주별 강력 범죄율 시각화.(datasets::USArrests 이용.)
View(datasets::USArrests) # 행 이름이 미국의 주 이름으로 되어있다.
View(iris) # 행 이름은 번호로 되어있음.

#(1) 패키지 준비.
install.packages("ggiraphExtra") # 지도시각화를 위한 패키지.
library(ggiraphExtra)
install.packages("mapproj") #ggChoropleth 함수 사용을 위한 패키지지
library(mapproj)
install.packages("maps") # map_data함수를 통해 지도 정보 이용
library(maps)
library(ggplot2)
library(tibble) # 행이름(지역명)을 변수로 하기위한 작업. 

#(2) 행이름을 변수로
head(USArrests,1)
crime <- rownames_to_column(USArrests, var='state')
class(crime)
head(crime,3)
crime$state <- tolower(crime$state) #주 명을 모두 소문자로 .
head(crime,5)

#(3) 미국지도 주 정보 가져오기
View(map_data('state'))
state_map <- map_data('state')

#(4) 지도 시각화
ggChoropleth(data=crime, #지도에 표현할 데이터
             aes(fill = Murder, #지도에 채워질 변수 
                 map_id=state), #지역변수
             map=state_map, #위도 경도 지도 데이터
             interactive = T ) # 인터렉티브 속성 지도에 마우스를 가져다대면 특정위치의 정보가 보인다.




#2. 대한민국 시도별 인구, 결핵 환자 수 단계 구분도 만들기

rm(list = ls())
install.packages("stringi")
install.packages("devtools")
library(devtools)
devtools::install_github("cardiomoon/kormaps2014")
library(kormaps2014)
head(korpop1)
#korpop1 = 2015년 센서스 데이터(시도별)
#korpop2 = 2015년 센서스 데이터(시군구별)
#korpop3 = 2015년 센서스 데이터(읍면동별)

str(changeCode(korpop1)) #UTF-8로 인코딩된 데이터를 CP949로 변환후 출력
library(dplyr)
korpop1 <- rename(korpop1, pop= 총인구_명,
                  name = 행정구역별_읍면동)
str(changeCode(korpop1))

head(kormap1) # name 의 한글이 깨짐. utf-8로 되어있음
head((changeCode(kormap1))) #name1 의 한글이 깨짐. CP949로 되어있음
head(changeCode(korpop1[,c('name','pop','code')]))

ggiraphExtra::ggChoropleth(data=korpop1,
                           aes(fill = pop, map_id=code, tooltip=name),
                           map=kormap1,interactive = T)


#korpop1$name => UTF-8을 CP949로 변환
korpop1$name <- iconv(korpop1$name, 'UTF-8','CP949')


#결핵환자수 지도 시각화
head(tbc)
head(changeCode(tbc))
tbc$name1 <- iconv(tbc$name1, 'UTF-8', 'CP949') #한글 깨지는거 복구.
tbc$name <- iconv(tbc$name, 'UTF-8','CP949')
head(tbc) #확인.


ggChoropleth(data = tbc, aes(fill = NewPts, map_id=code, tooltip=name1), #tooltip=name1 은 강원, tooltip=name 은 강원도로.
             map=kormap1, interactive = T)

#한국 행정지도(2014) 패키지 kormaps2014 안내.
# https://rpubs.com/cardiomoon/222145











































