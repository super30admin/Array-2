# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :no
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Initialize the global min and max by comparing the first one or two elements.
# Scan the array in pairs, comparing each pair to find a local min and max.
# Update the global min and max using each pair’s local results to reduce total comparisons.

class Problem2:

    def findMinAndMax(self, nums):
        if not nums:
            return None, None

        # Initialize
        if len(nums) % 2 == 0:
            # Compare first pair
            if nums[0] < nums[1]:
                min_num, max_num = nums[0], nums[1]
            else:
                min_num, max_num = nums[1], nums[0]
            start = 2
        else:
            # Odd length, start with first element
            min_num = max_num = nums[0]
            start = 1

        # Compare in pairs
        for i in range(start, len(nums), 2):
            if nums[i] < nums[i+1]:
                local_min = nums[i]
                local_max = nums[i+1]
            else:
                local_min = nums[i+1]
                local_max = nums[i]

            min_num = min(min_num, local_min)
            max_num = max(max_num, local_max)

        return min_num, max_num
