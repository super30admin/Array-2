# Time Complexity : O(n) where n is length of nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : No

class Solution:
    def findMaxMin(self, nums):
        if len(nums) == 0:
            minim = 0
            maxim = 0
        if len(nums) == 1:
            minim = nums[0]
            maxim = nums[0]
        elif len(nums) == 2:
            minim = min(nums)
            maxim = max(nums)
        else:
            if nums[1] > nums[0]:
                minim = nums[0]
                maxim = nums[1]
            else:
                minim = nums[1]
                maxim = nums[0]
            for i in range(2,len(nums)):
                if nums[i] < min:
                    min = nums[i]
                elif nums[i] > max:
                    max = nums[i]

# Here if the length of list is 0, then max and min will be 0, if the length is 1 then max and min will be the number itself,
#if the length of list is greater then 2, then we will assign the smallest of first two numbers as min and the bigger one as max and will
#iterate till the end of list and will update min and max