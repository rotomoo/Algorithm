import collections
import sys
input = sys.stdin.readline

n = int(input())
while n != 0:
    arr = []
    for i in range(n):
        arr.append(input().strip())

    dict1 = collections.defaultdict(list)
    for str in arr:
        dict1[''.join(sorted(str))].append(str)

    for k, v in list(dict1.items()):
        if k != v[0]:
            dict1[v[0]] = dict1.pop(k)

    key = ''
    m = 0
    for k, v in dict1.items():
        dict1[k] = len(v)
        if len(v) > m:
            m = len(v)
            key = k

    print(key, m-1)
    n = int(input().strip())