'''
Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

'''
'''
Time Complexity : O(N)
Space Complexity : O(1)
'''
'''
Approach : 
iterate through the array check i-1 index and make that as *-1(negative)
then after completing iterate over array and then check if eleemnt is postive of possitive then add element -1 to array

'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            temp = nums[i]
            if(nums[abs(temp)-1] > 0):
                nums[abs(temp)-1] = nums[abs(temp)-1] * -1
        result = [] 
        for i in range(len(nums)):
            if(nums[i]>0):
                result.append(i+1)
        return result
        # for i in range()