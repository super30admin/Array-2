class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) == None: return []
        result= []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -1 * nums[index]
        
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] = -1 * nums[i]
                
            else:
                result.append(i + 1)
        return result
    
    
# T.C => O(n)
# S.C => O(1)

# Approach => Here we are taking the index and conversting the index value to possitive -1 and storing in index variable. then we are travelling to nums[index] value to make that respective value to positive. 
# At the end in the second pass whatever number which are left positive after first pass there index are taken and adding one to it while storing it to a array and returning that value
                
            
                
                
        