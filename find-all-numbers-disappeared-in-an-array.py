# Problem : Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

# Solution: 
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes

# look at num at index, go to that index & multiply it by -1 if its positive, else nothing
# go through the mutated array, and then add ind to answer whenever num < 0, also do num * -1

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        ans = []
        for num in nums:

            if nums[abs(num) - 1] > 0:
                nums[abs(num) - 1] *= -1
            else:
                continue
        
        for ind, num in enumerate(nums):
            if num > 0:
                ans.append(ind + 1)
            else:
                num *= -1
                pass

        return ans