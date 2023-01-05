// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Make the number found at the index negative
//If already negative then don't do anything
//For the nos that are positive at the end, the missing nos are the index +1
def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            temp = abs(nums[i]) - 1
            if nums[temp] > 0:
                nums[temp] *= -1
        
        res = []
        for i,n in enumerate(nums):
            if n > 0:
                res.append(i+1)
        
        return res

