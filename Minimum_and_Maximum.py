# Time Complexity : O(1.5n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
#First solution 2n set min and max to first element and then compare with rest of elements in array
#Second solution to reduce it to 1.5n so we can check whether array is odd or even if odd then set min and max to first element
#Since we need to set min and max for even array we will compare first and second element and set min and max then we can iterate for rest of elements

class Solution:
    def findMinMax(self, nums: List[int]) -> List[int]:
        if len(nums) == 1:
            return nums
        for i in range(len(nums)):
            min = nums[0]
            max = nums[0]
            if nums[i] < min:
                min = nums[i]
            if nums[i] > max:
                max = nums[i]
        return [min, max]
#Time - O(2n)
#Space - O(1)

class Solution:
    def findMinMax(self, nums: List[int]) -> List[int]:
        n = len(nums)
        if n % 2 == 1:
            min = nums[0]
            max = nums[0]
            i = 1
        else:
            if nums[0] < nums[1]:
                min = nums[0]
                max = nums[1]
            else:
                min = nums[1]
                max = nums[0]
            i = 2

        while i < n-1:
            if nums[i] < nums[i+1]:
                min = min(min, nums[i])
                max = max(max, nums[i+1])
            else:
                min = min(min, nums[i+1])
                max = max(max, nums[i])
            i += 2
        return [min, max]


        