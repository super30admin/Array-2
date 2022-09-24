# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if nums is None or len(nums) == 0: return
        
        temp = [0] * (len(nums)+1)
        for i in nums:
            temp[i] += 1
 
        result = []
        for i in range(1,len(temp)):
            if temp[i] == 0:
                result.append(i)
        return result