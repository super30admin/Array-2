# Author: Naveen US
# Titile: Find all numbers dissappeared in an array.

# Time complexity: O(n)
# Space complexity: O(1)
# Did the code run on leetcode: Yes

# Disappeared elements are found in place.  

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # n=len(nums)
        # nums = set(nums)
        # missnums=[]
        # for i in range(1,n+1):
        #   if i not in nums:
        #       missnums.append(i)
        # return missnums
        for i in range(len(nums)):
            indx = abs(nums[i]) - 1
            if nums[indx]>0:
                 nums[indx] *= -1
        ans=[]
        for n,ele in enumerate(nums,1):
             if ele>0:
                 ans.append(n)
        return ans
