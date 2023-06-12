# Time complexity : O(n)
# Space complexity : O(1) when we update the value of nums inplace

# The code ran on Leetcode

# For every element in nums, go to the corresponding index and update its value to -1. Store the value before updating and change that corresponding index to -1. At the end, indices in nums with value not equal to -1 are not present in the input array.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # arr = [0]*(len(nums))

        # for n in nums:
        #     arr[n-1] = 1
        # res = []
        # for i in range(len(arr)):
        #     if arr[i] == 0:
        #         res.append(i+1)
        # return res

        for i in range(len(nums)):
            if nums[i] != -1:
                next_index = nums[i] - 1

                while nums[next_index] != -1:
                    new = nums[next_index] - 1
                    nums[next_index] = -1
                    next_index = new
        res = []
        for i in range(len(nums)):
            if nums[i] != -1:
                res.append(i+1)

        return res