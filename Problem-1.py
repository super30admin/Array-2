# 448. Find All Numbers Disappeared in an Array
# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

# Time Complexiety: O(n)
# Space Complexiety: O(1)

class Solution:
    def findDisappearedNumbers(self, nums):
        res = []
        n = len(nums)

        for i in range(n):
            if nums[abs(nums[i])-1] > 0:
                nums[abs(nums[i])-1] *= -1
        
        for i in range(n):
            if nums[i] > 0:
                res.append(i+1)
        return res


obj = Solution()
print(obj.findDisappearedNumbers([2,1,1,3]))
print(obj.findDisappearedNumbers([4,3,2,7,8,2,3,1]))
print(obj.findDisappearedNumbers([1,1]))