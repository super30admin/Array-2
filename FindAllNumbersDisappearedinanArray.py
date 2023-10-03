#Time Complexity : O(2n) = O(n) since we first iterate and change the state and in second iteration we change the state back again to normal
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: In first iteration, we change the state of the number to negative value. We take the absolute value of the array as the index 
# and change the state to negative value of that index. If it is already negative we dont do anything. We iterate again through the array
# and if the number is positive we add it to the result and if negative, change it to positive value.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range (len(nums)):
            idx = abs(nums[i])-1
            if nums[idx] > 0:
                nums[idx] *= -1
        result = []
        for i in range (len(nums)):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] *= -1
        return result