# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def findMinAndMax(self, nums):
        if not nums:
            return []
        minVal = float('inf')
        maxVal = float('-inf')
        n = len(nums)
        i = 0
        while i<=n-2 :
            if nums[i]<nums[i+1] :
                minVal = min(minVal, nums[i])
                maxVal = max(maxVal, nums[i+1])
            else :
                minVal = min(minVal, nums[i+1])
                maxVal = max(maxVal, nums[i])
            i += 2
        if n%2 == 1 :
            minVal = min(minVal, nums[n-1])
            maxVal = max(maxVal, nums[n-1])
        return [minVal, maxVal]

# Example 1
solution = Solution();
nums = [4, 3, 2, 0, 8, 2, 3]
print(solution.findMinAndMax(nums)) # Output : [0, 8]

# Example 2
nums = [1, 1]
print(solution.findMinAndMax(nums)) # Output : [1, 1]

# Example 2
nums = [4, -3, 2, 0, 8, 2, 3, 50]
print(solution.findMinAndMax(nums)) # Output : [-3, 50]