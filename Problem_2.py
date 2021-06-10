from typing import List
class Solution:
    def findMinMax(self, nums: List[int]) -> List[int]:
        maximum = 0
        minimum = float('inf')
        for i in range(0,len(nums),2):
            if nums[i] > nums[i+1]:
                maximum = max(maximum,nums[i])
                minimum = min(minimum,nums[i+1])
            else:
                minimum = min(minimum,nums[i])
                maximum = max(maximum,nums[i+1])         
        return[maximum, minimum]

        
obj = Solution()
print(obj.findMinMax([1,2,3,4,5,5,67,2]))

# Time Complexity: O(n)
# Space Complexity: O(1)
# Number of Comparisons are reduced from 2 times to just 1.5 times