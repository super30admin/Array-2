# Time Complexity : O(n), no of elements in the given array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# we are iterating the list and since the range is 1 to n we can take help from indices
# we iterate the list, and for every value, we see the idea index, where that bvalue would be if the list was sorted
# then, at that index, we make the value -ve
# so if a nums[i] is not already -ve, we make it negative
# and this shows that index + 1 = value exists in the list
# any positive value left, so this means that index + 1 value does not exist in the given list


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if len(nums) == 0:
            return []

        output = []
        n = len(nums)

        # range of the values is 1 to n
        for i in range(n):
            # the current value is nums[i], it should ideally be at index nums[i] - 1
            # but this nums[i] can be -ve thats why we have to use abs
            ideal_idx = abs(nums[i]) - 1
            # if the value at the idea index is not already -ve
            if nums[ideal_idx] > 0:
                # we make it -ve => to signify that this index + 1 value exists in the list
                nums[ideal_idx] = nums[ideal_idx] * -1
        
        for i in range(n):
            # now we check what all values are +ve
            if nums[i] > 0:
                # so that index + 1 value does not exist in the list
                output.append(i + 1)

        return output


        