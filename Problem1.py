class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums == [] or len(nums) == 0:
            return []
        
        result = []
        for i in range(0,len(nums)):
            index = abs(nums[i])-1
            
            if (nums[index] > 0):
                nums[index] *= -1
        
        for i in range(0,len(nums)):
            print(i, index)
            index = abs(nums[i])-1
            
            if (nums[index] > 0):
                result.append(i+1)
            
            else:
                nums[i] *= -1
                
        
        return result
