class Solution:
    def findDisappearedNumbers(self, nums):
        if nums is None or len(nums) == 0:  # checking to see if array of nums is empty or not
            return []

        result = []  # List which return the missing numbers

        # ii = []
        # idx2 = []
        for i in range(len(nums)):  # iterating over every element of the array
            # ii.append(i)
            # print(ii)
            idx = abs(nums[i]) - 1  # taking the absolute value of the value of the i'th index and subtracting it by one
            # idx2.append(idx)
            # print('*********************')
            # print(idx2)
            # print('/' * 50)
            if nums[idx] > 0:  # if i'th index in nums is negative it will make it positive
                nums[idx] *= -1  # making the corresponding number at the idx index negative

        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] *= -1       #if the number is already negative then the number correponding to it already exist then making back to +ve
            else:
                result.append(i + 1)

        return result


nums = [4, 3, 2, 7, 8, 2, 3, 1]
obj = Solution()

print(obj.findDisappearedNumbers(nums))

# TC = O(2N)
# Space complexity : No extra space we are just changing the state of the input array and returned list does not count as extra space.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Syntax error
