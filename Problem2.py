#Time Complexity - O(n)
#Space Complexity - O(1)
class Solution:
    def findMaxMin(nums):
        maxElement = float("-inf")
        minElement = float("inf")
        for x in nums:
            maxElement = max(maxElement, x)
            minElement = min(minElement, x)
        
        return [maxElement,minElement]
