class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the size of nums
        
        arr = [None] * len(nums)
        
        for num in nums:
            arr[num - 1] = 1
            
        return [i+1 for i in range(len(nums)) if not arr[i]]