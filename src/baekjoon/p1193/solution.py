#https://www.acmicpc.net/problem/1193
num = int(input())

size = 1
edge = 0

while edge < num:
    edge = edge + size
    size += 1

size -= 1
edge -= size

upValue = num - edge
downValue = num - edge
if size%2==0:
    downValue = size - downValue + 1

if size%2==1:
    upValue = size - upValue + 1

print(str(upValue) + '/' + str(downValue))
