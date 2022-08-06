#  448. Find All Numbers Disappeared in an Array
'''
Leetcode all test cases passed: Yes
Solution:
    findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n is the length of nums
        Space Complexity: O(1)
        Time Complexity: O(n)
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        for num in nums:
            if nums[abs(num) - 1] > 0:
                nums[abs(num) - 1] = -nums[abs(num) - 1]
        res = []
        for idx in range(len(nums)):
            if nums[idx] > 0:
                res.append(idx + 1)
        
        return res
