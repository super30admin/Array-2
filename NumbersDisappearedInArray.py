#Time Complexity: O(n)
#Space Complexity: O(1)
#Successfully ran on leetcode

class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        for i in range(len(nums)):
            x=abs(nums[i])-1
            if nums[x]>0:
                nums[x]=0-nums[x]
        result=[]
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        return result