# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def findDisappearedNumbers(self, nums):
        if not nums:
            return []
        
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
        
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
            else:
                nums[i] *= -1  # Restore the array to its original state
        
        return result

# Example 1
solution = Solution()
nums1 = [4, 3, 2, 7, 8, 2, 3, 1]
print(solution.findDisappearedNumbers(nums1))  # Output: [5, 6]

# Example 2
nums2 = [1, 1]
print(solution.findDisappearedNumbers(nums2))  # Output: [2]

# Example 3
nums3 = [2, 2, 3, 1]
print(solution.findDisappearedNumbers(nums3))  # Output: [4]