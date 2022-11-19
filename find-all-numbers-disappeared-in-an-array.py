#TC: O(n)
#SC: O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i,num in enumerate(nums):
            correct_index=abs(num)-1 #abs extract actual info after removing the marks if any
            if nums[correct_index]>0: nums[correct_index] *=-1 #marks as occured
        ans=[]
        for i in range(1,len(nums)+1):
            if nums[i-1]>0: ans.append(i)
        return ans