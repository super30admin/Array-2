# Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

class Solution:
    def get_min_max(self, nums):
        min_ = 10**13
        max_ = 0
        for i in range(0,len(nums)-1):
            if nums[i] < nums[i+1]:
                min_ = min(min_,nums[i])
                max_ = max(max_,nums[i+1])
            else:
                min_ = min(min_,nums[i+1])
                max_ = max(max_,nums[i])
                
        return [min_,max_]