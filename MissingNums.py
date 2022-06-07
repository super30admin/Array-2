Time Complexity: O(n)
Space Complexity: O(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index] > 0:
                nums[index] *= -1
        
        res = list()
            
        for i in range(1, len(nums)+1):
            if nums[i-1] > 0:
                res.append(i)
        
        return res
                
            
