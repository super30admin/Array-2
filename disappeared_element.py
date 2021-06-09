# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    def findDisappearedNumbers(self, nums):
        #         Defining output array
        out_arr = []

        #         Iterate over array and take the number  - 1 index and make that value at that index as negative
        for i in range(len(nums)):
            curr_index = abs(nums[i]) - 1
            if nums[curr_index] > 0:
                nums[curr_index] = nums[curr_index] * -1

        #         Again iterate over input array and restore array to its original state and result will be positive elements index + 1
        for i in range(len(nums)):
            if nums[i] > 0:
                out_arr.append(i + 1)
            else:
                nums[i] = nums[i] * -1
        #         return output array
        return out_arr

        """
        :type nums: List[int]
        :rtype: List[int]
        """
