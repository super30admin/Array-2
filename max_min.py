# Time Complexity: O(1.5 * n)
# Space Complexity: O(1)
class Solution:
    def findMinMax(self, nums):
        # Define max and min as 0
        size = len(nums)
        max_ele = 0
        min_ele = 0
        i = 0
        # if size of input is even then define max as max among first two elements
        # and update the next iteration index by 2
        # and if it is odd then update the max and min as first element as update the iteration index by 1
        if size % 2 == 0:
            max_ele = max(nums[0], nums[1])
            min_ele = min(nums[0], nums[1])
            i = 2
        else:
            max_ele = nums[0]
            min_ele = nums[0]
            i = 1
        # Iterate from iteration index as updated before
        while i < size - 1:
            # If current index value  is greater than next index
            # then take max and min accordingly
            if nums[i] > nums[i + 1]:
                max_ele = max(max_ele, nums[i])
                min_ele = min(min_ele, nums[i + 1])
            else:
                max_ele = max(max_ele, nums[i + 1])
                min_ele = min(min_ele, nums[i])
            # Update the i value by 2 as we are comparing in pairs
            i += 2
        # return min and max in the end
        return [min_ele, max_ele]

trial = Solution()
nums = [7, 3, 4, 5, 6, 8, 100, 99]
print(trial.findMinMax(nums))