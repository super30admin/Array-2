# Time complexity - O(n) (where n = length of the given string)
# Space Complexity: O(1) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : State Change the index corresponding to the pos num to -ve in the first pass.
#            Append the result list with corresponding index of missing numbers.


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        result = []
        for num in nums:
            idx = abs(num)-1
            if nums[idx] > 0:
                nums[idx] = nums[idx]*-1
            
        for i in range(len(nums)):
            if nums[i] > 0:
                missing = i+1
                result.append(missing)
                
            else:
                nums[i]*-1
                
        return result
                
        