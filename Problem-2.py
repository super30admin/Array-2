## Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

nums = [2,2,2,1,0]
small,big,minimum,maximum = 0,0,100000,-1 
for i in range(1,len(nums)):
    if nums[i]>nums[i-1]:
        small = nums[i-1]
        big = nums[i]
        maximum = max(maximum,big)
        minimum = min(minimum,small)
    else:
        small = nums[i]
        big = nums[i-1]
        maximum = max(maximum,big)
        minimum = min(minimum,small)
print(maximum,minimum)

<!-- No of comparisons will be 1.5N.  -->