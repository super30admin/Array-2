# Time Complexity O(n)
# Space Complexity O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        maximum = len(nums)
        res = [0 for i in range(maximum)]
        ans = []
        print(res)
        for i in range(0, len(nums)):
            res[nums[i]-1] = nums[i]
        x = 0
        for j in range(len(res)):
            if res[j] == 0:
                ans.append(j+1)
            else:
                res[j] = 0
        del res
        return ans
