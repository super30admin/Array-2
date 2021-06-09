# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#use the input array and change it to negative to know if that
#number exists or not


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        out = []
        
        for i in nums:
            a = abs(i)
            if nums[a-1] > 0:
                nums[a-1] *= -1
        print(nums)
        for i in range(len(nums)):
            if nums[i] > 0:
                out.append(i+1)
        
        return out