#Time limit exceeded   - Time complexity was O^2
# 29/34 cases passes



class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # result=[]
        # n=len(nums)
        # for val in range(1,len(nums)+1):
        #     if val not in nums:
        #         result.append(val)
        # return result
        result = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        return result