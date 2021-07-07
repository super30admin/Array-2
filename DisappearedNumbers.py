# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        result = []
        if nums == None or len(nums) == 0:
            return result

        for i in range(len(nums)):
            index = abs(nums[i]) - 1  # Taking the absolute value
            if nums[index] > 0:  # If number is positive
                nums[index] = -1 * nums[index]  # Make the number negative

        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] = -1 * nums[i]  # change the state to original
            else:
                result.append(i + 1)

        return result