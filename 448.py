# Time O(n)
# Space O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        output = []
        for i in range(len(nums)):
            correctIndex = nums[i]-1
            while nums[correctIndex] != nums[i]:
                nums[correctIndex],nums[i] = nums[i],nums[correctIndex]
                correctIndex = nums[i]-1

        for i in range(len(nums)):
            if i+1 != nums[i]:
                output.append(i+1)
        return output
