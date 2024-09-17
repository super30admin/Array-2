# Time Complexity : O(nlogn) for sorting
# Space Complexity : O(N) for storing the sorted values
# Did this code successfully run on Leetcode : Problem is not on leetcode
# Any problem you faced while coding this : Couldn't come up with optimal approach


# Your code here along with comments explaining your approach



class Solution(object):

    def findmaxmin(self,nums):
        #Edge case
        if nums == None or len(nums) == 0:
            return [-1,-1]
        #Sort array
        nums = sorted(nums)
        #Return first and last elements
        return [nums[0],nums[len(nums)-1]]


nums = [3,1,5,6,8]
result = Solution().findmaxmin(nums)

print(result)