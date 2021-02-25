# -*- coding: utf-8 -*-
"""
점수를 입력 받아 메세지 출력


cmd 창에서 해당 파일을 만들고 읽어 들여서 값을 입력받아 해당한 값을 반환 가능.

"""
import sys
if len(sys.argv) ==  1:
    score = int(input('점수 : '))
else:
    score = int(sys.argv[1])

if 90 <= score <= 100:
    grade ='A' #java와 다르게 if블럭 벗어나도 사용가능.
elif 80 <= score < 90:
    grade ='B'
elif 70 <= score < 80:
    grade = 'C'
elif 60 <= score < 70:
    grade = 'D'
elif 0 <= score < 60:
    grade ='F'
else :
    grade = '유효하지 않는 점수'
print('입력한 점수는 {}이고 {}등급'.format(score, grade))

