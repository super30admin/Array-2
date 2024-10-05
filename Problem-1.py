#Approach
# instead of using the new memory we can use the same memory while traversing the array
# make the value index negative and take absolute value every time sincxe we are changing the original array
# after the traversal if any index having positive then that number is missing


# complexities
# Time complexity O(n)
# Space Complexity O(1)


from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result =[]
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1

        for i in range(len(nums)):
            if nums[i] >= 0:
                result.append(i + 1)

        return result


