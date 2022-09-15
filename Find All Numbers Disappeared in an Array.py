# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
#temporary state change approach

def findDisappearedNumbers(nums):
    res = []
    if nums == None or len(nums) == 0:
        return 0
    n = len(nums)
    for i in range(0,n):
        idx = abs(nums[i]) - 1
        if nums[idx] > 0:
            nums[idx] *= -1
    
    for i in range(0,n):
        if nums[i] > 0:
            res.append(i+1)
        else:
            nums[i] *= -1
    return res

nums = [4,3,2,7,8,2,3,1]
print(findDisappearedNumbers(nums))