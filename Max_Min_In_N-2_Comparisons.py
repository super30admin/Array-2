# Problem link : https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
# Time Complexity : O(n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
    Brute force approach => Traverse through the array and maintain two variables for max and min values
    
    N-2 comparisons approach => Take two elements at a time. Compare them and only compare the bigger out of two with max and smaller out of two with min so far. This avoids unnecessary comparison of every element with both max and min.
    So for every two elements we make 3 comparisons instead of 4 and save one comparison
    
'''


class Solution:
    def findMinMax(self, nums):
        # edge case
        if not nums or len(nums) == 0:
            return []
        
        # intialize max and min
        min_num = float('inf')
        max_num = float('-inf')        
        # traverse the input array
        for i in range(len(nums) - 1):
            if nums[i] > nums[i+1]:
                min_num = min(nums[i+1],min_num)
                max_num = max(nums[i],max_num)
            else:
                max_num = max(nums[i+1],max_num)
                min_num = min(nums[i],min_num)
        
        if len(nums) % 2 != 0:
            min_num = min(min_num,nums[i])
            max_num = max(max_num,nums[i])

        return [max_num,min_num]

s = Solution()
print(s.findMinMax([1,2,3,4,5]))