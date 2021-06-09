# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Not on Leetcode
# Any problem you faced while coding this : No

# taking in pairs and reducing the comparisions to 3n/2
def optmizedMinMax(arr):
    l = len(arr)
    odd = False
    target = l
    mi = 999999999999999
    ma = -999999999999999
    if l % 2 == 1:
        odd = True
        target = l-1
    
    for i in range(0,target,2):
        if arr[i] > arr[i+1]:
            ma = max(ma,arr[i])
            mi = min(mi,arr[i+1])
        else:
            ma = max(ma,arr[i+1])
            mi = min(mi,arr[i])
    if odd:
        ma = max(ma,arr[l-1])
        mi = max(mi,arr[l-1])
    return [mi,ma]

print(optmizedMinMax([12,19,10,3,4,15]))