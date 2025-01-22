import sys
input = sys.stdin.readline

t = int(input())
while t > 0:
    s = input().strip().split(' ')
    for x in s:
        print(x[::-1], end=' ')
    t -= 1