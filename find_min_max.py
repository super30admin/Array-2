'''
Time complexity: O(1.5n + 2) ===> +2 when len is odd
Space complexity: O(1)
Implementation: Think in pairs
If len is odd, set min = max = first element
If len is even, set min = min(first, second) and max = max(first, second)
'''
class Solution:
    def findMinMax(self, nums):
        if len(nums) % 2 == 0:
            maxNum = max(nums[0], nums[1])
            minNum = min(nums[0], nums[1])
            i = 2
        else:
            maxNum = minNum = arr[0]
            i = 1
        while i < len(nums) - 1:
            if nums[i] < nums[i + 1]:
                maxNum = nums[i + 1]
                minNum = nums[i]
            else:
                maxNum = nums[i]
                minNum = nums[i + 1]
            i = i + 2
        return (maxNum, minNum)

# Driver code:
s = Solution()
nums = [1000, 11, 445, 1, 330, 3000]
print(s.findMinMax(nums))