"""
https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
TC- Odd - 3/2N, Even- 1 + 3/2N, SC- O(1)
Challenge - analyzing number of comparisons
FAQ-
What other approaches can you use?
Divide and conquer - divide array until two elements are left and one comparison do
one comparison to compare both min and max (given min and max comparison don't count), combine all to compare min with
other min and max (recursion will take care of comparison)
Tournament problem - find a lecture online
One interation - check both min and max for each element in the same element:

Refer geekforgeeks link for actual time complexity comparison
"""

'''
*Most optimized solution*
Idea - using pair method. At every point between two elements one will be greater than the other, compare previous max
with greater element and previous min with smaller element making total comparisons Odd - 3/2N, Even- 1 + 3/2N

NOTE - You need to start with initial min and max to compare against each. To do that, for even, compare first two
element to find min and max, for odd the first element will be the min and max. This will leave the array with two pairs
'''


class Solution:
    def minMax(self, nums):
        n = len(nums)
        if n == 1:
            return [nums[0], nums[0]]
        # if even length initialize min max with first two elements
        if n % 2 == 0:
            if nums[0] > nums[1]:
                min_ = nums[1]
                max_ = nums[0]
            else:
                min_ = nums[0]
                max_ = nums[1]
        # if odd length initialize min max with one element
        else:
            min_ = nums[0]
            max_ = nums[0]

        i = 0
        while i < n - 1:
            if nums[i] > nums[i + 1]:
                max_ = max(max_, nums[i])
                min_ = min(min_, nums[i + 1])
            else:
                max_ = max(max_, nums[i + 1])
                min_ = min(min_, nums[i])

            i += 2

        return [min_, max_]


nums = [5, 4, 2, 3, 1, 0]
[mn, mx] = Solution().minMax(nums)
print('min: ', mn, ' max: ', mx)
