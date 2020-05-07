#448. Find All Numbers Disappeared in an Array
#TC-> O(n)+o(n) = O(n)
#SC-> 0(1)


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        if(nums == None or len(nums) == 0):
            return []
        
        for i in range(len(nums)):
            
            
            if(nums[abs(nums[i]) - 1] > 0):
                    nums[abs(nums[i]) - 1] = nums[abs(nums[i]) - 1]*-1
        
        for i in range(len(nums)):
            if(nums[i]>0):
                result.append(i+1)
        return result
        
        
        
            
        
            
    
           