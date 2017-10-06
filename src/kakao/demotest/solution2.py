# https://www.welcomekakao.com/tryouts/1467/intro
def solution(arr):
    table = [0] * (len(arr)+1)
    for i in arr:
        if i > len(arr) or i < 1 or table[i]!=0:
            return False
        table[i] = i
    return True

# print(solution([1,2,3]))
# print(solution([1,2,3,3]))
# print(solution([4,1,3]))
