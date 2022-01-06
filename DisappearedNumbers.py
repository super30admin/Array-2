# Time Complexity : O(N)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if(nums == None):
            return None
        
        for a in range(0,len(nums)):
            index = abs(nums[a]) -1
            
            if(nums[index] >0):
                nums[index] = nums[index]*-1
        
        print(nums)
        result = []
        for a in range(0,len(nums)):
            if nums[a]>0:
                result.append(a+1)
        
        return result
                
            