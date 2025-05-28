# https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# Online IDE - Code Editor, Compiler, Interpreter
# reduced number of times we compare by paring
def getMaxMin(nums):
    n=len(nums)
    #min elements 2
    if n%2==0:
        mn=min(nums[0],nums[1])
        mx=max(nums[0],nums[1])
        idx=2
    else:
        mn=mx=nums[0]
        idx=1
    for i in range(idx,n-1,2):
        if nums[i]<nums[i+1]:
            mn=min(nums[i],mn)
            mx=max(nums[i+1],mx)
        else:
            mx=max(nums[i],mx)
            mn=min(nums[i+1],mn)
    return (mx,mn)
