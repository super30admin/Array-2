# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Use the input array itself to track which numbers have been seen by marking their corresponding indices as negative.
# After marking, any index that remains positive indicates that its number was never visited.
# Collect all such indices + 1 to get the list of missing numbers.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        output = []
        for i in range(len(nums)):
            idx = abs(nums[i])-1
            if nums[idx]>0:
                nums[idx] = -1*nums[idx]
        for i in range(len(nums)):
            if nums[i]>0:
                output.append(i+1)
        return output