# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution():

    def minMax(self, nums):

        if len(nums) / 2 != 0:
            i = 1
            finalMax = nums[0]
            finalMin = nums[0]
        else:
            i = 2
            if nums[0] >= nums[1]:
                finalMax = nums[0]
                finalMin = nums[1]
            else:
                finalMax = nums[1]
                finalMin = nums[0]

        for i in range(i, len(nums), 2):
            if nums[i+1] > nums[i]:
                currentMax = nums[i+1]
                currentMin = nums[i]
            else:
                currentMax = nums[i]
                currentMin = nums[i + 1]

            if currentMax > finalMax:
                finalMax = currentMax
            if currentMin < finalMin:
                finalMin = currentMin

        return [finalMin, finalMax]

obj = Solution()
print(obj.minMax([5, 4, 3, 2, 1]))
print(obj.minMax([1, 2, 3, 4, 5]))