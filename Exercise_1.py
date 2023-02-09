#Time Complexity : O(N), N being the length of the array. 
#Space Complexity : O(1), because using the input to help. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had a moment when I mixed the number and
# index of number, but it was easily debugged. 

#Your code here along with comments explaining your approach in three sentences only
'''If the number value is in array, make the index of value negative. Then the indices
that are positive, add the the results array and return. 
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #make negative. 
        result = []
        for i in range(len(nums)):
            number = nums[i]
            index = abs(number)
            if nums[index-1]>=0:
                nums[index-1]=nums[index-1]*(-1)
        #add to results array. 
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        return result