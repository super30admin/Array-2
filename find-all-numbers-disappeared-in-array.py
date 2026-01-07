''' Time Complexity : O(n) 
    Space Complexity : O(1) ; 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No



   Approach : Inplace marking method : traverse the array and mark the indexes negative for each element
'''

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        n = len(nums)
        for i in range(0,n):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1
        print(nums)
        for i in range(n):
            if nums[i] < 0:
                nums[i] *= -1
            else:
                result.append(i+1)
        return result
        