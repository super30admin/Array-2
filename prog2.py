def minmax(A):

    if len(A) % 2 == 0:
        mini = min(A[0],A[1])
        maxi = max(A[0],A[1])
        i = 2
    else:
        mini = maxi = A[0]
        i = 1
    for x in range(i,len(A)-1):
        if A[x] > A[x+1]:
            maxi = max(maxi, A[x])
            mini = min(mini, A[x+1])
        else:
            maxi = max(maxi, A[x+1])
            mini = min(mini, A[x])
        x = x + 2
    print(mini)
    print(maxi)

minmax([1,2,4,10,7,9,3,6])

#time = O(n)
#space = O(1)