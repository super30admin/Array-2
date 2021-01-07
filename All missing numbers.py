class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        #where, n is the size of nums
        
        for num in nums:
            idx = abs(num) - 1
            nums[idx] = - (abs(nums[idx]))
            
        return [i+1 for i in range(len(nums)) if nums[i] > 0]