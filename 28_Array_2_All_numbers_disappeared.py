#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :

#Your code here along with comments explaining your approach

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        """
        #Uning Hashmap
        if len(nums)==0:
            return []
        
        arr=[0]*(len(nums)+1)
        res=[]
        for i in range(len(nums)): 
            arr[nums[i]]+=1
        
        for i in range(len(arr)):
            if arr[i]==0 and i!=0:
                res.append(i)
        
        return res
        """
        #using minus everytime approach
        for i in range(len(nums)): 
            index=abs(nums[i])
            if nums[index-1]>0:
                nums[index-1]=(-1)*nums[index-1]
        
        output=[]
        for i in range(len(nums)): 
            if nums[i]>0:
                output.append(i+1)
        return output    
        