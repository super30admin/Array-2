"""
Approach: use array as hashmap and mark indexes -> nums[i] - 1 as their -nums[(nums[i] - 1)] denoting nums[i] was found
t.c. => O(n)
s.c. => O(1)
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        n = len(nums)
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] < 0:
                continue
            
            nums[index] = - nums[index]
        
        for i in range(n):
            if nums[i] > 0:
                res.append(i + 1)
        return res