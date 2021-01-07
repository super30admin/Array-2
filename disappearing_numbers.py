class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for num in nums:
            idx = abs(num) - 1
            nums[idx] = - (abs(nums[idx]))
            
        return [i+1 for i in range(len(nums)) if nums[i] > 0]
        
        
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        
        