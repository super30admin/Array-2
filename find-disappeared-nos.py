class Solution(object):

    # Intuition: Use an auxiliary out list to act as a hash set. Update the hashset at idx (nums[i]-1) to be 1. Eventually loop through the out list and if any -1 still exists, that mean element at that idx+1 is missing

    # SC: O(n)
    # TC: 2O(n) = O(n)

    # def findDisappearedNumbers(self, nums):
    #     """
    #     :type nums: List[int]
    #     :rtype: List[int]
    #     """

    #  n = len(nums)
    #     out = [-1] * n    # SC: O(n)
    #     res = []

    #     for i in range(len(nums)): # TC: O(n)
    #         temp = nums[i]
    #         if out[temp-1] == -1:
    #             out[temp-1] = 1 #

    #     for i in range(len(out)): # TC:O(n)

    #         if out[i] == -1:
    #             res.append(i+1)

    #     return res

    # Intuition: Iterate through the input list, multiply the element at idx  abs(nums[i]-1) with -1. Eventually any element that stays positive, the idx of that element + 1 is the missing element

    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        n = len(nums)
        out = []

        for i in range(len(nums)):
            temp = nums[i]

            if nums[abs(temp)-1] > 0:
                nums[abs(temp)-1] *= -1

        print(nums)
        for i in range(len(nums)):
            if nums[i] > 0:
                out.append(i+1)

        return out


obj = Solution()
print(obj.findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]))
