# Approach:
# 1. Iterate through the input array 'nums'. For each element 'n', find the index 'i' where the number 'n' should be
#    (which is abs(n) - 1), and mark the number at index 'i' as negative.
# 2. In the second pass, check all the indices of 'nums'. If any number at index 'i' is positive, it means the number
#    i + 1 is missing from the array, as it was not marked negative in the previous pass.
# 3. Append all such missing numbers to the result list and return it.

# Time Complexity (TC): O(n), where 'n' is the length of the input list 'nums'. 
#                       We iterate through the list twice, so it is linear in time.
# Space Complexity (SC): O(1), since we are modifying the input list in place and using only a constant amount of extra space 
#                        (excluding the output list).

class Solution(object):
    def findDisappearedNumbers(self, nums):
        for n in nums:
            i = abs(n) - 1
            nums[i] = -1 * abs(nums[i])

        res = []
        for i, n in enumerate(nums):
            if n > 0:
                res.append(i+1)

        return res

