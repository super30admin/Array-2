""" Find All Numbers Disappeared in an Array 
Time Complexity : O(n)
Space Complexity: O(1)
aproach : Inplace modification 
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            new_index = abs(nums[i])-1
            #take the value at nums[i] as new index
            if nums[new_index]>0:
                nums[new_index] =nums[new_index]*(-1) #change the element in the new index to negative -> to show that index (position) as visited
       
        result = []
        for i in range(1,len(nums)+1):
            if nums[i-1]>0:
                result.append(i)
        return result