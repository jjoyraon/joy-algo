def solution(land):
    dy = []
    rows = len(land)
    for i in range(0, rows):
        dy.append([0]*4)
    dy[0] = land[0]

    for i in range(1, rows):
        for j in range(0,4):
            arr = []
            for k in range(0,4):
                if k!=j:
                    arr.append(dy[i-1][k])
            dy[i][j] = land[i][j] + max(arr)

    return max(dy[rows-1])


print(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1]]))
print(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1],[4,3,2,1]]))
print(solution([[99,1,1,1],[99,1,1,1],[99,1,1,1],[99,1,1,1],[99,1,1,1],[99,1,1,1],[99,1,1,1]]))
