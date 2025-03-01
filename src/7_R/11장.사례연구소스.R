# # # 빅데이터 분석 결과 시각화 # # #

# 1.  Koweps_hpc10_2015_beta1.sav 로드하여 변수명 변경.
getwd() # 현 작업 디렉토리.
setwd() # 변경하고 싶은 작업디렉토리 경로.

#0. 패키지 설치및 로드.
install.packages("foreign")
library(foreign) # SPSS 파일 불러오기
library(dplyr)   # 전처리
library(doBy)    # 전처리
library(ggplot2) # 시각화
library(readxl)  # 엑셀 파일





install.packages("foreign") #read.spss() 함수 사용 하려는 목적.
library(foreign)
#[1]한국복지패널데이터’(SPSS, koweps_hpc10_2015_beta5.sav)를 로드한 후, 
#필요한 데이터 변수만을 select하여 변수명을 변경하시오. 
#단 필요한 필드로 성별은 gender, 태어난 연도는 birth, 혼인상태는 marriage, 
#종교는religion, 월평균임금은 income, 직업코드는 code_job, 
#지역코드는 code_region로 필드명을 변경한다.


#(1) 데이터 load.
raw_welfare <- read.spss(file='data/Koweps/Koweps_hpc10_2015_beta1.sav',
                         to.data.frame = T)
#to.data.frame = T 을 안하면 리스트 형식으로 받아옴
#reencode = 'utf-8' 안하고 로드한뒤에 한글이 깨지면 기입.
View(raw_welfare)
welfare <- raw_welfare
dim(welfare)


#(3)필드의 변수명 변경.
welfare <- rename(welfare, gender=h10_g3,birth = h10_g4,marriage=h10_g10,       
                  religion = h10_g11,income = p1002_8aq1,code_job = h10_eco9,    
                  code_region = h10_reg7)

#(2)select
library(ggplot2)
welfare<- welfare %>% 
  select(gender,birth,marriage,religion,code_job,income,code_region)

head(welfare)
View(welfare)
dim(welfare)
table(is.na(welfare)) # F= 95483   T =21165  <-(na인 데이터갯수)
colSums(is.na(welfare)) #변수 별 NA인 데이터갯수
colSums(!is.na(welfare))


library(doBy)
library(dplyr)

#[2]1번 문제의 결과인 data.frame변수를 이용하여 성별에 따른 월급 차이가 있는지를 분석하시오.
#(1)gender 필드 변수의 이상치가 있는지 확인하고 이상치 값 처리를 한다
table(welfare$gender, useNA = 'ifany') # 1과 2 값만 있어서 이상치 없음.

#(2)gender 필드 변수의 결측치를 확인한다
table(is.na(welfare$gender))

#(3)gender의 값이 1은 male로 2는 female로 변경하고 gender의 타입을 factor로 변경한다
str(welfare$gender)
summary(welfare$gender)

welfare$gender <- ifelse(welfare$gender == 1, 'male','female')
welfare$gender
welfare$gender <- as.factor(welfare$gender)
str(welfare$gender)
class(welfare$gender)
table(welfare$gender)
# factor 순서 바꾸려면 아래의 둘 중의 하나
#welfare$gender <- factor(welfare$gender, levels=c('male','female'))



#(4)성별 비율을 도표로 나타내고 그래프로 시각화한다
welfare %>% 
  group_by(gender) %>% 
  summarise(ratio = n()/nrow(welfare)*100) %>% 
  ggplot(aes(x=gender, y=ratio)) +
  geom_col(aes(fill=gender)) +
  labs(title = "남녀 성비") +
  scale_x_discrete(limits=c('female','male')) + # x축 순서 바뀜
  scale_fill_discrete(limits=c('female','male'), labels=c("f", "m")) + # 범례의 텍스트 순서도 바뀜
  theme(legend.position = "bottom", #--> none : legend 사라짐.
        legend.background = element_rect(fill='lightgray'),
        legend.title = element_text(face=3, color='red'))  # face=3 ; 이텍릭


gender.ratio <- welfare %>% 
  group_by(gender) %>% 
  summarise(ratio = n()/nrow(welfare)*100)
gender.ratio
pie(gender.ratio$ratio, 
    labels=paste(gender.ratio$gender, 
                 round(gender.ratio$ratio,1), 
                 '%'), clockwise = T)
ggplot(gender.ratio, aes(x="", y=ratio, fill=gender)) +
  geom_bar(stat = "identity") +
  coord_polar("y")


 #(5) income의 최소값, 1분위수, 중위수, 3분위수, 최대값, 결측치 등을 탐색하고, 
  #boxplot과 월급의 빈도그래프를 시각화한다.
summary(welfare$income) # 결측치까지 나옴
table(is.na(welfare$income))
# 히스토그램을 통해 income의 분포를 본다.
qplot(welfare$income)
qplot(welfare$income, xlim=c(0,1000))
ggplot(data=welfare, aes(income)) +
  geom_histogram() + # 연속적인 자료 income을 계급으로 나누어 계급별 도수분포표를 나타냄냄
  coord_cartesian(xlim = c(0,1000))

#(6) income이 0인 데이터는 이상치로 정하고, 이상치를 결측 처리한다

boxplot(welfare$income)
bp <- boxplot(welfare$income)$stat
bp
table(welfare$income<=bp[1], useNA = "ifany") # 하위 이상치를 벗어난 값
table(welfare$income > bp[5],exclude = NULL) # 상위 이상치를 벗어난 값이 5%이상의 값이여서 상위 이상치는 이상치 처리하지 않는다.

welfare$income <- ifelse(welfare$income<=bp[1], NA, welfare$income)

table(welfare$income1==bp[1], useNA = "ifany") # 이상치 처리 된었는지 학인
table(welfare$income==bp[1], useNA = "ifany")
table(is.na(welfare$income))
summary(welfare$income) # 하위 이상치만 처리한 데이터


#(7)결측치를 제외한 데이터를 이용하여 성별에 따른 월급차이가 있는지를 분석한다
# 2.7 성별에 따른 월급 차이 분석을 도표로
tapply(welfare$income, welfare$gender, FUN=mean, na.rm=T)
tapply(welfare$income, welfare$gender, FUN=sd, na.rm=T)
by(welfare$income, welfare$gender, mean, na.rm=T)
by(welfare$income, welfare$gender, sd, na.rm=T)
summaryBy(income~gender, data=welfare, FUN=c(mean, sd), na.rm=T)
aggregate(welfare$income, by=list(welfare$gender), mean, na.rm=T)
aggregate(welfare$income, by=list(welfare$gender), sd, na.rm=T)
# na.omit함수를 써서 아래의 방법을 쓸 수도 있음.
temp <- welfare[, c('income','gender')]
temp <- na.omit(temp)
summary(temp)
summaryBy(income~gender, temp, FUN = c(mean, sd))

#birth 를 넣으면.
temp <- welfare[, c('income','birth')]
temp <- na.omit(temp)
summary(temp)
summaryBy(income~birth, temp, FUN = c(mean, sd))

summaryBy(income~birth, data=welfare, FUN=c(mean, sd), na.rm=T)  
#-> 1907년 생의 값이 na 라서 mean, ad를 할수강벗음.

welfare %>% 
  filter(!is.na(income) & !is.na(gender)) %>% 
  group_by(gender) %>% 
  summarise(mean=mean(income),
            sd = mean(income))




# 2.7 성별에 따른 월급 차이가 있는지 그래프로 분석
welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(gender) %>% 
  summarise(income.mean = mean(income),
            income.sd = sd(income)) %>% 
  ggplot(aes(x=gender, y=income.mean)) +
  geom_bar(stat = 'identity') +
  labs(title="성비에 따른 평균 수입")

ggplot(data=welfare, aes(x=gender, y=income)) +
  geom_point(position="jitter", col="yellow", alpha=0.2)+
  geom_violin()+
  geom_boxplot(aes(col=gender), fill='lightyellow', notch = T, width=0.7) +
  geom_rug(col="dimgray")+
  labs(title = "하위 이상치 처리 후 성별에 따른 수입 분석")+
  coord_cartesian(ylim=c(0,1000))

# 2.7 성별에 따른 월급차이가 있는지 통계적 분석
temp <- welfare %>%  filter(!is.na(income))
View(temp)
var.test(income~gender, data=temp) # 등분산성 테스트
t.test(income~gender, data=temp, var.equal=F)
# p-value가 0.05미만으로 성별에 따른 월급차이가 없다는 가설을 기각한다




#[3] 1번 문제의 결과인 data.frame변수를 이용하여 
#나이와 월급의 관계를 분석하여 몇 살 때 월급을 가장 많이 받는지 시각화하시오.
names(welfare)
class(welfare$birth)

#(1)birth, income 필드 변수의 이상치와 결측치를 확인한다
boxplot(welfare$birth)$stat 
#b <- boxplot(welfare$birth)$stat
#table(welfare$birth<b[1] | welfare$birth>b[5]) 콘솔로 확인.
boxplot(welfare$income)$stat
table(is.na(welfare$birth))
table(is.na(welfare$income))

summary(welfare$birth) # 결측치 확인
table(!is.na(welfare$birth)) # 결측치 확인


#(2) birth변수를 이용하여 나이를 계산하고 이 값을 age 필드로 추가한다
head(welfare$age)
#나이변수 추가 (나이는 2015년 기준으로.)
dim(welfare)
welfare$age <- 2015 - welfare$birth +1
dim(welfare) #나이변수 하나 추가
head(welfare)
summary(welfare$age)
qplot(welfare$age)

welfare %>% 
  select(age)



#나이분포
boxplot(welfare$age)$stat #나이가 2~109살까지 데이터가 있는걸 볼 수 있다.

qplot(welfare$age)
ggplot(data=welfare, aes(age)) +
  geom_histogram()
ggplot(data=welfare, aes(age)) +  geom_bar() # 이것도 가능하나 막대그래프는 주로 범주형자료시 사용함

boxplot(welfare$age)$stat # 나이가 2살부터 109살까지 데이터 있음
ggplot(welfare, aes(y=age)) + 
  geom_boxplot() +
  theme(axis.text.x = element_blank())+ # x축 눈금을 없앰
  coord_cartesian(xlim=NULL)


#(3)x축을 나이, y축을 월급으로 지정하고 나이에 따른 월급의 변화가 표현되도록 
#막대그래프나 선 그래프로 시각화한다
age.income <- welfare %>% 
  filter(!is.na(welfare$income)) %>% 
  group_by(age) %>% 
  summarise(income.mean = mean(income),
            income.sd = sd(income))
  head(age.income)
  table(age.income)
  
  ggplot(age.income, aes(x = age, y=income.mean))+
    geom_col()+
    geom_line()

  ggplot(age_income, aes(x=age, y=income.mean)) +
    geom_bar(stat='identity') +
    geom_line()



#(4) 나이에 따른 월급의 차이가 있는지 관계를 분석한다
  result <- aov(income~age, data=welfare)
  summary(result)

  fit <- lm(income~age, data=welfare)
  anova(fit) #F-value 값에 따라 나이에 따른 월급 차이는 유의미한 것으로 볼 수 있다.

# 3.5(+) 월급을 가장 많이 받는 나이대는
  ggplot(age.income, aes(x=age, y=income.mean)) +
    geom_line() +
    coord_cartesian(xlim = c(20,60))
 #xlim(c(45,60))
  orderBy(~-income.mean, data=age.income)[1,]
  
  age.income[order(age.income$income.mean, decreasing = T),]
  age.income %>% 
    arrange(-income.mean) %>% # 이상치 처리 전 월급을 가장 많이 받는 나이는 53세
    head(5)



#[ 4 ] 1번 문제의 결과인 data.frame변수를 이용하여 연령대에 따른 월급의 차이가 있는지, 
  #있으면 어떤 연령대가월급이 가장 많은지 분석하시오. 
  #단, 연령대는 30세 이하는 young, 30~60세는 middle, 61세 이상은 old로 분류한다. 
  names(welfare)
  dim(welfare)

#(1) 파생변수 agegrade 추가
#  young 30세 이하 / 30~60 middle / 61세 이상 - old
  welfare <- welfare %>%
    mutate(agegrade = ifelse(age<=30, "young",
                             ifelse(age<=60, "middle", "old")))
str(welfare$agegrade)
# welfare$agegrade를 factor형 변수로 해도 됨.
# welfare$agegrade <- factor(welfare$agegrade, levels = c('young','middle','old'))


#(2) agegrade의 분포를 도표와 그래프로

table(welfare$agegrade, useNA = "ifany") #NA 포함한 빈도표

qplot(welfare$agegrade) + xlim(c('young','middle','old'))
ggplot(data=welfare, aes(agegrade)) + 
  geom_bar(aes(fill=agegrade)) +
  #xlim(c('young','middle','old')) + 아래와 같음
  scale_x_discrete(limits=c('young','middle','old')) +
  theme(legend.position = "none")

#(3) 연령대 별 월급의 boxplot
boxplot(income~agegrade, data=welfare, col=c('red','green','blue'))
ggplot(welfare, aes(x=agegrade, y=income, fill=agegrade)) +
  geom_boxplot(notch = T) + #95%의 구간이 위아래가 좁으면 좁을수록 중위수와 비슷해지기에 결과내기에 더 좋다.
  scale_fill_manual(values=topo.colors(3))+
  coord_cartesian(ylim = c(0,700))

#(4) 연령대에 따른 월급 차이가 있는지 분석 도표
agegrade_income <- welfare %>% 
  group_by(agegrade) %>% 
  summarise(income.mean = mean(income, na.rm=T),
            income.sd= sd(income, na.rm=T))
agegrade_income
summaryBy(income~agegrade, welfare, FUN=c(mean, sd), na.rm=T)


# 4.4 연령대에 따른 월급 차이가 있는지 분석 시각화

ggplot(agegrade_income, aes(x=agegrade, y=income.mean)) +
  geom_col(aes(fill=agegrade)) +
  scale_x_discrete(limits=c('young','middle','old')) +
  theme(legend.position = "none")

ggplot(welfare, aes(x=agegrade, y=income)) +
  geom_point(position='jitter', col='orange', alpha=0.2)+
  geom_boxplot(aes(fill=agegrade), notch = T) +
  scale_x_discrete(limits=c('young','middle','old')) +
  scale_fill_discrete(limits=c('young','middle','old')) +
  geom_rug(col='dimgray')+
  coord_cartesian(ylim=c(0,400))

# 4.4 연령대에 따른 월급 차이가 통계적으로 유의미한지 분석
temp <- welfare %>%  filter(!is.na(income))
result <- aov(income~agegrade, data=temp)
summary(result)




# [ 5 ] 1번 문제의 결과인 data.frame변수를 이용하여, 
#성별에 따른 월급의 차이는 연령대 별로 다른지 분석하시오.


#(1)성별, 연령대, 월급 데이터의 결측치를 확인한다
(table(is.na(welfare$gender)))
(table(is.na(welfare$income))) # ==> 결측치 있음. T=12044
(table(is.na(welfare$agegrade)))

#(2)연령대별, 성별 월급의 평균과 표준편차, 빈도를 출력한다
gender_agegrade_income <-welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(agegrade, gender) %>% 
  summarise(income.mean = mean(income),
            income.sd = sd(income),
            n = n())
gender_agegrade_income


#(3)성별에 따른 월급의 차이가 연령대별로 다른지 시각화 한다
ggplot(gender_agegrade_income, aes(x=agegrade, y=income.mean, fill=gender)) +
  geom_bar(stat = 'identity', position = "dodge")


ggplot(data=gender_agegrade_income, aes(x=agegrade, y=income.mean, fill=gender)) + 
  geom_col(position = "dodge") + 
  scale_x_discrete(limits=c("young", "middle","old"))

ggplot(gender_agegrade_income, aes(x=gender, y=income.mean)) +
  geom_col(aes(fill=gender))+
  facet_wrap(~agegrade) +
  theme(legend.position = "none")


# young 연령대 남녀비교
young <- ggplot(subset(welfare, agegrade=='young'), 
                aes(x=gender, y=income)) +
  geom_point(position = "jitter", col='brown', alpha=0.3)+
  geom_violin() +
  geom_boxplot(aes(fill=gender),notch = T, width=0.6)
# middle 연령대 남녀비교
middle <- ggplot(subset(welfare, agegrade=='middle'), 
                 aes(x=gender, y=income)) +
  geom_point(position = "jitter", col='brown', alpha=0.3)+
  geom_violin() +
  geom_boxplot(aes(fill=gender),notch = T, width=0.6)
# old 연령대 남녀비교
old <- ggplot(subset(welfare, agegrade=='old'), 
              aes(x=gender, y=income)) +
  geom_point(position = "jitter", col='brown', alpha=0.6)+
  geom_violin() +
  geom_boxplot(aes(fill=gender),notch = T, width=0.7)

library(gridExtra)
grid.arrange(young, middle, old, ncol=3) #여러 차트를 한번에 나타나게 한다.
# 단, 순서는 첫실행 코드부터 시작된다.


#각 연령대 별 t-test 를 해서 통계학 분석을 한다.


#[ 6 ] 1번 문제의 결과인 data.frame변수를 이용하여 나이에 따른 월급 변화를 성별을 분리하여 시각화 하시오. 
#(1)나이와 성별로 group_by하여 월급평균, 월급표준편차, 월급중앙값,
# 최소값과 최대값, 빈도을 산출한다
gender_age_income <- welfare %>% 
  filter(!is.na(welfare$income)) %>% 
  group_by(age, gender) %>% 
  summarise(income.mean = mean(income, na.rm=T),
            income.sd = sd(income),income.median = median(income),
            income.min = min(income),income.max = max(income),n=n())
gender_age_income



#(2)나이에 따른 월급평균의 추이를 아래와 같은 그래프를 시각화하고, 
#아래의 그래프를 파일로도 출력한다

png(filename = 'result.png', width = 800, height = 600)
ggplot(gender_age_income, aes(x=age, y=income.mean, col=gender)) +
  geom_line()
dev.off()




#[7] 1번 문제의 결과인 data.frame변수를 이용하여 직업별 월급의 차이가 나는지 분석하고,
# 만약 월급의 차이가나면 어떤 직업이 월급이 가장 많은지 상위 10개 직업군만 시각화하시오. 

job_list <- read_excel('data/Koweps/Koweps_Codebook.xlsx', col_names=T, sheet=2)
#시트가 안먹히면 1페이지의 시트차트를 따로 저장하고 2시트페이지를 1페이지로 넣고 저장시킨다.

View(job_list)
head(job_list)
head(welfare)


#(1)직업별 월급 평균, 표준편차, 빈도를 평균월급 순으로 정렬하여 출력하여
# 직업별 월급의 추이를 분석한다
str(welfare)
str(job_list)
head(welfare)
table(welfare$code_job)
table(job_list)

#welfare 데이터와 job_list 의 데이터간의 left_join 결합.
welfare <- left_join(welfare,job_list, id='code_job')
View(welfare)
#income, code_job 의 결측치 유무.
(table(is.na(welfare$code_job))) # 결측치 T = 9135.
(table(is.na(welfare$income))) # 결측치 T = 12044.

#직업별 월급 평균, 표준편차, 빈도를 평균월급 순으로 정렬하여 출력
job_income <- welfare %>% 
  filter(!is.na(job) & !is.na(income)) %>% 
  group_by(job) %>% 
  summarise(income.mean = mean(income),
            income.sd = sd(income), n = n()) %>% 
  arrange(desc(income.mean))
View(job_income)  
nrow(job_income)

#(2)직업별 월급의 차이를 분석한 후, 상위 소득 10개 직업군을 도표로 출력하고, 
#아래와 같은 그래프로 시각화한다. 
#시각화한 그래프는 ggsave함수를 이용하여 top10.png라는 그림파일로 저장한다

#상위소득 10위 변수 선언.
(top10 <- head(job_income, 10))
top10[,'job']

#
ggplot(top10, aes(x= income.mean, y=job))+
  geom_col()+
  coord_cartesian()+
  labs(title = "상위 소득 1~10위 직업군", x= '직업',
       y= '평균소득')
#sclae_y_discrete(limits=c(실 데이터와 순서를 잘 적고,),
#                  lables=c(수정할 이름들과 상단의 순서에 맞게.))

#scale_y_discrete(limits=c('금속 재료 공학 기술자 및 시험원', 
 #                         '의료진료 전문가',
  #                        '의회의원 고위공무원 및 공공단체임원',
   #                       '보험 및 금융 관리자',
    #                      '제관원 및 판금원',
     #                     '행정 및 경영지원 관리자',
      #                    '문화 예술 디자인 및 영상 관련 관리자',
       #                   '연구 교육 및 법률 관련 관리자',
        #                  '건설 전기 및 생산 관련 관리자',
         #                 '석유 및 화학물 가공장치 조작원'),
          #       labels=c('금속재료공학',
           #               '의료진료','고위공무원','보험',
            #              '제관원','행정경영','문화예술',
             #             '연구교육','건설생산','석유화학'))



#reorder() 함수를 이용해 그래프 정렬.
ggplot(data=top10, aes(x=reorder(job, income.mean), y=income.mean)) +
  geom_col() + 
  coord_flip() +
  labs(title = "상위 소득 10개 직업군", x="직업", 
       y="평균소득")


#(3)하위 소득 10개 직업군도 도표로 출력하고 시각화한다
bottom10 <- welfare %>% 
  filter(!is.na(income) & !is.na(job)) %>% 
  group_by(job) %>% 
  summarise(mean.income = mean(income)) %>% 
  arrange(mean.income) %>% 
  head(10)

bottom10

ggplot(bottom10, aes(x= mean.income, y= reorder(job, mean.income)))+
  geom_col(aes(fill = job))+
  xlim(0, 150)+
  labs(title = '소득 하위 10개 직업군', x='직업군', y='평균소득')+
  theme(legend.position = 'none')


#[ 8 ] 1번 문제의 결과인 data.frame변수를 이용하여, 
#성별로 어떤 직업이 가장 많을지 분석하시오

#최빈값 : 모드(mode)는 통계학 용어로, 가장 많이 관측되는 수, 
          #즉 주어진 값 중에서 가장 자주 나오는 값이다.

#(1)여성 최빈 직업 상위 10를 추출한다
female_top10 <- welfare %>% 
  filter(!is.na(job) & gender == 'female') %>% 
  group_by(job) %>% 
  summarise(cnt = n()) %>% 
  arrange(desc(cnt)) %>% 
  head(10)

ggplot(data = female_top10, aes(y= reorder(job,cnt), x=cnt))+
  geom_col(aes(fill=job))+
  labs(title = '여성 최빈 직업 상위10.')+
  theme(legend.position = 'none')




#(2)남성 최빈 직업 상위 10을 추출한다
male_top10 <- welfare %>% 
  filter(!is.na(job) & gender == 'male') %>% 
  group_by(job) %>% 
  summarise(cnt = n()) %>% 
  arrange(desc(cnt)) %>% 
  head(10)

ggplot(male_top10, aes(y= reorder(job,cnt), x=cnt))+
  geom_col(aes(fill = job))+
  labs(title = '남성 최빈 직업 상위10.')+
  theme(legend.position = "none")



#[ 9 ]1번 문제의 결과인 data.frame변수를 이용하여, 
#종교 유무에 따른 이혼률을 분석하시오.

#(1)종교 데이터인 religion 필드의 이상치 및 결측치를 확인한다
boxplot(welfare$religion)$stat # 데이터값들이 1,2만 있다.
(table(is.na(welfare$religion))) #결측치 없음.
(table(welfare$religion)) # 1: 유, 2:무 결과만 있음
(table(welfare$religion, exclude = NULL)) #NA포함 빈도표


#(2) religion 필드가 1이면 “종교-유”, 2이면 “종교-무”로 데이터를 변경한다
welfare$religion <- ifelse(welfare$religion == 1, '종교-유', '종교-무')
welfare$religion
(table(is.na(welfare$religion))) # 혹시나 의 결측치 확인.

#(3) 종교 유무의 빈도를 시각화한다
table(welfare$religion)


ggplot(welfare, aes(x= religion, fill=religion))+
  geom_bar(width = 0.3)+
  labs(title = "종교 유무의 빈도")+
  theme(legend.position = 'none')



#(4)혼인 상태 데이터인 marriage 필드가 1이면 “기혼”, 3이면 “이혼”으로,
# 그 외는 NA로 값을 같은 marriage_group 파생변수를 추가한다
welfare <- welfare %>% 
  mutate(marriage_group = ifelse(marriage == 1, '기혼',
                                 ifelse(marriage == 3, '이혼', NA)))
head(welfare)
table(welfare$marriage_group, useNA = 'ifany')
table(is.na(welfare$marriage_group)) # T = 미혼, 별거, 사별 ,아이, NA


#(5)종교 유무에 따른 이혼률을 분석한다
temp <- welfare %>% 
  filter(!is.na(marriage_group) & !is.na(religion))
View(temp)

#도표
table(temp$religion, temp$marriage_group)



#(6)분석한 결과를 도표와 그래프로 시각화한다
#시각화
religion_marriage <- welfare %>% 
  filter(!is.na(marriage_group)) %>% 
  group_by(religion, marriage_group) %>% 
  summarise(n = n()) %>% 
  mutate(tot_group = sum(n)) %>% 
  mutate(pct = round(n/tot_group*100,1))

religion_marriage

ggplot(religion_marriage, aes(x= religion, y=n, fill=marriage_group))+
  geom_col(position = 'dodge')


# 기혼상태만
welfare %>% 
  filter(marriage_group=='기혼') %>% 
  group_by(religion) %>% 
  summarise(tot = n()) %>% 
  mutate(pct = tot/sum(tot)*100) %>% 
  ggplot(aes(x=religion, y=pct)) +
  geom_col()

# 이혼상태만
welfare %>% 
  filter(marriage_group=='이혼') %>% 
  group_by(religion) %>% 
  summarise(tot = n()) %>% 
  mutate(pct = tot/sum(tot)*100) %>% 
  ggplot(aes(x=religion, y=pct)) +
  geom_col()

# t-test는 독립변수는 볌주형, 종속변수는 연속형이여야 적합하다.
var.test(data=temp, marriage~religion)
t.test(data=temp, marriage~religion, var.equal=F) #p-value가 0.045로 종교유무에 따라 결혼상태가 다소 다를 수 있다.


#[10] 1번 문제의 결과인 data.frame변수를 이용하여 지역별 연령대 비율을 분석하시오.
# 노년층이 많은 지역은 어디인지 출력하시오. 
#(1)결측치를 확인한다
table(welfare$code_region, useNA = "ifany")
table(!is.na(welfare$agegrade)) # 연령대, 지역 모두 NA가 없음
table(!is.na(welfare$code_region))



#(2)region 파생변수를 지역명으로 추가한다
#1:서울 2:수도권(인천/경기) 3:부산/경남/울산 4:대구/경북 
#5:대전/충남 6:강원/충북 7:광주/전남/전북/제주도
region_list <- data.frame(code_region = c(1:7),
                          region=c('서울',
                                   '수도권(인천/경기)',
                                   '부산/경남/울산',
                                   '대구/경북',
                                   '대전/충남',
                                   '강원/충북',
                                   '광주/전남/전북/제주도'))

region_list
View(region_list)
welfare <- left_join(welfare, region_list, by="code_region")

head(welfare)
table(welfare$code_region)
table(welfare$region)




#(3) 지역별 연령대 비율을 분석한 도표 및 그래프를 시각화한다
region_agegrade<-welfare %>% 
  group_by(region, agegrade) %>% 
  summarise(n = n()) %>% 
  mutate(tot_group = sum(n)) %>% 
  mutate(pct = round(n/tot_group*100, 2))


region_agegrade

# 지역별 연령대 인구
ggplot(data=region_agegrade, aes(x=reorder(region, n), y=n, fill=agegrade)) + 
  geom_col(position = 'dodge') +
  theme(axis.text.x = element_text(angle = 70, vjust=0.7)) # 노년층이 많은 지역은 광주/전남/전북/제주

# 지역별 연령대 비율
ggplot(data=region_agegrade, aes(x=reorder(region, n), y=pct, fill=agegrade)) + 
  geom_col(position = 'dodge') +
  theme(axis.text.x = element_text(angle=70, vjust=0.5)) # 노년층 비율이 많은 지역은 대구/경북



#(4) 노년층이 많은 지역이 어디인지 시각화한다
# 노년층이 많은 순
oldagegrade_region <- region_agegrade %>% 
  filter(agegrade=='old') %>%
  arrange(desc(n))

oldagegrade_region

ggplot(oldagegrade_region, aes(x=n, y=reorder(region, n))) +
  geom_col()
cat('노년층 인구가 많은 순 :', oldagegrade_region$region )


# 노년층 비율이 높은 순
oldagegrade_region <- region_agegrade %>%
  filter(agegrade=='old') %>%
  arrange(desc(pct))

oldagegrade_region

ggplot(data=oldagegrade_region, 
       aes(x = pct, y=reorder(region, pct))) +geom_col()

cat('노년층 비율이 높은 순 :', oldagegrade_region$region )


# ※  7개 변수 외에도 신체건강, 정신건강, 가족간의 관계, 주거환경, 교육수준 등 957개의 변수가 있습니다. 흥미로운 주제를 찾아 자신만의 데이터 분석 프로젝트를 수행해 보세요. 조사설계서 참조
