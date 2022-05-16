# Time Complexity : O(N) when N is range of the numbers
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findDisappearedNumbers(self, nums):
        missing = []
        
        for i in range(len(nums)):
            if nums[abs(nums[i]) - 1] > 0:
                nums[abs(nums[i]) - 1] *= -1
             
        
        for i in range(len(nums)):
            if nums[i] > 0:
                missing.append(i+1)
                
        return missing

solution = Solution()
print(f"OUTPUT >> {solution.findDisappearedNumbers([4,3,2,7,8,2,3,1])}")