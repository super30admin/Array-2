# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return []
        result = []
        # check each number in array
        for i in range(len(nums)):
            # go to its index and make it negitive if it is not
            if nums[abs(nums[i])-1] >0:
                nums[abs(nums[i])-1] *=-1
        #check if there is a non negative index if yes append the number that should be in this place
        for i in range(len(nums)):
            if nums[i] >0:
                result.append(i+1)
        return result
                