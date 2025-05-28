# // Time Complexity : appraoch 1 - o(n) approach 2 o(n)
# // Space Complexity : approach 1 - o(n) approach2 o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : intuition behind saving space


# // Your code here along with comments explaining your approach
# approach 1 : idea is to put elements in hashset and then iterate from 1 to n and find missing element
# approach 2: idea is to transforma the state of visited numbers index with negative value so the index that have not been visited will stay positive and we can find that value by index +1

# Approach 1:
# class Solution:
#     def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
#         hashSet = set()
#         res = []
#         for n in nums:
#             hashSet.add(n)
#         for n in range(1,len(nums)+1):
#             if n not in hashSet:
#                 res.append(n)
#         return res

# Approach 2
from typing import List
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for n in nums:
            numsIndex = abs(n)-1
            if nums[numsIndex] > 0:
                nums[numsIndex]*=-1
        for i in range(len(nums)):
            if nums[i]<0:
                nums.append(abs(nums[i]))
            else:
                res.append(i+1)
        return res


        