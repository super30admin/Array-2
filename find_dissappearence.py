"""
Approach recursively mark positions of array elements in place. 
Iterate over array again and return indices where elements != -1

Time complexity O(n)
Space complexity O(1)
"""


class Solution(object):
    
    def place(self, element, nums) :
        if element == -1 :
            return 
        nxt = nums[element -1 ]
        if nxt == -1 :
            # cannot place element 
            return        
        nums[element -1 ] = -1 # mark elemnt-1 index as visited
        return self.place(nxt,nums)
        
        
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        self.missing = []
        self.nums = nums
        
        for i in nums :
            self.place(i, nums)

        missing = []
        for i in range(len(nums)):
            if nums[i] != -1 :
                missing.append(i+1)
        return missing 
        
        
