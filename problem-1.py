# TC - O(n)
# SC - O(1), no additional space used

# Approach

# for every element in the range of 1,n , subtract 1 from that element and go to that index
# on reaching the index, if the number is positive , multiply it with -1
# if negative, do nothing
# After complete traversal is done, traverse for a second time
# check if a number is negative, make it positive, so as to not modify the original array
# if positive , store the index+1 th index in the list


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        if not nums:
            return []

        ans = []
        rangeNum = range(len(nums))

        for i in rangeNum:
            index = abs(nums[i])-1
            if (nums[index] > 0):
                nums[index] = nums[index] * -1

        for i in rangeNum:

            if (nums[i] > 0):
                ans.append(i+1)
            else:
                nums[i] = nums[i]*-1

        return ans
