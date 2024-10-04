class Solution:
    # time complexity: O(n)
    # space complexity: O(1)
    # check if val is greater than udx then add idx+1 to res
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        res = []

        for i in range(len(nums)):
            curr = abs(nums[i])
            idx = curr - 1 
            if nums[idx] > 0:
                nums[idx] *= -1
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
            else:
                nums[i] *= -1
        return res

        