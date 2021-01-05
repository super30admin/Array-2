# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


# Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        """ 
        Initial thoughts:
            - Have mapping that stores occurrence of each number.
            - have a loop that checks if its in the mapping. if not in mapping, add to res array and return
        """
        mapping = defaultdict()
        res = []
        
        if not nums:
            return res
        
        for i in nums:
            if i not in mapping:
                mapping[i] = 1
        
        for i in range(1,len(nums)+1):
            if i not in mapping:
                res.append(i)
                
        return res