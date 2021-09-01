# // Time Complexity : O(n) where n: number of elements
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        arr = [-1 for _ in range(len(nums))]
        
        for num in nums:
            arr[num-1] = 1
        
        res = []
        for i in range(len(arr)):
            if arr[i] == -1:
                res.append(i+1)
        
        return res