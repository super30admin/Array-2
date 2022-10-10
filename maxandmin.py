##Time Complexity : O(n)
##Space Complexity :O(1)
##Did this code successfully run on Leetcode : Yes
def MaxAndMin(nums):
    num=len(nums)
    maxi=1
    mini=float('inf')
    if num%2==0:
        for i in range(0,num,2):
            if nums[i]>nums[i+1]:
                maxi=max(maxi,nums[i])
                mini=min(mini,nums[i+1])
            maxi = max(maxi, nums[i+1])
            mini = min(mini, nums[i])
        return maxi, mini
    if num%2==1:
        for i in range(0,num-1,2):
            if nums[i]>nums[i+1]:
                maxi=max(maxi,nums[i])
                mini=min(mini,nums[i+1])
            maxi = max(maxi, nums[i+1])
            mini = min(mini, nums[i])
        maxi=max(maxi,nums[num-1])
        mini=min(mini,nums[num-1])
        return maxi, mini

print(MaxAndMin([1, 2, 3, -7, 5, -8, -9, 7]))