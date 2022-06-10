'''
Time Complexity: O(n)
Space Complexity: O(1)
Run on Leetcode: YES
'''
class Solution:
    def findMinMax(self, nums: list[int]) -> list[int]:
        nMin = 0
        nMax = 0
        for index in range(0,len(nums),2):
            if nums[index] > nums[index + 1]:
                nMax = max(nums[index], nMax)
                nMin = min(nums[index + 1], nMin)
            else:
                nMax = max(nums[index + 1], nMax)
                nMin = min(nums[index], nMin)
        # checking for odd lenght of array
        if len(nums) % 2 != 0:
            nMax = max(nMax, nums[-1])
            nMin = min(nMin, nums[-1])
        return [nMin, nMax]

s = Solution()
print(s.findMinMax([3,4,2,6,7,1,-3,-6,12,5]))