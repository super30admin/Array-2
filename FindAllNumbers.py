#Time complexity :O(n)
#space complexity :O(n)
#Leetcode submission:successful
#we are using a hash set and then we are going checking from 1 to len(array) to see if it is there in #the set or not and if not then we add it to the result set
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        H=set(nums)
        result=[]
        for i in range(1,len(nums)+1):
            
            if i not in H:
                result.append(i)
        return result