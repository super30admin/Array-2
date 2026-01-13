#sorting + linear search

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #brute force will be O(n2)
        #sorting + linear search
        nums.sort()
        result = []
        i = 0

        for expected in range(1, len(nums)+1):
            if i == len(nums) or nums[i] > expected: #to handle cases like [1,1]
                result.append(expected)
            while i < len(nums) and nums[i] == expected: #loop till next unqiue element
                i += 1

        return result        
        #nums[i] won't be less than expected because we are sorting it and the no.are in the range from 1 to n. where n is length of nums.      
    
# Time Complexity: O(nlogn + n) = O(nlogn)
# Space complexity: O(1)

#Treating the array as a hashset

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #using the array as set itself

        result = []

        for i in range(len(nums)):
            idx = abs(nums[i])-1 #the no.s actual index in the array from 1 to N, 4 will be 3
            #1 will be 0 and so on.
            if nums[idx] > 0:
                nums[idx] *= -1 #mark the number at that idx negative
            
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)

        return result

# Time Complexity: O(N)
# Space Complexity: O(1)

#if negative numbers are involved example:
# [0,-1,3,-2,4,-2,-1,-3]
# range -3 to 4 = 4-(-3)+1 = 8
# offset everything by range/2 = 4
#this only works when the range is equal to the length of the array.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #using the array as set itself

        result = []

        shift = 8//2 #(range//2)

        for i in range(len(nums)):
            nums[i] = nums[i]+shift #this should be range/2

        for i in range(len(nums)):
            idx = abs(nums[i])-1 #the no.s actual index in the array from 1 to N, 4 will be 3
            #1 will be 0 and so on.
            if nums[idx] > 0:
                nums[idx] *= -1 #mark the number at that idx negative
            
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1-shift)

        return result