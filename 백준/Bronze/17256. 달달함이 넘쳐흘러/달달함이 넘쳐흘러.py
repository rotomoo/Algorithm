a = list(map(int, input().split()))
c = list(map(int, input().split()))

for i in range(3):
    if i != 1:
        print(c[i]-a[2-i], end=' ')
    else:
        print(c[i]//a[i], end=' ')