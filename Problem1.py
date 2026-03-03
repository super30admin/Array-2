#Find All Numbers Disappeared in an Array
# from typing import List
# Time complexity -> On())
# Space Complexity -> O(1)
# Logic -> Negate the indexes, whicjever index in the end is not negated is the missing no
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(0,len(nums)):
            val = abs(nums[i])
            if nums[val-1]>0:
                nums[val-1] *= -1
        
        result=[]
        for i in range(0,len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result
       

sol = Solution()

print(sol.findDisappearedNumbers([4,3,2,7,8,2,3,1]))

