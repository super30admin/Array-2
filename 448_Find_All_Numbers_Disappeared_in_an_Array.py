# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # initailize a res list of size same as nums with all values as 0
        res = [0 for i in range(len(nums))]
        
        # Update the value at the corresponding index in res
        for num in nums:
            res[num-1] = 1
        # If 2 numbers are missing,then tranfer those two index to the first two index of res 
        anchor = 0
        for i, num in enumerate(res):
            if num == 0:
                res[anchor] = i+1
                anchor+=1
        return res[:anchor]