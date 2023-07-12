#Time: O(n)
#space: O(1)
# did the code run: yes
# issues faced: adding elements insetad of indices
# Approach:
# as the elements range between the indices
# mark an element is present by making its corresponding index's element negative
# traverse the array and all the indices with positive numbers are the elements that are missing.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = set()
        for num in nums:
            idx = abs(num)-1
            if nums[idx] > 0:
                nums[idx] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                result.add(i+1)
        return result