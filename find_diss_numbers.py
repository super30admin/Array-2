# Time complexity is O(n). We use a two pass approach. This method is know as the State change approach
#  Space complexity is O(1)
# This approach works only because we have a range of numbers given(1,n) in the array and the array is also promised to be of length n.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) == 0:
            return []
        for i in range(len(nums)):
            idx = abs(nums[i])-1
            if nums[idx] > 0:
                nums[idx] *= -1
        lst = []
        for i in range(len(nums)):
            if nums[i] > 0:
                lst.append(i + 1)
        return lst
