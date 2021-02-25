#문제.1
#datasets::cars데이터 셋을 이용하여 속도에 대한 제동거리의 산점도와 적합도(신뢰구간그래프)를 나타내시오
#(단, 속도가 5부터 20까지 제동거리 0부터 100까지만 그래프에 나타냄).
str(cars)
ggplot(cars, aes(x = speed, y= dist)) +
  geom_point() +
  geom_smooth(method = 'lm') +
  coord_cartesian(xlim = c(5, 20), ylim = c(0,100))
  




#문제.2
#gapminder::gapminder 데이터 셋을 이용하여 1인당국내총생산에 대한 기대수명의 산점도를 
#대륙별 다른 색으로 나타내시오.
gapminder
ggplot(gapminder, aes(x= gdpPercap, y= lifeExp, color=continent))+
  geom_point()


#문제.3
#gapminder::gapminder 데이터 셋을 이용하여 기대 수명이 70을 초과하는 데이터에 대해 대륙별 데이터 갯수

gapminder$country
edit(gapminder)


gapminder %>%
  filter(gapminder$lifeExp > 70) %>% 
  group_by(continent) %>% 
  summarise(Frequency = n()) %>% 
  ggplot(aes(x= continent, fill= continent,  y=Frequency))+
  geom_bar(stat = "identity")+
  labs(x= '대륙',
       y= '빈도',
       title= '기대수명이 70을 초과하는 데이터 빈도(대륙별)')


#문제.4
#gapminder::gapminder 데이터 셋을 이용하여 기대수명이 70을 초과하는 데이터에 대해 대륙별 나라 갯수.
gapminder %>%
  filter(gapminder$lifeExp > 70) %>% 
  group_by(continent) %>% 
  summarise(n = n_distinct(country)) %>% 
  ggplot(aes(x= continent, fill= continent,  y=n))+
  geom_bar(stat = "identity")+  #<- 또는 geom_col()
  labs(y= '나라 빈도',
       title= '기대수명이 70을 초과하는 대륙별 나라 빈도')



#문제.5
#gapminder::gapminder 데이터 셋을 이용하여 대륙별 기대수명의 사분위수를 시각화
ggplot(gapminder, aes(x= continent, y=lifeExp, color = continent)) +
  geom_boxplot()+
  labs(title = '대륙별 기대수명의 사분위수')


#=================
ggplot(gapminder, aes(x=continent, y=lifeExp, col=continent)) +
  geom_boxplot() +
  coord_cartesian(ylim=c(40,85)) +
  labs(title="연습문제 5.",
       subtitle="대륙별 기대수명의 사분위수")



#문제.6
#gapminder::gapminder 데이터 셋을 이용하여 년도별로 gdp와 기대수명과의 관계를 산점도를 그리고 
#대륙별 점의 색상을 달리 시각화
ggplot(gapminder,aes(x=gdpPercap, y= lifeExp, color=continent))+
  geom_point(position = 'jitter')+
  coord_cartesian(xlim = c(0, 30000))+
  facet_wrap(~year)+
  labs(title = 'GDP 와 기대수명과의 관계')

#=======================

ggplot(gapminder, aes(x=gdpPercap, y=lifeExp, col=continent))+
  geom_point(alpha=0.5)+
  facet_wrap(~year) +
  coord_cartesian(xlim=c(1e+02, 1e+04))+
  #scale_x_log10() + 
  labs(title="연습문제 6.",
       subtitle="GDP와 기대수명과의 관계")



#문제.7
#gapminder::gapminder 데이터 셋에서 북한과 한국의 년도별 GDP 변화를 산점도로 시각화하시오
#(북한:Korea, Dem. Rep. 한국:Korea, Rep. substr(str, start, end)함수 이용)
str(gapminder)
levels(gapminder$country)

gapminder %>% 
  filter(country %in% c('Korea, Dem. Rep.', 'Korea, Rep.')) %>% 
  ggplot(aes(x= year, y=gdpPercap, fill = country)) +
  geom_point(aes(shape=country),col='red',size=2)+
  scale_shape_manual(values = c(21, 3))+
  scale_fill_manual(values = c('blue',NA))+
  theme(legend.position = c(0.2,0.8))+
  labs(title = 'GDP의 변화(한국과 북한)')


#==============
table(gapminder$country)
gapminder %>% 
  #filter(country %in% c('Korea, Dem. Rep.','Korea, Rep.')) 
  filter(substr(country,1,5)=='Korea') %>% 
  ggplot(aes(x=year, y=gdpPercap, col=country, shape=country))+ # shape==pch
  geom_point() +
  scale_shape_manual(values = c(3, 16)) +
  scale_color_manual(values = c('red','blue'))+
  labs(title="연습문제 7.",
       subtitle="GDP의 변화(한국과 북한)") +
  theme(legend.position = c(0.3, 0.8))



table(gapminder$country)
gapminder %>% 
  filter(substr(country,1,5)=='Korea') %>% 
  ggplot(aes(x=year, y=gdpPercap, col=country, shape=country))+ # shape==pch
  geom_point() +
  scale_shape_manual(values = c(3, 16)) +
  scale_color_manual(values = c('red','blue'))+
  labs(title="연습문제 7.",
       subtitle="GDP의 변화(한국과 북한)") +
  theme(legend.position = c(0.3, 0.8))


temp <- gapminder %>% 
  filter(substr(country,1,5)=='Korea')
str(temp$country)
temp$country <- factor(temp$country)
table(temp$country)
temp$country <- factor(temp$country, levels=c('Korea, Rep.','Korea, Dem. Rep.'))
ggplot(temp, aes(x=year, y=gdpPercap, col=country, shape=country))+ # shape==pch
  geom_point() +
  scale_shape_manual(values = c(3, 16)) +
  scale_color_manual(values = c('red','blue'))+
  labs(title="연습문제 7.",
       subtitle="GDP의 변화(한국과 북한)") +
  theme(legend.position = c(0.3, 0.8)) # 범례 없애고 싶으면 "none"


#문제.8
#gapminder::gapminder 데이터 셋을 이용하여 한중일 4개국별 GDP 변화를 산점도와 추세선으로 시각화 하시오.
gapminder %>% 
  filter(country %in% c('Korea, Rep.','Japan','Korea, Dem. Rep.','China')) %>% 
  ggplot(aes(x= year, y=gdpPercap, color = country)) +
  geom_point()+
  geom_line() +
  labs(title = '한중일 4개국의 GDP변화의 산점도와 추세선')
  

#===============
table(gapminder$continent)
gapminder %>% 
  filter(substr(country,1,5)=='Korea' | country=='China' | country == 'Japan') %>% 
  ggplot(aes(x=year, y=gdpPercap, col=country)) +
  geom_point() +
  geom_line() +
  labs(title="연습문제 8.",
       subtitle="한중일 4개국의 GDP변화의 산점도와 추세선")



#문제.9
#gapminder::gapminder 데이터 셋에서 한중일 4개국별 인구변화 변화를 산점도와 추세선으로 시각화 하시오
#(scale_y_continuous(labels = scales::comma)추가시 우측처럼)
gapminder %>% 
  filter(country %in% c('Korea, Rep.','Japan','Korea, Dem. Rep.','China')) %>% 
  ggplot(aes(x = year, y= pop, color=country))+
  scale_y_continuous(labels = scales::comma)+
  geom_point()+
  geom_line()+
  labs(title = '한중일 4개국의 인구 변화의 산점도와 추세선')


#======================

gapminder %>% 
  filter(substr(country,1,5)=='Korea' | country=='China' | country == 'Japan') %>% 
  ggplot(aes(x=year, y=pop, col=country)) +
  geom_point() +
  geom_line() +
  labs(title="연습문제 9.",
       subtitle="한중일 4개국의 인구 변화의 산점도와 추세선") 

gapminder %>% 
  filter(substr(country,1,5)=='Korea' | country=='China' | country == 'Japan') %>% 
  ggplot(aes(x=year, y=pop, col=country)) +
  geom_point() +
  geom_line() +
  labs(title="연습문제 9.",
       subtitle="한중일 4개국의 인구 변화의 산점도와 추세선") +
  scale_y_continuous(labels = scales::comma)

library(car)
head(Salaries)
ggplot(Salaries, aes(x=yrs.since.phd, y=salary, col=rank, shape=sex)) +
  geom_point(size=2) +
  scale_color_manual(values=c("red","green","blue")) +
  scale_shape_manual(values=c(1,3))
# scale_color_manual : 점의 색상을 변경



#문제.10
#Ggplot2::economic 데이터 셋의 개인 저축률(psavert)가 시간에 따라 어떻게 변해 왔는지알아보려 한다. 
#시간에 따른 개인 저축률의 변화를 나타낸 시계열 그래프와 추세선을 시각화하시오
?economics
ggplot(economics, aes(x= date, y=psavert))+
  geom_line(col="red",size=2)+
  geom_smooth(col='red')+
  labs(title = '개인저축률 시계열 그래프')


#==============
ggplot(economics, aes(x=date, y=psavert)) +
  geom_line(color='red', size=2) +
  geom_smooth(col="#FF3333") +
  labs(title="연습문제 10.",
       subtitle="개인저축률 시계열 그래프")


  
#문제 11. 
#Ggplot2::economic 데이터 셋의 개인 저축률(psavert)과 실업의이 시간에 따라 서로 어떻게 변해 왔는지 알아보려 한다.
# 시간에 따른 개인 저축률과 실업률의 변화를 한 그래프에중첩하여 시각화하시오

#  x=date, y=psavert 시계열그래프+추세선(적합도선) 
#              x=date, y=unemploy
economics[1:5, c('date','psavert','unemploy')]

ggplot(data=economics) +
  geom_line(aes(x=date, y=psavert), col='#FF0000', size=2) +
  geom_smooth(aes(x=date, y=psavert), col='pink') +
  geom_line(aes(x=date, y=unemploy*0.001)) +
  geom_smooth(aes(x=date, y=unemploy*0.001), col='dimgray') +
  scale_y_continuous(sec.axis = sec_axis(~.*1000, name="unemploy"))



