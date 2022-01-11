#Time Complexity O(n)
#Space Complexity O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for x in range(len(nums)):
            val = abs(nums[x])-1
            if nums[val]>0:
                nums[val] =nums[val] * -1
        res = []
        
        for x in range(len(nums)):
            if nums[x]>0:
                res.append(x+1)
        return res
            
                
                
            
        
