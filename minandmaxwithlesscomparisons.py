def minmax(nums):
    min1 = nums[0]
    max1 = nums[0]
    n = len(nums)
    for i in range(0,len(nums)-1,2):
        if nums[i]<nums[i+1]:
            min1 = min(min1,nums[i])
            max1 = max(max1,nums[i+1])
        else:
            min1 = min(min1,nums[i+1])
            max1 = max(max1,nums[i])
    if n%2==1:
        min1 = min(min1, nums[n-1])
        max1 = max(max1, nums[n-1])
    
    return min1, max1

nums = [3,5,7,8,3,4,9,1,10]

print(minmax(nums))