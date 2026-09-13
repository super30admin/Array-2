#Time Complexity : O(2n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode :Yes        
class Solution:
    def findDisappearedNumbers(self, nums):
        n = len(nums)

        for i in range(n):
            j = abs(nums[i]) - 1
            if nums[j] > 0:
                nums[j] *= -1

        result = []
        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)

        return result

        
