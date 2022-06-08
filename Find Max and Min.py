""""// Time Complexity : O(1.5n)=O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

def MaxAndMin(nums):
    n=len(nums)
    maximum=1
    minimum=float('inf')
    if n%2==0:
        for i in range(0,n,2):
            if nums[i]>nums[i+1]:
                maximum=max(maximum,nums[i])
                minimum=min(minimum,nums[i+1])
            maximum = max(maximum, nums[i+1])
            minimum = min(minimum, nums[i])
        return maximum, minimum
    if n%2==1:
        for i in range(0,n-1,2):
            if nums[i]>nums[i+1]:
                maximum=max(maximum,nums[i])
                minimum=min(minimum,nums[i+1])
            maximum = max(maximum, nums[i+1])
            minimum = min(minimum, nums[i])
        maximum=max(maximum,nums[n-1])
        minimum=min(minimum,nums[n-1])
        return maximum, minimum

print(MaxAndMin([1,2,4,-2,3,6,7,-7,-8]))

