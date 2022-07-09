# Time Complexity = O(n)
# Space Compelxity = O(1)


class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        if len(nums) == 0 or nums == None:
            return []
        
        n = len(nums)
        result = [] * n
        
        # Range = 1 - n, indexes in nums = 0 - n-1. This means 1-1, 2-1, 3-1... n-1 element values must be present in the array. 
        # Logic: Finding index from the above method and making the element at that index -ve.
        for i in range(n):
            index = abs(nums[i]) - 1
            
            if(nums[index] > 0):
                nums[index] = nums[index] * (-1)
        
        # Elements that remain +ve after the entire traversal, means that they weren't visited even once during traversal. Value of those elements = i + 1
        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)
                
        
        return result