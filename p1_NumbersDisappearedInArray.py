# 448. Find All Numbers Disappeared in an Array

# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 


# // code here along with comments explaining approach


# using hasset
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # using hasset
        hashset = set()
        res =[]
        for i in nums:
            hashset.add(i)
        for i in range(1,len(nums)+1):
            if i not in hashset:
                res.append(i)
        return res

        