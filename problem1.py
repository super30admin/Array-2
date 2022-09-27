#PROBLEM 1
#FIND ALL NUMBERS DISSAPPEARED IN AN ARRAY
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            temp = abs(nums[i])-1
            if nums[temp]>0:
                nums[temp]*=-1
        res = []
        for i in range(1,len(nums)+1):
            if nums[i-1]>0:
                res.append(i)
        return res