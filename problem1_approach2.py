# time complexity: O(n)
# space complexity: O(n)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        numset = set(nums)
        result = []

        for i in range(1, n+1):
            if i not in numset:
                result.append(i)
        return result