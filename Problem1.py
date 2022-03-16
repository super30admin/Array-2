#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        li = []
        for i in nums:
            i = abs(i)

            if nums[i-1] > 0:
                nums[i-1] *= -1

        for i in range(len(nums)):
            if nums[i] > 0:
                li.append(i+1)
                
        return li