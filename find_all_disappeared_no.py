#Time Complexity : O(n) here n is length of nums
#Space Complexity : O(1)
#did your code run on leetcode: yes
#Approach : State Change Pattern

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #as we know array has only positive numbers then we can use State Change Pattern
        result = []
        
        #null case
        if len(nums) == 0: return []
        
        #if number present in the list then we will mark the no present at its corresponding index as -ve and
        #if corresponding index number is already marked -ve the we will take absolute value
        
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
        
        for i in range(len(nums)):
         #restoring original list
            if nums[i] < 0:
                nums[i] *= -1
            else:
                #finding missing numbers
                result.append(i + 1)
        
        return result
