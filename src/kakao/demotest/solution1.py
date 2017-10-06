# https://www.welcomekakao.com/tryouts/1467/intro
def solution(n):
    answer = 0;
    for i in list(str(n)):
        answer = answer + int(i)
    print(answer)
    return answer
# solution(123)
