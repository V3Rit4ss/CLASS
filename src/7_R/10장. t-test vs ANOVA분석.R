# # # 10장. t-test 분석 vs ANOVA 분석 # # #

# 두 그룹간 평군의 차이가 통계적으로 유의한지 검증 : t-test 분석.
# 세그룹 이상 집단의 평균차이가 유의한지 검증 : ANOVA분석 (분산분석)
# (샘플이 완전할때 하는.  샘플갯수는 300개 이상 있어야 테스트 가능.)

#1. 두 그룹간의 평균의 차이가 유의한지 분석.
ToothGrowth
table(ToothGrowth$supp)
#(1) 도표로 차이의 유의성 표현.(tapply, by, summaryBy, aggregate ... , +[평균,분산])
#(2) 그래프로 시각화된 유의성 표현.(바이올린표, 산점도, 상자도표)
#(3) 통계적으로 유의한지 검증.
#위 3가지를 다해야한다.


###(목표)비타민의 종류가 기니피그 치아 성장에 영향을 미치는지?
#정확한 검증치를 알기위해 데이터갯수를 늘린다.
ToothGrowth <- rbind(ToothGrowth, ToothGrowth) #3번 실행시켜 400행이상으로 데이터를 늘린다.
nrow(ToothGrowth)
table(is.na(ToothGrowth)) #결측치가 없다. boxplot 으로 이상치 를 먼저 확인.
colSums(is.na(ToothGrowth))
#(1)
library(doBy)
summaryBy(len~supp, data=ToothGrowth, FUN= c(mean,sd))
library(dplyr)
ToothGrowth %>%
  #fillter(!is.na(supp) & !is.na(len)) %>%  # 결측치가 있다면.
  group_by(supp) %>% 
  summarise(len.mean = mean(len),
            len.sd = sd(len))

#(2) 시각화.
ToothGrowth %>%
  #fillter(!is.na(supp) & !is.na(len)) %>%  # 결측치가 있다면.
  group_by(supp) %>% 
  summarise(len.mean = mean(len)) %>% 
  ggplot(aes(x=supp, y=len.mean)) + 
  geom_col(aes(fill=supp),width = 0.7)

ggplot(data=ToothGrowth, aes(x=supp, y=len))+
  geom_violin()+
  geom_point(position = 'jitter', col='yellow', alpha=0.5) +
  geom_boxplot(aes(fill = supp), notch = T, width=0.4)



#(3) 두 그룹 : t-test .    두그룹 이상이면 ANOVA.
#통계적인 분석.
# 일원표본 t.test 
table(ToothGrowth$supp, useNA = "ifany") #결측치 빈도까지 출력.
table(ToothGrowth$supp, exclude = NULL) #결측치 빈도까지 출력.
a <- ToothGrowth[ToothGrowth$supp == 'OJ','len']
b <- ToothGrowth[ToothGrowth$supp=='VC','len']

t.test(a-b)
t.test(a,b)
#p-value 가 0.05보다 작은 경우, 귀무가설(=두 그룹의 평군이 같다.)을 기각한다.
# => 두 그룹이 다르다.

#p-value 가 0.05보다 큰 경우 귀무가설을 기각하지 못한다.
# => 두 그룹이 다르지는 않다.



#이원표본 t.test (순서 : (1)등분산성 테스트 -> (2)t.test분석)
var.test(len~ supp, data = ToothGrowth) #p-value가 0.05보다 작은 경우,
#귀무가설(두 그룹의 분산이 같다.) 을 기각한다. -> 등분산성이 성립하지 못한다.

#p-value가 0.05보다 큰 경우, 귀무가설을 기각하지 못한다. -> 등분산성이 성립한다.

#---- 등분산성 테스트 완료.

t.test(len~supp, data=ToothGrowth,var.equal=F)
#var.equal=F => 두 그룹의 등분산성이 성립되지 않는 경우.
#var.equal=T => 드 그룹의 등분산성이 성립된 경우.

#p-value 가 0.05보다 작은 경우 귀무가설을 기각.
#p-value 가 0.05보다 큰 경우 귀무가설을 기각못함..




#rm(list=ls()) 해서 원 데이터(60개)로 하면 p-value값이 0.05보다 크다.




# 예제 : dataset:sleep => extra(수면량) , group(수면제종류),
#수면제 group에 따라 수면량의 변화가 있는지 분석하라.
sleep <- rbind(sleep, sleep) #원본 데이터량 보다 늘림.
nrow(sleep)
head(sleep)
str(sleep)
table(sleep$group, useNA = 'ifany')


#(1) 도표로 평균차이 나타내기

sleep %>% 
  filter(!is.na(extra) & !is.na(group)) %>% 
  group_by(group) %>% 
  summarise(extra.mean = mean(extra),
            extra.sd = sd(extra))
#=======================================
library(doBy)
summaryBy(extra~group, data=sleep, FUN=c(mean, sd))
library(dplyr)
sleep %>% 
  group_by(group) %>% 
  summarise(mean = mean(extra),
            sd = sd(extra))




#(2) 평균,표본의 차이를 시각화 하기.

ggplot(sleep, aes(x= group, y=extra))+
  geom_violin()+
  geom_point(position = 'jitter', col='lightgreen')+
  geom_boxplot(aes(fill = group), notch = T, width=0.3)
  


#======================

result <- summaryBy(extra~group, data=sleep, FUN=c(mean, sd))
ggplot(result, aes(x=group, y=extra.mean)) +
  geom_col(aes(fill=group), width=0.7)

ggplot(data=sleep, aes(x=group, y=extra)) +
  geom_point(position = 'jitter', col='yellow', alpha=0.7) +
  geom_violin(width=0.7) +
  geom_boxplot(aes(fill=group), notch = T, width=0.5)


#(3)통계적으로 유의미한 차이를 분석하기.
var.test(extra~group, data=sleep)# p-value가 0.05보다 큼.
t.test(extra~group, data=sleep, var.equal=T)
#p-value가 0.05보다 작아 드 그룹사이의 평균이 같다는 귀무가설을 기각한다.





# 2. 3개 이상의 집단간 평균의 차이를 비교할때는 분산분석(ANOVA).
# (1)aov( )
    #iris 데이터셋에서 종에 따라 Sepal.Length의 평균이 다른지 분석. 
    #종(Speices) = 독립변수 ,  의존변수(종속변수) = Sepal.Length

ggplot(iris, aes(x=Species, y= Sepal.Length))+
  geom_boxplot(aes(fill = Species), notch = T)

# aov(종속변수 ~ 독립변수, data = iris)
result <- aov(Sepal.Length ~ Species, data=iris) #Speices 범주형.
summary(result) # F 값
#F 값이 0.05보다 작으면 귀무가설을 기각.
# F 값이 0.05보다 크면 귀무가설을 기각할수 없다.

#범주형, 연속형 둘다 aov() 쓰인다.



# 사회과학에서는 20% 이상의 값이 나오면 잘나온거라 본다. 자연과학과의 확증 %가 다르다.



# (2)anova( )
  #ggplot2::mtcars 데이터셋에서 cyl에 따라 mpg의 평균이 다른지 분석.
rm(list=ls()) # 원래 변수의 형태로 만듬. factor -> num
str(mtcars$cyl)
table(mtcars$cyl, useNA = 'ifany') #cyl 의 가지수와 결측치 확인. (3개그룹과 결측치가 없다.)
# cyl 에 따른 그룹이 3개그룹이고 cyl 변수 = 연속성 변수이다.

fit <- lm(mpg ~ cyl , data=mtcars) #회귀분석를 가진 상태.
fit # 확인.
anova(fit)
# Pr(>F) => 6.113e-10 이라 0.05 보다 작다.
# F 값이 0.05보다 작으면 귀무가설을 기각.
# F 값이 0.05보다 크면 귀무가설을 기각할수 없다.


### 예제2 : datasets::Orange => 오렌지나무의 종류, 연령, 둘레.
  #오렌지나무의 연령에 따른 둘레의 평균이 상이한지 분석.
#종류 독립,   둘레 종속.
head(Orange)
str(Orange$age)
nrow(Orange)
fit <- lm(circumference ~ age, data=Orange)
anova(fit)









