# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - will use the hashset concept to process in place. number is compared to it's index to know if missing
    - when iterating, the number's index is marked with negative value
    - in second iteration checked if any number positive whose index then added to output list 
    '''
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        output = []
        # to change the value of numbers index to negative as marker
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
        # to find which number is not there
        for i in range(len(nums)):
            if nums[i] > 0:
                output.append(i + 1)
        
        return output
