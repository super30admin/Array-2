# Time Complexity :O(n)
# Space Complexity :O(1)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 448

# Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
#
# Find all the elements of [1, n] inclusive that do not appear in this array.
#
# Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
#
# Example:
#
# Input:
# [4,3,2,7,8,2,3,1]
#
# Output:
# [5,6]


def main():
    nums = [4,3,2,7,8,2,3,1]
    ans = findDisappearedNumbers(nums)
    print(ans)

def findDisappearedNumbers(nums):
    """
    :type nums: List[int]
    :rtype: List[int]
    """
    # Response array that would contain the missing numbers
    output = []

    # Iterate over each of the elements in the original array
    for each in nums:

        # Treat the value as the new index
        moveIndex = abs(each) - 1

        # Check the magnitude of value at this new index
        # If the magnitude is positive, make it negative
        # thus indicating that the number nums[i] has
        # appeared or has been visited.
        if nums[moveIndex] > 0:
            nums[moveIndex] *= -1

    # Iterate over the numbers from 1 to N and add all those
    # that have positive magnitude in the array
    # nums = [-4,-3,-2,-7,8,2,-3,-1]
    for index in range(len(nums)):
        if nums[index] > 0:
            output.append(index + 1)

    return output

if __name__ == '__main__':
    main()