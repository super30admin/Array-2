#Leetcode Problem 448
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        s=set(nums)
        res=[]
        for i in range(1,len(nums)+1):
            if i not in s:
                res.append(i)
        return res

#TC: O(n)
#SC: O(n)

#Other solution with SC O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res=[]
        for i in range(len(nums)):
            ind=abs(nums[i])-1
            if nums[ind]>0:
                nums[ind]*=-1
        
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
        return res