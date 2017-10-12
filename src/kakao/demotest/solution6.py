def solution(sticker):

    length = len(sticker)
    dy = [0] * length # 0번을 뜯는 경우
    dn = [0] * length # 0번을 안뜯는 경우

    if length==1:
        return sticker[0]
    if length==2:
        return max(sticker[0], sticker[1])

    dy[0] = sticker[0]
    dy[1] = dy[0]

    for i in range(2, length-1):
        dy[i] = max(dy[i-2] + sticker[i], dy[i-1])
    dy[length-1] = dy[length-2]

    dn[0] = 0
    dn[1] = sticker[1]

    for i in range(2, length):
        dn[i] = max(dn[i-2] + sticker[i], dn[i-1])

    return max(dy[length-1], dn[length-1])


print(solution([14, 6, 5, 11, 3, 9, 2, 10]))
print(solution([1, 3, 2, 5, 4]))
print(solution([1, 9, 1, 9, 1]))
print(solution([3, 1, 1, 9, 10]))
