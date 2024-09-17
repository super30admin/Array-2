# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No but couldn't come up with O(1) space solution


# Your code here along with comments explaining your approach


from collections import defaultdict
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if nums == None or len(nums) == 0:
            return []
        output = []
        hm = defaultdict(int)
        
        for i in range(1,len(nums)+1):
            hm[i] = 0
        
        #Populate dictionary with count of elements in num
        for i in range(0,len(nums)):
            hm[nums[i]] +=1
            
        #Return keys with count = 0
        for k,v in hm.items():
            if v == 0:
                output.append(k)
                
        return output