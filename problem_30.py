# An integer array is given where 1<= a[i] <=n where n is the size of an array , some elements appear twice and other appear once.
#
# Find all the elements of [1,n[ inclusive that are missing in the array.
#
# try doing it witout using extra space and in o(n) runtime and assume that returned list does not count as extra space

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # edge case
        if nums == [] or len(nums) == 0:
            return []
        a = []
        for i in range(0, len(nums), 1):
            # print(i,nums[i])
            k = abs(nums[i]) - 1
            if nums[k] > 0:
                nums[k] = (-1) * nums[k]
        for i in range(0, len(nums), 1):
            if nums[i] > 0:
                a.append(i + 1)
        return a


j = Solution()
print(j.findDisappearedNumbers([1,2,2,3,3,6,7,8]))