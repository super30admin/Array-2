class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        for i in range(0,len(nums)):
            index = abs(nums[i])-1
            
            if nums[index] >0:
                nums[index]*=-1
                
            
        result =[]
        
        for i in range(0, len(nums)):
            if nums[i]>0:
                result.append(i+1)
                
        return result
            