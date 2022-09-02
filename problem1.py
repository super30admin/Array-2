'''
448. Find All Numbers Disappeared in an Array
TIME COMPLEXITY: O(N) + O(N) + O(N) = O(N)
SPACE COMPLEXITY: O(N)
LEETCODE: Yes
DIFFICULTIES: NOPE
'''

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        arr = [0 for i in range(0, n)]
        
        for num in nums:
            arr[num-1] = num
        
        res = []
        for i in range(0, len(arr)):
            if arr[i] == 0:
                res.append(i+1)
        
        return res
