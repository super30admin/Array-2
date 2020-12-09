'''
TC:O(N)
SC:O(1)
'''


class Solution:
    def findDisappearedNumbers(self, nums):
        if not nums:
            return -1
        
        for index,val in enumerate(nums):
            i = abs(val) -1
            if nums[i] > 0:
                nums[i] *= -1

        result = []
        for index,val in enumerate(nums):
            if val > 0:
                result.append(index+1)

        return result


print(Solution().findDisappearedNumbers([4,3,2,7,8,2,3,1]))