# An array of numbers of length N is given , you need to find the minimum and maximum. try doing this in less than 2* (N-2) comparisons
# to do this in 1.5N comparisons,we take pairs and then find min or max
minEl,maxEl = float('inf'),-1*float('inf')
nums = [5,32,42,535,21,1,3,5,-1]

for i in range(len(nums)-1):
    if nums[i]>nums[i+1]:
        minEl = min(minEl,nums[i+1])
        maxEl = max(maxEl,nums[i])
    else:
        minEL = min(minEl,nums[i])
        maxEl = max(maxEl,nums[i+1])

print('max num=',maxEl)
print('min num=',minEl)