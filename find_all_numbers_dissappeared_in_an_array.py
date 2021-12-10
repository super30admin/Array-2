'''
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Approach: 
1.  O(n^2) with bruteforce. O(n) space using hashmap/set. O(nlogn) TC using sort
2.  intuition/technique: since we are expecting the array should have all ranged elements
    in the array, we can use the element itself to mark/move around the elements
'''
class Solution:
    #TC: O(n), SC: O(1)
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) == 1 and nums[i] > 1: return 1
        
        res = []
        for i in range(len(nums)):
            check_index = abs(nums[i]) - 1
            if nums[check_index] > 0:
                nums[check_index] *= -1
        
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)
                
        return res