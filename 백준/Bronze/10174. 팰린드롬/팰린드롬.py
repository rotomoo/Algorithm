import sys
input = sys.stdin.readline

n = int(input())
while n > 0:
    tmp = input().strip().lower()
    if tmp == tmp[::-1]:
        print('Yes')
    else:
        print('No')

    n -= 1