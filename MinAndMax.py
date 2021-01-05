class MinAndMax(object):

    '''
    Solution:
    1. Instead of traversing one element at a time, traverse on a pair of 2 elements at a time, and update overall max
        and min with the pair's max and min if required.
    2. So, instead of having 2n comparisons, we will have 1.5n comparisons.

    --- Passed all the testcases that I could imagine
    '''

    def minAndMax(self, nums):

        # O(n) Time Complexity | O(1) Space Complexity

        if (nums == None or len(nums) == 0):
            return [-1, -1]

        oddLength = 0
        if len(nums) / 2 != 0:
            oddLength = 1

        finalMax = float('-inf')
        finalMin = float('inf')

        for i in range(0, len(nums) - 1, 2):
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

        if (oddLength):
            if nums[len(nums) - 1] > finalMax:
                finalMax = nums[len(nums) - 1]
            if nums[len(nums) - 1] < finalMin:
                finalMin = nums[len(nums) - 1]

        return [finalMin, finalMax]

# obj = MinAndMax()
# print(obj.minAndMax([5, 4, 3, 2, 1]))
# print(obj.minAndMax([1, 2, 3, 4, 5]))
# print(obj.minAndMax([4, 4, 3, 2, 1]))
# print(obj.minAndMax([2, 4, 3, 5, 1]))
