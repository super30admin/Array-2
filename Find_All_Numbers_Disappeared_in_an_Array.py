class Solution:
    
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        # Iterate through array and mark all indexes for which the number exists
        for num in nums:
            value_at_index = nums[abs(num)-1]
            nums[abs(num)-1] = -value_at_index if value_at_index > 0 else value_at_index
        
        result = []
        
        # The unvisited ones i.e. numbers which are not marked (positive int) are the index of interest
        for index,num in enumerate(nums):
            if num > 0:
                result.append(index+1)
        
        return result

### Complexity Analysis
# Time Complexity: O(N) --> Iterating through array
# Space Complexity: O(1) --> No extra space used

