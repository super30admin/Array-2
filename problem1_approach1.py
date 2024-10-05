# time complexity: O(n)
# space complexity: O(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)

        result = []

        for i in range(n):
            num = nums[i]
            idx = abs(num)-1

            if nums[idx]>0:
                nums[idx] = nums[idx]* -1
            
        for i, num in enumerate(nums):
            if num<0:
                nums = num * -1
            else:
                result.append(i+1)

        return result