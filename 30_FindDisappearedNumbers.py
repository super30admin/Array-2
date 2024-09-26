# accepted in leetcode
# time - O(N), space - O(1)
# The logic here is to negate all value in the indexes which have appeared in the list.
# Then , again iterate through the list to return the indices which are positive.
class Solution:
    def findDisappearedNumbers(self, nums):
        result =[] # output array
        for num in nums:
            if nums[abs(num)-1] != -abs(nums[abs(num)-1]): # if the data the index is not negative make it negative
                nums[abs(num)-1] = - nums[abs(num)-1]
        for i in range(len(nums)):
            # iterate through the list to return the indexes which are not neagtive are the missing numbers.
            if nums[i] != -abs(nums[i]):
                result.append(i+1)
        return result

sol = Solution()
print(sol.findDisappearedNumbers([3,4,5,6,7,8,3,5]))