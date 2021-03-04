class Solution(object):
    def findDisappearedNumbers(self, nums):
        result = []
        for i in range(len(nums)):
            temp = abs(nums[i])
            temp = temp-1
            if nums[temp] > 0:
                nums[temp] = nums[temp] * -1
            
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        
        #runtime = O(n)
        # space = O(1)