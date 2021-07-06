"""
// Time Complexity : mentioned in code
// Space Complexity : mentioned in code
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        """
        Set approach, O(n) time and o(n) space

        time complexity: o(n)
        space complexity: o(n)
        """
        """
        s = set()
        for i in range(1, len(nums)+1): #creating a set of all values from 1 to n
            s.add(i)
            
        for i in nums: #iterating over and removing that value from set
            if i in s:
                s.remove(i)
        return (s) #in the end missing values will be remaining in the set
        """
        
        """
        o(1) space solution

        time complexity: o(n)
        space complexity: o(1)
        """
        
        for i in nums: #for each elemnt 
            ind = abs(i)-1 #negate the value present at index corresponding to the number if not negative already
            if nums[ind]>0:
                nums[ind] *= -1
        res = []
        
        for i in range(len(nums)): #the number corresponding to the index value which is positive will be the missing numbers
            if nums[i] > 0:
                res.append(i+1)
        return res
         