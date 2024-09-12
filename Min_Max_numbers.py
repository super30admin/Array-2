  ---------------------- Minimum and maximum numbers in the array------------------------------------------------   
# Time Complexity : O(N) N is the length of the nums.
# Space Complexity : O(1) as I am returning the same array
# Did this code successfully run on Leetcode : No I did not find this problem
# Any problem you faced while coding this : No
# 
# Here I have used  same array given and compared the first and last element by moving the minimum elements to first position and maximum position to last position.
#Comparing only with first and last elements. So when we are leaving first and last element comparisions, our comparisions will reduce by 4
# Maximum comparisons will be 2*(n-2)+1

class Solution:
    def findMinAndMax(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        n = len(nums)-1
        
        swap = 0
        if nums[n-1]<nums[0]:
        	nums[0], nums[n-1] = nums[n-1], nums[0]
        	
        for i in range(1,n-1):
        	if nums[i]<nums[0]:
        		nums[i], nums[0] = nums[0], nums[i]
        	elif nums[i]>nums[n-1]:
        		nums[i], nums[n-1] = nums[n-1], nums[i]
        			
        return [nums[0], nums[len(n-1)]
        	