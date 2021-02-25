# # # 12장. 텍스트 마이닝 # # #
# 문자로 된 비정형 데이터로부터 가치있는 정보를 얻어내는 분석
# => 텍스트 마이닝 시 가장 할 일은 형태소 분석


install.packages("KoNLP") # available 에러.  4.대 버전에서는 불가함.
# 가능하게 할려면 이렇게 해야한다.
#1.KoNLP 검색.
#2. CRAN - Package KoNLP
#3. archive 클릭.
#4. 최하단의 파일을 다운로드.(최신버전.)

#install.packages 명령어를 안쓰고 수동으로 직접 패키지를 다운하려고 할때,
#우측의 패키지 탭에서 install 하는법.
install.packages("devtools") #.1


#KoNLP 가 의존하는 package들 미리 install.
install.packages("rJava") #자바가 사용자의 pc에 있어야 한다.
install.packages("memoise")
install.packages("hash")
install.packages("tau")
install.packages("Sejong")

#pakages -> install 도구를 이용하여 KoNLP 패키지를 수동으로 install 할 수 있다.
#1. pakages 탭 -> 좌측상단 install -> install from = 다운받은 tar.gz 확장자 포함으로 바꾸고 해당 파일을 선택 후 인스톨.
#2. Fail to install scala-library-2.11.8.jar. 에러 해결법.
#2-2 . 3번 하기전에 pc 의 이름이 한글이면 영어로.
#3. C:\Users\tjoeun\Documents\R\win-library\4.0\KoNLP\java
#3-2.  3번 경로에 scala-library-2.11.8.jar. 파일을 넣어야한다.

library(KoNLP)
#Checking user defined dictionary! 뜨고,
Sys.getenv("JAVA_HOME")
# rJava 때문에 환경변수 확인.
#사전 설정하기.
useNIADic() # 첫 로드하면 뭐라 할텐데, 1. 엔터. 983012 words dictionary was built. => 983012개의단어.
extractNoun('대한민국의 영토는 한반도와 그 부속 도서로 한다')
#명사로만 추출.  "한" 이라는 단어가 사전에 있어서 그런다.
extractNoun('의미있는 하루하루, 알차고 환희찬 하루 감사해요')



#1. 힙합 가사 텍스트 마이닝.
#1.1 텍스트마이닝 할 텍스트 로드. (필요한 데이터 확보)
txt <- readLines('data/hiphop.txt') #비정형 데이터.
head(txt)

#1.2 특수문자 제거.

#gsub(oldStr, newStr, string) old문자를 -> new 문자로 바꾸는.
# str_replace_all(string, oldStr, newStr) string 형에서 old를 -> new 로 바꾸는.
library(stringr) #str_replace_all 사용하려면 로드.
temp <- gsub('\\W', ' ',txt)
txt <- str_replace_all(txt, '\\W',' ')
table(temp == txt) #서로 결과값들이 같은걸 볼 수 있다.


#1.3 명사 추출.
head(txt)
nouns <- extractNoun(txt) #명사만 추출하여 list 형태로 반환.
#시간이 걸리는걸 체험이 된다.

class(nouns)
head(unlist(nouns)) #unlist() 하면 벡터형태로.
table(unlist(nouns)) #word 카운트.
wordcount <- table(unlist(nouns)) #워드카운트.(단어별 빈도표) 생성.
class(wordcount)
head(wordcount,100)
sort(wordcount)
df_word <- as.data.frame(wordcount, stringsAsFactors = F)
        #stringsAsFactors = F 하는이유 : 문자를 factor타입으로 안 하고자.
head(df_word,20) #앞이 단어, 뒤가 갯수.
str(df_word) #Var1: Factor w/ 이렇게 되면 워드클라우드 결과가 잘 안나온다.
library(dplyr)
df_word <- rename(df_word, word=Var1, freq=Freq)
str(df_word)
head(df_word)
nrow(df_word) #단어 갯수 확인.

#dplyr  로드 했을시.
#한 글자들 처리
df_word <- df_word %>% 
  filter(nchar(word)>=2)  #nchar 문자수 반환. 글자수가 없거나 하나인 문자들 걸러짐.

#dplyr 로드 안했을시.
df_word <- filter(df_word, nchar(word)>=2)
head(df_word)




#자주 사용되는 단어 빈도표 top20 만들기
top20 <- df_word[order(-df_word$freq),][1:20,] #작은것부터 큰순으로 '색인' 이 나온다, 에서 -를 붙혀서 반대로.
top20$word

#== arrange 이용

top20 <- df_word %>% 
  arrange(desc(freq)) %>% 
  head(20)
top20$word



#자주 사용되는 단어 top20 그래프 그리기.
library(ggplot2)
ggplot(data = top20, aes(x= freq, y= reorder(word, freq)))+
  geom_col()+
  geom_text(aes(label=freq), col='red')


#워드클라우드 생성.
# 생성전 해야할 단계.
#1. text(비정형) 데이터 확보.
#2. 패키지 설치 및 로드. (KoNLP, wordcloud)
#3. 확보된 text 데이터 읽어오기.
#4. 명사 추출.
#5. 필요없는 데이터 삭제 (특수문자, zz, ㅋㅋ, ㅎㅎ, 숫자, ... )
#6. 워드카운트 생성.
#7. wordcloud 함수 이용해서 워드클라우드 생성.
install.packages("wordcloud")
library(wordcloud) # RColorBrewer 패키지를 로딩중 이라고 뜨는 이유. 저 패키지를 많이 쓴다.
set.seed(1234) #난수 시드 설정 = 시드값을 정해놓으면 랜덤값을 고정시킨다.
#다른말로, 난수 생성 결과를 일치시킬려고.
#워드클라우드 생성시 난수로 단어들 위치가 결정된다.

round(runif(6, min=1, max=45)) # 확인.
display.brewer.all()

pal<- brewer.pal(8, 'Dark2')
set.seed(1234)

?wordcloud
wordcloud(words = df_word$word,  #뿌려질 단어.
          freq = df_word$freq,  #단어 빈도.
          min.freq = 2,        #단어의 최소 빈도 0,1 의 단어들은 빠진다.
          max.words = 200,    #표현될 최대 단어 수
          random.order = F,  #최빈 단어를 중앙 배치.
          rot.per = 0.1,    #회전 단어 비율.
          scale = c(3, 0.3), #단어크기 범위   오른쪽 plots 창의 크기에 맞춰서 나온다 늘리거나 줄이면 생김새가 망가진다.
          colors = pal)     #단어의 색상.   pal 에 팔레트를 넣었음.

#색상만 변화.
display.brewer.all() #팔레트에서 정하고싶은 색상 선택.
pal <- brewer.pal(9, 'Blues')[5:9] #Blues 팔레트에서 5번째 부터 9번째 가지의 색상만 쓰겠다.
set.seed(1234)

wordcloud(words = df_word$word,  #뿌려질 단어.
          freq = df_word$freq,  #단어 빈도.
          min.freq = 2,        #단어의 최소 빈도 0,1 의 단어들은 빠진다.
          max.words = 200,    #표현될 최대 단어 수
          random.order = F,  #최빈 단어를 중앙 배치.
          rot.per = 0.1,    #회전 단어 비율.
          scale = c(3, 0.3), #단어크기 범위   오른쪽 plots 창의 크기에 맞춰서 나온다 늘리거나 줄이면 생김새가 망가진다.
          colors = topo.colors(16)) #단어의 색상.   pal 에 팔레트를 넣었음. 또는  topo.colors 이렇게 넣어도 된다.




#2.국정원 트윗 데이터 텍스트 마이닝.
rm(list = ls())
twitter <- read.csv('data/twitter.csv', header = T, stringsAsFactor = F, fileEncoding = 'UTF-8')
head(twitter)
View(twitter)
class(twitter) #data.frame 형으로 들어왔다.

twitter <- rename(twitter, no=번호, id=계정이름, data=작성일, tw=내용)
edit(twitter)



#필요없는 문자,단어 삭제하기.
twitter$tw <- str_replace_all(twitter$tw, '\\W', ' ') #'\\W' 특수문자를 ' ' 스페이스로. 그냥 ''하면 스페이스바가 안들어가서 안댐.
twitter$tw <- str_replace_all(twitter$tw, '[ㄱ-ㅎ]', ' ')

View(twitter)
head(twitter)


nouns <- extractNoun(twitter$tw)
class(nouns)
nouns
wordcount <- table(unlist(nouns))
class(wordcount) #table 타입.
df_word <- as.data.frame(wordcount, stringsAsFactors = F) # 문자들이 벡터형 변수가 아닌 문자타입으로 들어간다.
str(df_word)

df_word <- rename(df_word, word=Var1, freq=Freq) #변수 이름 변경.
head(df_word)# 확인.
str(df_word)# 최종 확인.


# 출현할 단어중 2글자 이상만 분석.
df_word <- filter(df_word, nchar(word)>1) #한글자 초과만.
head(df_word)

#최빈단어 top20 뽑고 그래프 그리기.
top20 <- df_word[order(df_word$freq, decreasing = T),][1:20,]
top20

df_word %>% 
  arrange(desc(freq)) %>% 
  head(20) %>% 
  ggplot(aes(x=freq, y=reorder(word, freq)))+ #x,y 를 바꾸고 실행시키면 x축의 word가 겹친다.
  geom_col(aes(fill = word))+
  geom_text(aes(label=freq), hjust=1, size=3)+
  theme(legend.position = 'none')
  



#워드클라우드 생성.
display.brewer.all()
pal <- brewer.pal(12, 'Paired')
set.seed(1234)

wordcloud(words = df_word$word,  #뿌려질 단어.
          freq = df_word$freq,  #단어 빈도.
          min.freq = 5,        #단어의 최소 빈도 0,1 의 단어들은 빠진다.
          max.words = 200,    #표현될 최대 단어 수
          random.order = F,  #최빈 단어를 중앙 배치.
          rot.per = 0.1,    #회전 단어 비율.
          scale = c(4, 0.4), #단어크기 범위   오른쪽 plots 창의 크기에 맞춰서 나온다 늘리거나 줄이면 생김새가 망가진다.
          colors = pal)



#계정당 글을 작성한 횟수.
sort(table(twitter$id)) 

#글 게시 수 150회 이상 트윗한 게시물에 대해 최빈 top20개 단어를 출력, 시각화하고 워드클라우드를 완성.

idCount <- as.data.frame(table(twitter$id))

idCount <- rename(idCount, id=Var1, count=Freq)

head(idCount)

twitter <- left_join(twitter, idCount, by="id")
View(twitter)

sampleId <- idCount[idCount$count<150, 'id']
sampleId
twitter1 <- subset(twitter, subset = id %in% sampleId)
View(twitter1)


# 필요없는 문자, 단어 삭제하기
twitter1$tw <- str_replace_all(twitter1$tw, '\\W',' ')
twitter1$tw <- str_replace_all(twitter1$tw, '[ㄱ-ㅎ]',' ')
View(twitter1)
head(twitter1)

nouns <- extractNoun(twitter1$tw)

#워드카운드 생성
wordcount <- table(unlist(nouns))

df_word <- as.data.frame(wordcount, stringsAsFactors = FALSE)
str(df_word)

df_word <- rename(df_word, word=Var1, freq=Freq)
head(df_word)
str(df_word)

# 출현단어 중 2글자 이상만 분석
df_word <- filter(df_word, nchar(word)>1)
head(df_word)

# 최빈 단어 top20 뽑고 그래프 그리기
top20 <- df_word[order(df_word$freq, decreasing = T),][1:20,]
top20

top20 <- df_word %>% 
  arrange(desc(freq)) %>% 
  head(20) 

ggplot(top20, aes(x=freq, y=reorder(word, freq))) +
  geom_col() +
  geom_text(aes(label=freq), hjust=1, size=3, col='yellow')

# 워드클라우드 그리기

set.seed(1234)
pal <- brewer.pal(9, 'Blues')[5:9]
wordcloud(words = df_word$word,
          freq = df_word$freq,
          min.freq = 5,
          max.words = 200,
          random.order = F,
          rot.per = 0.1,
          scale = c(3,0.3),
          colors = pal)





































