# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes


# // Your code here along with comments explaining your approach



class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        if nums == None or len(nums) == 0:
            return result
        for i in range(len(nums)): # in this loop we are iterating over the nums array and for every element we are subtracting it by 1 so that we can match from 0 to n-1
            idx = abs(nums[i]) - 1
            if nums[idx] > 0: # once we get the index by subtracting 1, we check if the nums[idx] if the element is present where it should be
                nums[idx] *= -1 # if nums[idx] is present and is positive then we mark it with '-' to make sure that the number is present 

        for i in range(len(nums)): # in this loop we check if any positive elements are remaining in the nums array, if there is then we add 1 to its index and append it to result array
            if nums[i] > 0:
                result.append(i+1) # we add 1 here since in the previous loop we subtracted 1 from nums
        return result