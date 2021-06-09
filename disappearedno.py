# Time Complexity : O(N)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def findDisappearedNumbers(self, nums) :
        if len(nums)==0:
            return []
        res = []
        
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index]>0:
                nums[index] = -1*nums[index]
        
        for i in range(len(nums)):
            if nums[i] <0:
                nums[i] = -1*nums[i]
            else:
                res.append(i+1)
        return res

nums = [4,3,2,7,8,2,3,1]
obj = Solution()
print(obj.findDisappearedNumbers(nums))