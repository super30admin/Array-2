#
# @lc app=leetcode id=448 lang=python3
#
# [448] Find All Numbers Disappeared in an Array
#

# @lc code=start
'''
Time Complexity - O(n). We are iterating the array twice
Space Complexity - O(1). Beside the result array we are nnot using any other variables

This code is working on Leetcode
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            if nums[abs(nums[i])-1] > 0:
                nums[abs(nums[i])-1] *= -1 #Mark the element at the index as -ve when as we find the element
        result = []
        for i in range(len(nums)):
            if nums[i]>0: #check for elements that are still positive this means we did not find elements for those indices hence the elements are missing
                result.append(i+1)
            else:
                nums[i]*=-1 #reset the element to their original value.
        return result
        
# @lc code=end

