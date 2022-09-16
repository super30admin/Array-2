"""
 FAANMG Problem #31 {Easy}


448. Find All Numbers Disappeared in an Array

Time Complexity : O(N)



Space Complexity : O(1)


Did this code successfully run on Leetcode : Yes
    
Here We are iterating throught the list,
    - For each value make the correseponding (val-1 ) index multiply with -1 to indicate that the number is present in the list
    
The positive value index+1 is the missing numbers

                  

@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        result =[]
        
        for idx , val  in enumerate (nums):
            
            temp = abs(val)
            
            if(nums[temp-1] < 0):
                continue
                
            nums[temp -1] *= -1
            
            
        for i in range (len(nums)):
            
            if(nums[i] >0):
                result.append(i+1)
                
        return result