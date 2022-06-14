class Solution(object):
    def findDisappearedNumbers(self, nums):
        for i in range(len(nums)):

            nums[abs(nums[i])-1]=-1*abs( nums[abs(nums[i])-1])      
        result = []    

        for i in range(1,len(nums)+1):
            if nums[i-1] > 0:
                result.append(i)
                
        return result  