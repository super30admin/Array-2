class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        l=[]
        
        for i in nums:   
            if i<0:
                i=abs(i)
            
            if nums[i-1]>0:
                nums[i-1]= nums[i-1]*-1
            
            
        for i in range(len(nums)):
            if nums[i]>0:
                l.append(i+1)
                
        return l
                
                
            
        
            
                
                
                
        