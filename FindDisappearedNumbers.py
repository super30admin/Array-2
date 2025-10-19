# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
Mark seen indices by negating values. 
Return indices with positive values as missing numbers.
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        missing = []

        # Set idx to negative if we have seen element (idx+1)  
        for i in range(len(nums)):
            idx = abs(nums[i])-1
            if nums[idx] > 0:
                nums[idx] *= -1
            
        # Check which indices are still positive = missing elements
        for i in range(len(nums)):
            if nums[i] > 0:
                missing.append(i+1)
            else:
                nums[i] *= -1
        
        return missing
