# Time Complexity --> O(n)
# Space Complxity --> O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        re = []

        for i in range(n):
            index = abs(nums[i])-1
            if nums[index]>0:
                nums[index] = -1*nums[index]

        for i in range(n):
            if nums[i]>0:
                re.append(i+1)
            nums[i] = abs(nums[i])
        return re 

