'''

TC: O(n)
SC: O(1)

Intuition: using the fact that 1<=nums<=n where n is the length of array and index of the array + range
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return nums
        
        idx = 0
        res = list()
        
        for i in range(len(nums)):
            idx = abs(nums[i]) - 1
            nums[idx] = -1 * abs(nums[idx])
            
        for i in range(len(nums)):
            if not nums[i] < 0:
                res.append(i+1)
        
        return res
            
                
        