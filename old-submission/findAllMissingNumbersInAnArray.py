class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        for i in range(0,len(nums)):
            
            # Get the val 
            val = abs(nums[i])
            
            # Set the index
            index = val-1
            
            if nums[index] > 0:
                # Go to index and set the no as -ve
                nums[index] = -1 * nums[index]
        
        
        # Go-to +ve numbers and index+1 is the missing number 
        resultList = []
            
        for i in range(0,len(nums)):
            if nums[i] > 0:
                index = i +1
                resultList.append(index)
        
        return resultList