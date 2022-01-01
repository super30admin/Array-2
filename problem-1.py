"""
Approach

1. Since the numbers are in the range of 1-N we can use the input array to mark the numbers which are present
2. we iterate through the array and get an index by doing nums[i]-1 and mark that index as negative. 
3. if the element is already negative we take the absolute value of the element to find the index
4. in the end we traverese the array again and return those indexes which are not negative

"""


# Time Complexity : O(n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        result  = []
        
        # Mark convert the numbers present in the array to an index and mark that index as -1
        # this way we mark all the indexes which are present in the array
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index]>0:
                nums[index] = nums[index] * (-1)
        
        # take out the numbers which are not marked
        for i in range (len(nums)):
            if nums[i]>0:
                result.append(i+1)
        
        return result
                