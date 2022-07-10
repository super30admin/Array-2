"""
TC:O(n)
SC:O(n)
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        limit=len(nums)
        hm={}
        for i in range(1,limit+1):
            hm[i]=False
        missing=[]
        for j in range(len(nums)):
            if nums[j] in hm.keys():
                ele=nums[j]
                hm[ele]=True
        for k in hm.keys():
            if hm[k]==False:
                missing.append(k)
        return missing