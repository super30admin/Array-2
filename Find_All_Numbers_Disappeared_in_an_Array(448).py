# Time Complexity: O(N)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here what we do is, while traversing through the array
# we check the index equal to the value of the current element
# e.g = [4,3,2,7,8,2,3,1]
# here we first check index = 4 and mark the element at that index as negative
# indicating that the element = that index is present in the array
# we take the absolute of every index as the element = that index
# might have been traversed and already be negative
# at the index the indices where the element is still positive
# are the indices(or values) that are missing from the array
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = list()

        for elem in nums:
            elem = abs(elem)
            if nums[elem-1] > 0:
                nums[elem-1] *= -1

        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
        return res