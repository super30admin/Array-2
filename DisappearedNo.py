// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res=[]
        for i in range(len(nums)):
            c=abs(nums[i])-1
            if(nums[c]>0):
                nums[c]=nums[c]*(-1)
        for i in range(len(nums)):
            if(nums[i]>0):
                res.append(i+1)
        return res
            
        O9
