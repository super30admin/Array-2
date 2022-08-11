# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
# Time O(N) : Two passes over nums of length N
# Space O(1) : No extra space used
# Can be done using hashset as extra space O(N) space and time.

class Solution:
    def findDisappearedNumbers(self, nums):
        # Time O(N) (2N) Space O(1)
        result = []
        #first pass mark the numbers we encounter as visted by making them negative
        for i in range(len(nums)):
            if nums[abs(nums[i]) - 1] > 0:
                nums[abs(nums[i])-1] *= -1
        
        #second pass to find all the non-negative indices for result
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
                
        return result

nums = [4,3,2,7,8,2,3,1]
s = Solution()
output = s.findDisappearedNumbers(nums)
print(output)
        
        