'''
Time: O(n)
Space: O(n)
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res={i for i in range(1,len(nums)+1)}
        for num in nums:
            if num in res:
                res.remove(num)
        return res