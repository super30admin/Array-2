# Time Complexity :
# O(n)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
# Yes

# Three line explanation of solution in plain english
# I have used State Change Concept to solve this problem.

# Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        result = []
        
        if (nums == None or len(nums) == 0):
            return result
        
        # Iterating over nums array and for each element marking the element at it's corrosponding index to negetive
        # example when 4 is encountered element at index 3 will be marked negetive
        for i in range(len(nums)):
            
            index = abs(nums[i])-1
            if nums[index]>0:
                nums[index] = nums[index]*-1
            
        # Iterating over nums array and recording all the index (by adding 1 to it) for which the element is positive
        # Since positive element represent that element is not present
        # And recovering negetive elements by multiplying it to -1
        for i in range(len(nums)):
            
            if (nums[i]>0):
                result.append(i+1)
            else:
                nums[i] = nums[i]*-1
        
        return result