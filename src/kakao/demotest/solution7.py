def solution(strs, t):

    length = len(t)
    dy = [20001] * (length+1)

    dy[0] = 0

    for i in range(1, length+1):

        for s in strs:
            slen = len(s)
            b = (i - slen)
            if b>=0 and t[b : b+slen] == s:
                dy[i] = min(dy[b] + 1, dy[i])

    print(dy)
    if dy[length] > 20000:
        return -1
    return dy[length]

print(solution(["ba","na","n","a"], "banana"))
print(solution(["app","ap","p","l","e","ple","pp"], "apple"))
print(solution(["ba","an","nan","ban","n"], "banana"))
