class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #         length=len(nums)
        #         num=set(nums)
        #         j=1
        #         arr=[]
        #         for i in range(1,length+1):
        #             if i not in num:
        #                 arr.append(i)

        #         return arr
        # time=O(n) space=O(n)
        arr = []
        for i in nums:
            if i < 0:
                i = -1 * i
            if nums[i - 1] > 0:
                nums[i - 1] = -1 * nums[i - 1]
        for i in range(len(nums)):
            if nums[i] > 0:
                arr.append(i + 1)
        return arr

        # time=O(n) space-O(1)
