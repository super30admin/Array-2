"""
Approach:

use encoding method. Since the number of elements in the array would always be 1 to n and the indices go from 0 to n-1
we can encode each element such that:

1) each element value can be considered as an index
2) visit the element at our new index and mark it as visited
    a) mark it as negative
3) since there are some numbers missing in the given array, there would some new/encoded indices missing
4) At these encoded indices you'd find the numbers missing from the original array
    a) this can be done by reversing our encoding process i.e. missing number = original index -1

"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        out = []
        n = len(nums)
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > -1:
                nums[index] *= -1

        for i in range(n):
            if nums[i] > -1:
                out.append(i + 1)
            else:
                nums[i] *= -1
        return out


"""
TC: O(n)
SC: O(1)
"""