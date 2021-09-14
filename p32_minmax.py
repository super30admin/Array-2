"""

Welcome to FAANG Problem of the Day.

This problem was asked at Facebook.
An array of numbers of length N is given , you need to find the minimum and maximum.
try doing this in less than 2* (N-2) comparisons

Approach 1 brute force for every number we check if is greater than maxsofar and leser than min so far and update
the max and min so far
approach 2- We check which number is greater among neighbors and take the max from the max of those numbers
and min from minimum of those two numbers, this approach saves numbers of comparisons. so earier we were dping 4
comparisons and now we are doing three

"""
arr=[-1,2,3,4,-7,6]
maxsofar=-float('inf')
minsofar=float('inf')
for i in range(len(arr)-1):
    if arr[i+1]>arr[i]:
        maxsofar=max(maxsofar, arr[i+1])
        minsofar=min(minsofar,arr[i])
    else:
        maxsofar = max(maxsofar, arr[i])
        minsofar = min(minsofar, arr[i+1])

print ([maxsofar, minsofar])


# for e in arr:
###brute force
#     if e>maxsofar:
#         maxsofar=e
#     if e<minsofar:
#         minsofar=e
# print(maxsofar)
# print(minsofar)








