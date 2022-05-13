#Time complexity: O(n)
#Space complexity: O(1)
def minMax(arr):
    minm = arr[0]
    maxm = arr[0]
    l = 0
    r = 1
    while r<len(arr):
        if arr[l]<arr[r]:
            minm = min(arr[l],minm)
            maxm = max(arr[r],maxm)
        else:
            minm = min(arr[r],minm)
            maxm = max(arr[l],maxm)

        l += 2
        r += 2

        if len(nums) % 2 == 1:
            minm = min(minm, nums[-1])
            maxm = max(maxm, nums[-1])
    return minm, maxm

arr = [1,0,3,4,-8,1,6,7,-100]
minm, maxm = minMax(arr)
print(minm,maxm)