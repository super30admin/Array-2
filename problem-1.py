from tkinter.messagebox import YES


# Leetcode Execution: YES
# Time Complexity:O(n)
# Space Complexity:O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result=[]
        # first change all the values to negative based on index-1 of each val in place
        for i in range(len(nums)):
            ind=abs(nums[i])-1
            if nums[ind]>0:
                nums[ind]=-nums[ind]
        # which ever index value is positive increment index by 1 and add it as the missing or disappeard value
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
         
        return result
        