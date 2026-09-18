# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
#Two approaches first using HashSet to store the nums array so that the array is unique and then iterate over the set to check missing number
# Since the constraints given are in the range 1 ≤ a[i] ≤ n, the intuition is to make the values at the index negative.
# Second to not use extra space just modifying the number to multiply it by -1 so that the array index is visited so whichever indexes are not visited are missing numbers

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return [1]
        numsSet = set(nums)
        result = []
        for i in range(1, len(nums)+1):
            if i not in numsSet:
                result.append(i)
        return result
#Time - O(N)
#Space - O(N)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return [1]
        result = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            nums[index] = abs(nums[index]) * -1

        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] *= -1
        return result
#Time - O(N)
#Space - O(1)