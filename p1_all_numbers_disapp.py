// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we traversed through the list and for every value we did value-1 as index starts from 0 and at that index=value-1 if the value is negative we leave it else we change it to positive .we do this till we reach the end of the array.From the array we take all the psoitive values index and add 1 then we get all the missing elements.





class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        out=[]
        if len(nums)==0 or nums==None:
            return out
        for i in range(len(nums)):
            index=abs(nums[i])-1
            if nums[index]>0:
                nums[index]=-1*nums[index]
        for i in range(len(nums)):
            if nums[i]>0:
                out.append(i+1)
        return out
                
        