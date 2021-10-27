class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res=[]
        # here taken len(nums)+1 as we can't access the last index
#         This loop is for negating all the values except the missing values
        for i in range(1,len(nums)+1):
            s=abs(nums[i-1])
            if nums[s-1]>0:
                nums[s-1]=nums[s-1]*-1
#         This loop is used for finding the missing value by traversing from first index
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
        return res
            
# TC---O(n)
# SC----O(1)