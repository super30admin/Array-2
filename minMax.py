"""
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

Time = O(n); n = number elements in array
space = O(1); constant space

Approach - 
1. Compare first and second element in array and assign min and max value
2. Go through rest of the elements in array and update min and max value 

"""

class MinMax:
    def minMax(self,nums):
        if not nums:
            return
        
        min_ele = 0
        max_ele = 0
        
        if len(nums) == 1:
            min_ele = max_ele = nums[0]
        
        if nums[0] > nums[1]:
            min_ele = nums[1]
            max_ele = nums[0]
           
        else:
            min_ele = nums[0]
            max_ele = nums[1]
            
        for i in range(2,len(nums)-1):
            if max_ele < nums[i]:
                max_ele = nums[i]
            elif min_ele>nums[i]:
                min_ele = nums[i]
                
        return min_ele,max_ele
        