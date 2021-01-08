#Time Complexity :o(n)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if(len(nums)==0 or nums==None):
            return []
        
        ans=[]
        for i in range(len(nums)):
            index=abs(nums[i])-1
            if(nums[index]>0):
                nums[index]*=-1
                
        for i in range(len(nums)):
            if(nums[i]>0):
                ans.append(i+1)
        return(ans)
                