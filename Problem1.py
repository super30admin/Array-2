#find-all-numbers-disappeared-in-an-array
# time complexity : 0(n)
#space complexity :0(1)
#Did this code successfully run on Leetcode :yes
class Solution(object):
    def findDisappearedNumbers(self, nums):
        
        n = len(nums)
        
        if  n==0:
            return 0
        
        for i in range(n):
            
            if nums[abs(nums[i]) - 1] > 0:
                nums[abs(nums[i]) - 1] = -1* nums[abs(nums[i]) - 1]
            
        result = []
        print(nums)
        for i in range(n):
            if nums[i] > 0:
                result.append(i+1)
                
        return result
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        