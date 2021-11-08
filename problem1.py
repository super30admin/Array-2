class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        hash_map = set()
        for num in nums:
            hash_map.add(num)
        for i in range(1, len(nums)+1):
            if i not in hash_map:
                result.append(i)
        return result