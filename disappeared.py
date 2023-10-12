# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# convert list ot set to remove duplicates. 
# then in a for loop from 1 to len(nums)+1 check if each element is present in the set or not. If not append it to the answer array 

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans=[]
        # n=len(nums)
        # print(len(nums))
        s=set(nums)
        for i in range(1,len(nums)+1):
            if i not in s:
                ans.append(i)
        # if len(ans)<=len(nums):
        return ans 

        