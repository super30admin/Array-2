# Time Complexity : It is O(n) since we are iterating length of the list.
# Space Complexity : It is O(n) since creating the hashmap.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = [False] * len(nums)
        output = []
        
        #populate the hashmap index with the value associated mark it true
        for i in nums:
            result[i-1] = True
        
        #Where it is false it means missing value and add it to the list
        for i in range(len(nums)):
            if result[i] == False:
                output.append(i+1)     
        
        return output   
obj = Solution()
obj.findDisappearedNumbers([4,3,2,7,8,2,3,1])