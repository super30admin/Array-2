# Time Complexity: O(n), where n = length of input array
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach:
# 1. We traverse through all the elements in the input array
# 2. For each element, we go to the index, it is supposed to be if the array was sorted, and make the element negative, indicating that the element at that index is present in the array.
# 3. Finally, if an element is still positive, it means that the element that is supposed to be at that index is not present in the array.
# 4. We append index+1 to the result

from typing import List
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # 1st pass -> making elements negative at their supposed indices
        for i in range(len(nums)):
            idx = abs(nums[i])
            if nums[idx-1] > 0:
                nums[idx-1] *= -1
        
        res = []
        # 2nd pass -> Looking for positive elements
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
        return res