def solution(v):

    setx = set();
    sety = set();
    for p in v:
        x = p[0]
        y = p[1]
        if x in setx:
            setx.remove(x)
        else:
            setx.add(x)
        if y in sety:
            sety.remove(y)
        else:
            sety.add(y)
    ax = 0
    ay = 0
    for x in list(setx):
        ax = x
    for y in list(sety):
        ay = y

    return [ax, ay]


print(solution([[1, 4], [3, 4], [3, 10]]))
print(solution([[1, 1], [2, 2], [1, 2]]))
