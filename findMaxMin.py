# Time Complexity : O(n), where n is the length of nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : N.A.
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    # for every pair in the array compare the pair and compare the smaller number with
    # the minimum to return and the bigger one to the maximum to return, by doing this we
    # make only 3 comparisons for every 2 numbers instead of 2 comparisons for every number.
    # resulting in 3n/2 comparisons rather than 2n comparisons.
    def find(self, nums):
        minVal, maxVal, idx = float('inf'), float('-inf'), 0

        while idx < len(nums)-1:
            if nums[idx] < nums[idx+1]:
                if nums[idx] < minVal:
                    minVal = nums[idx]
                if nums[idx+1] > maxVal:
                    maxVal = nums[idx+1]
            else:
                if nums[idx+1] < minVal:
                    minVal = nums[idx+1]
                if nums[idx] > maxVal:
                    maxVal = nums[idx]
            idx += 2
        # in case of an array of odd length
        if idx == len(nums)-1:
            if nums[idx] < minVal:
                minVal = nums[idx]
            if nums[idx] > maxVal:
                maxVal = nums[idx]

        return "minVal", minVal, "maxVal", maxVal


print(Solution().find([800,4,7,8,90,100,550]))


