#LC 448
# Time Complexity : O(N)
# Space Complexity : O(N)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        sset = set(nums)
        res = []
        for i in range(1,len(nums)+1):
            if i not in sset:
                res.append(i)
        return res
        