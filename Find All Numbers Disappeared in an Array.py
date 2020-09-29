# Time Complexity :O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : didn't came with this solution first, saw solution

# For each number i in nums,
# we mark the number that i points as negative.
# Then we filter the list, get all the indexes
# who points to a positive number

class Solution:
    def findDisappearedNumbers(self, nums):
        
        output = []
        for i in range(len(nums)):
            index = abs(nums[i])-1
            nums[index] = -abs(nums[index])
            #print(index,nums)
        
        for i in range(len(nums)):
            if nums[i]>0:
                output.append(i+1)
        return output
            
            
                