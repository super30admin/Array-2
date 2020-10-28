// Time Complexity : O(n)
// Space Complexity : O()
// Did this code successfully run on Leetcode : 2/3 ran 
// Any problem you faced while coding this : Some edge cases


// Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if len(nums)==0:
            return []        
        
        nums  = sorted(nums)
        limit = len(nums)-1
        i=0
        x=0 
        l=[]
        
        while i<limit:
            
            x=x+1
            
            if x!=nums[i]:
                l.append(x)
            
            while x==nums[i] and i<limit:
                i=i+1
        x=x+1        

                x+=1
        
        return l