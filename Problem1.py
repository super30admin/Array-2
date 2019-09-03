# Time Complexity : O(n) (Average time complexity of 'in' operation for set in python is O(n))
# Space Complexity : O(1) (If we don't consider returned list)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Create set of given numbers to remove duplicates from it.
# - Append element to the answer array from 1 to lenth of nums and do not append if element is in the set already. 

# Your code here along with comments explaining your approach
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
#       Storing length of nums because it will be changed when converting it to the set.
        l = len(nums)
#       Convert nums array to nums set to remove any repeated numbers.
        nums = set(nums)
#       Initialized empty answer list.
        ans = []
        
#       Now looping over to the range from 1 to length of number + 1. 
        for i in range(1,l+1):
#       Checkig if element is in the set or not, If it is not in the set than we want to append it to our answer array.
            if i not in nums:
                ans.append(i)
        return ans
