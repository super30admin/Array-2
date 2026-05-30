# Time Complexity : O(n) n is length of the array
# Space Complexity : O(1) we dont use any extra space we are doing it in place
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# 1. we are using the same approach as we could do with set that is mark the seen number as negative
#2. however we are doing it in place and then we handle edge case by taking absoulte value of the number at index i because we might have already marked it as negative in the previous iteration so we want to get the original number
#after marking the seen numbers as negative we iterate over the array again to find the number that is not marked negative because we never visited that position and we append to the result
# Your code here along with comments explaining your approach
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res=[]
        #first for loop to mark the numbers that are present in the array as negative
        for i in range(len(nums)):
            # we take the absoulte value of the number at index i because we might have already marked it as negative in the previous iteration 
            # so we want to get the original number
            n=abs(nums[i])
            #we do n-1 because the numbers in the array are from 1 to n
            if nums[n-1]>0:
                nums[n-1]*=-1
        # we iterate over the array again to find the number that is not marked negative because we never visited that position 
        for j in range(len(nums)):
            if nums[j]>0:
                #we append as j+1 because the numbers in the array are from 1 to n and the index starts from 0.
                res.append(j+1)
        return res
            