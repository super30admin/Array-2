class Solution:
    def findDisappearedNumbers(self, nums):
        output=[]
        for i in nums:
            index=abs(i)-1
            
            if(nums[index]>0):
                nums[index]*=-1
                
        for i in range(len(nums)):
            if nums[i]>0:
                output.append(i+1)
                
        return output
        
