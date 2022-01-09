class Solution:
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        
        # Iterate over each of the elements in the original array
        for i in range(len(nums)):
            
            # Treat the value as the new index
            new_index = abs(nums[i]) - 1
            
            # Check the magnitude of value at this new index
            # If the magnitude is positive, make it negative 
            # thus indicating that the number nums[i] has 
            # appeared or has been visited.
            if nums[new_index] > 0:
                nums[new_index] *= -1
        
        # Response array that would contain the missing numbers
        result = []    
        
        # Iterate over the numbers from 1 to N and add all those
        # that have positive magnitude in the array 
        for i in range(1, len(nums) + 1):
            if nums[i - 1] > 0:
                result.append(i)
                
        return result   
    
    def subOptimalfindDisappearedNumbers(self, nums: List[int]) -> List[int]:
        hash_ = {}
        r = []
        for i in nums:
            hash_[i] = 1
        for i in range(1, len(nums)+1):
            # print(i)
            if i not in hash_:
                r.append(i)
        return r
    
    def BruteForcefindDisappearedNumbers(self, nums: List[int]) -> List[int]:
        r = []
        for i in range(1, len(nums)+1):
            if i not in nums:
                r.append(i)
        return r
        
