"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
For this, we will iterate through the array. At every point, we will calculate the absolute value of the number.
If i get 4, then its location should be arr[3], so i will go to that index and multiply the number by -1.
I am doing so because,k when i iterate through the array again, if i encounter a number which is not negative, 
that means, the number corresponding to that index is not present in that array. Hence we return index+1
"""


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return []
        result = []
        for i in range(len(nums)):
            val = abs(nums[i])
            if nums[val-1] > 0:
                nums[val-1] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return(result)
