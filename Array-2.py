# TC=O(N)
# SC=O(1)
# 1. for each value present in list,go to its respective index and multiply with -1.
# 2. the indexes with values greater than 0 are the missing indexes.
class Solution1:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        length=len(nums)
        result=[]
        if length== 0: return result
    
        
        for index in range(0,length,1):
            val=abs(nums[index])-1
            if nums[val]>0:
                nums[val]=-1*nums[val]
        
        for index in range(0,length,1):
            if nums[index]>0:
                result.append(index+1)
                
        return result
		
		
		

		
