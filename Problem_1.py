# Find Missing Number

# Time Complexity : O(N)
# Space Complexity : 1.O(N) 2.O(1)
# Did this code successfully run on Leetcode : Yes, Runtime: 340 ms and Memory Usage: 20.7 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
The two approach to solve the problem are:
Approach 1. Using Hashmap where all the numbers of array are tracked. After passing it
we find out missing elements.If there is no entry, that missing number is added to a output array 
that will be reeturned from the function eventually.  

"""
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        output=[]
        count_map={}
        for i in nums:
            count_map[i]=1
        for i in range(1,len(nums)+1):
            if i not in count_map:
                output.append(i)
        return output
"""
Approach 2. The subtraction of 1 will be done from numbers at index and the numbeer at index
is turned negative. The other pass is run which multiplies iand f we find number at any of the indexes to be positive, it means, no number was found for this index, so if i and j are the indexes 
// which have positive numbers, it means i and j are the disappeared numbers and output is returned.
"""
class Solution(object):
    def findDisappearedNumbers(self, nums):
        for i in range(len(nums)):
            index=abs(nums[i])-1
            if nums[index]>0:
                nums[index]*=-1
        output=[]
        for i in range(1,len(nums)+1):
            if(nums[i-1]>0):
                 output.append(i)
        return output