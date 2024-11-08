# The code defines a findDisappearedNumbers method to find all numbers that are missing from an array containing integers from 1 to n.
# The missing numbers are those that do not appear in the array.

# Steps:
#   - Convert 'nums' into a set called 'set_nums' to allow for efficient lookup of elements.
#   - Initialize an empty list 'missing' to store numbers that are not present in 'nums'.
#   
#   - Iterate over each integer 'i' from 1 to n (where n is the length of 'nums'):
#       - If 'i' is not in 'set_nums', it means 'i' is missing from the array, so append 'i' to 'missing'.
#   
# Final Result:
#   - After checking all numbers from 1 to n, 'missing' contains all the numbers that are absent from the array, which is returned.

# TC: O(n) - Converting the list to a set and iterating over the range both take linear time.
# SC: O(n) - The space complexity is linear due to the set and the output list of missing numbers.


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        set_nums = set(nums)
        missing = []

        for i in range(1,len(nums)+1):
            if i not in set_nums:
                missing.append(i)

        return missing
