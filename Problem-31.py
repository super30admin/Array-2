# Finding minimum and maximum element in an array
# time complexity =O(N)
#space complexity =O(1)
# Approach : we compare two elements in an array then find the max and min element between and simultaneously update the max and min values. 


def min_max(nums):
    min_num=nums[0]
    max_num=nums[0]
    n=len(nums)
    for i in range(0,n,2):
        if i==n-1:
            max_num=max(max_num,nums[i])
            min_num=min(min_num,nums[i])
        else:
            if nums[i]>nums[i+1]:
                max_num=max(max_num,nums[i])
                min_num=min(min_num,nums[i+1])
            else:
                max_num=max(max_num,nums[i+1])
                min_num=min(min_num,nums[i])
    return ( [min_num,max_num])
    