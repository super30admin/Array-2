#All TC passed on leetcode

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        #Here we change the nums array form. For each num in the array we make the element 
        #at num-1 position -ve. Then we traverse the nums array again to see if any num is 
        #positive then it means that the index+1 num is missing.
        #Time complexity - O(n)
        #Space complexity - O(1)
        for i in range(len(nums)):
            n = abs(nums[i])
            if nums[n-1]>0:
                nums[n-1]*=-1

        res = []
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
            else:
                nums[i] = abs(nums[i]) #if interviewer asks to have original nums array back.

        return res
        