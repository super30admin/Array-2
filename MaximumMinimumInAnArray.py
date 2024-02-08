'''
TC: O(n)
SC: O(1)
'''
from typing import List

class Solution:
    def maxMinInArray(self, nums: List[int]) -> (int,int):
        max_, min_ = -float('inf'), float('inf')
        if len(nums)%2==0:
            end = len(nums)
            flag = False
        else:
            flag = True
            end = len(nums)-1
        for i in range(0,end,2):
            if nums[i]<nums[i+1]:
                max_ = max(max_, nums[i+1])
                min_ = min(min_, nums[i])
            else:
                max_ = max(max_, nums[i])
                min_ = min(min_, nums[i+1])
        
        if flag:
            max_ = max(max_, nums[-1])
            min_ = min(min_, nums[-1])
        return (max_, min_) if max_!=-float('inf') and min_!=float('inf') else (-1,-1)
s = Solution()
print(s.maxMinInArray([4,3,2,7,8,2,3,1]))
print(s.maxMinInArray([1,1]))
print(s.maxMinInArray([3,2,1]))