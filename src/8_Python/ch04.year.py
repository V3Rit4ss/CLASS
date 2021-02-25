# -*- coding: utf-8 -*-
"""
태어난 년도를 입력받아, 나이와 성인(20살 이상)인지, 청소년(15~19)인지,
아동(14살 이하) 인지 출력 하라.
1992년도에 태어난 당신은 30살이고 성인 입니다.

python ch04.year.py 1992
python ch04.year.py

"""

import sys
if len(sys.argv) ==  1:
    birth = int(input('태어난 년도 ? : '))
else:
    birth = int(sys.argv[1])
age = 2021-birth+1
if age >= 20:
    group ='성인' #java와 다르게 if블럭 벗어나도 사용가능.
elif 15 <= age < 19:
    group ='청소년'
else :
    group = '아동'
print('{}년도에 태어난 당신은 {}세 이고 {} 입니다.'.format(birth,age,group))
