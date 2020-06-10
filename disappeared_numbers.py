# Time Complexity : Add - O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : No

'''
1. Changing the state of each number(by multiplying with -1)  nums[i] by going to appropriate index nums[i] - 1
2. The missing elements will retain their states(i.e no negative sign), as no element would lead to them

'''


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if nums  == [] or len(nums) < 1:
            return
        
        missing_no = []
        for i in range(len(nums)):
            abs_val = abs(nums[i])-1
            if nums[abs_val] > 0:
                nums[abs_val] *= -1
                
        for i in range(len(nums)):
            if nums[i] > 0:
                missing_no.append(i+1)
                
        return missing_no
                
        
            
        