#Time Complexity : O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        output =[]
        if len(nums)==0:
            return output
        for i in nums:
            index = abs(i)-1
            if (nums[index]>0):
                nums[index] *=-1
        for i in range(len(nums)):
            if nums[i] >0:
                output.append(i+1)
        return output
