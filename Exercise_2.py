class Solution:
def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

    l = len(nums) + 1
    nums = set(nums)
    missing = []
    for i in range(1, l):
        
        if i not in nums:
            missing.append(i)
                
    return missing   