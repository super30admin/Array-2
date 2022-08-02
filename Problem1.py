# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = []
        
        # traverse the list, take the absolute value of the value at the index, subtract it with 1 to get the index that we'll update as this number is
        # present in the list, and then we update the value at that index if it has not already been seen, which is if it not already negative, then 
        # we multiply it with -1, else keep it that way
        for i in range(n):
            idx = abs(nums[i])-1
            if nums[idx] > 0:
                nums[idx] *= -1
        # This time we traverse the list and check for any positive numbers which are the values or the indexes which are missing as we could not find them
        # in the previous traversal as the values at this index is still positive, and then append the index+1 to the resulting array and return it
        for i in range(1,n+1):
            if nums[i-1] > 0:
                res.append(i)
        
        return res
