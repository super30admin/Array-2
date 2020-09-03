
def findDisappearedNumbers(nums):
        for i in range(0, len(nums)):
            new_index = abs(nums[i]) - 1
            if nums[new_index] > 0:
                
                nums[new_index] *= -1
        result = []
        for i in range(1, len(nums) + 1):
            if nums[i - 1] > 0:
                result.append(i)
        return (result)

findDisappearedNumbers([4,3,2,7,8,2,3,1])

"""
Time Complexity: O(n)
Space Complexity: O(1)

"""
"""
Iterate over the array from 0, N.
For every value of i, multiply the corresponding nums value with -1 to be a tab on elements visited.
Then append non negative numbers into res as they have not been visited even once indicating missing number.

"""
