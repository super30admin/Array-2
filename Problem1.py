# 448. Find All Numbers Disappeared in an Array

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        temp = []
        for i in range(0,n):
            ind = abs(nums[i])
            nums[ind - 1] = -1 * abs(nums[ind - 1])

        for i in range(0,n):
            if nums[i] > 0:
                temp.append(i+1)

        return temp



        