# TC: O(n)
# SC: O(n)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        dict1={}
        for i in range(1, len(nums)+1):
            dict1[i] = 0

        for i in nums:
            if i in dict1:
                dict1[i] = 1

        res = []
        for i in dict1:
            if dict1[i] == 0:
                res.append(i)

        return res


