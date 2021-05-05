#Running Complexity: O(n)
#Space Running: Constant or (1)
#Successfully Run and Compiled on leetcode 
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        if len(nums)==None:
            return None
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index]>0:
                nums[index] *=-1
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        return result