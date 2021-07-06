class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums)==0:
            return []
        result=[]
        for val in nums:
            if nums[abs(val)-1]>0:
                nums[abs(val)-1]=-nums[abs(val)-1]
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        return result
        # Time O(n)
        # Space O(1)
        # https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
        
        # #Time O(n)
        # #Space O(n)
        # output=[False]*(len(nums)+1)
        # for val in nums:
        #     if output[val]!=True:
        #         output[val]=True
        # return [i for i in range(1,len(output)) if output[i]==False]
