'''
Time complexity: O(n)
Space complexity: O(1)
'''
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(0, len(nums)):
            index = abs(nums[i])-1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
        return [i+1 for i in range(len(nums)) if nums[i] > 0]

# Driver code:
s = Solution()
print(s.findDisappearedNumbers([4,3,2,7,8,2,3,1]))