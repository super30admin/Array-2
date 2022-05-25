# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        outputArray = []
        length = len(nums)
        for num in nums:
            index = abs(num)-1
            if nums[index] > 0:
                nums[index] = -nums[index]
        for i in range(length):
            if nums[i] > 0:
                outputArray.append(i+1)
        return outputArray