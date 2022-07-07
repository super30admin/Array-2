
# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        
        for i in range(len(nums)):
            #taking absolute value as we are negating the visited numbers.
            ind=abs(nums[i])-1
            if nums[ind] > 0:
                nums[ind]*=-1
                
        res=[]        
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)    
                
        return res        