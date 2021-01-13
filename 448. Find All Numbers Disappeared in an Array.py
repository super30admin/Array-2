# // Time Complexity : O(2n) = O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
	# Using the concept of state chage this problem is solved
	# the Intution is that since there can be only +ve numbers from 1 to n 
	# and so there exists a maping such that we can derive all the index values
	# from the value that is present at a location hence if there in a missing number
	# then we will not traverse through all the indecies hence there will some untouced
	# numbers that are identified by a -/+ve numbers.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        res = []
        for i in range(len(nums)):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] = -1 * nums[idx]
        
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
                
        return res
            
            