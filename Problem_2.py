# 448. Find All Numbers Disappeared in an Array

# code:

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = [0]*len(nums)
        
        # iterated over all the elements in nums and filled in the res array
        for i in range(len(nums)):
            res[nums[i]-1] += 1
        
        # For the elements in res where the elements are not updated, that's the result
        store = []
        for i in range(len(res)):
            if res[i]==0:
                store.append(i+1)
                
        return store

# Time Complexity: O(n)
# Space Complexity: O(1)
# Accepted on Leetcode: YES
# Any problems faced: No.