#TC = O(n)
#Sc = O(n)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        set_nums = set(nums)
        missing = []

        for i in range(1,len(nums)+1):
            if i not in set_nums:
                missing.append(i)

        return missing