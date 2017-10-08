def solution(board):
    rows = len(board)
    cols = len(board[0])

    sumMap = []
    for i in range(0, rows+1):
        sumMap.append([0]*(cols+1))

    for i in range(1, rows+1):
        for j in range(1, cols+1):
            sumMap[i][j] = sumMap[i-1][j] + sumMap[i][j-1] - sumMap[i-1][j-1] + board[i-1][j-1]


    maxvalue = 0
    maxk = min(rows, cols)
    for k in reversed(range(1, maxk+1)):
        ksize = 0;
        for i in range(1, rows-k+1+1):
            for j in range(1, cols-k+1+1):
                ksize = max(ksize, sumMap[i+k-1][j+k-1] - sumMap[i+k-1][j-1] - sumMap[i-1][j+k-1] + sumMap[i-1][j-1])
        if ksize==k*k:
            return k*k

    return maxvalue


print(solution([[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]))
print(solution([[0,0,1,1],[1,1,1,1]]))
