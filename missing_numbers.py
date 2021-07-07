#Time Complexity :  O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no



class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        
        
        if len(nums)==0:
            return []
        
        
        for num in nums:
            index = abs(num)
            if nums[index-1] >0 :
                nums[index-1] = -1 * nums[index-1]
        result = []
        for index,ele in enumerate(nums):
            if ele > 0 :
                result.append(index+1)
            else:
                nums[index] = -1*nums[index]
        
        return result