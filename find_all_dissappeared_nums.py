# tc : O(n)
# sc : O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            pos = abs(nums[i]) - 1
            nums[pos] = -1*abs(nums[pos])
        res = []    
        for i in range(len(nums) ):
            if nums[i] > 0:
                res.append(i+1)
        return res        
            