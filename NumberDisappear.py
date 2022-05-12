'''
time complexity: O(n)
space complexity: o(1)
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        for i in range(0,len(nums)):
            if(nums[abs(nums[i])-1] > 0):
                nums[abs(nums[i])-1]*=-1
        res = []
        for i in range(0,len(nums)):
            if(nums[i] > 0):
                res.append(i+1)
        return res