class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)  # Length of the input list
        result = []

        # Mark the numbers found by negating the values at corresponding indices
        for i in range(n):
            num = nums[i]
            idx = abs(num) - 1
            if nums[idx] > 0:
                nums[idx] *= -1

        # Collect the indices of the numbers that are not marked
        for i in range(n):
            if nums[i] < 0:
                nums[i] *= -1  # Restore original values
            else:
                result.append(i + 1)  # Append missing numbers to the result

        return result


# Time Complexity: O(n)
# Space Complexity: O(1) (ignoring the output list)
