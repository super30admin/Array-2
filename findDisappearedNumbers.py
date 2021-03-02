class Solution:
    def findDisappearedNumbers(self, nums):
        # [4,3,2,7,8,2,3,1]
        # Sanity Check
        if nums==None or len(nums)==0:
            return [0]

        # initialize the variables for temp index holder and resultant list/array
        idx = 0
        res = []

        # traverve through the list
        for i in range(len(nums)):
            # temp index of the number to be made negative stored in idx
            # use the absolute value of the value at index i in case the number is negative
            idx = abs(nums[i]) - 1

            # if number is positive then turn it to negative
            if nums[idx]>0:
                nums[idx] *= -1
        # check for numbers that might not be negative
        # as the index + 1 value of these numbers will be the missing numbers
        # negative numbers represent that the number is recorded as present in the list
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
        return res

        pass

nums = [4,3,2,7,8,2,3,1]
s = Solution()
print("Disappeared numbers are ",s.findDisappearedNumbers(nums))

