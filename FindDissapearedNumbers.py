"""
Rasika Sasturkar
Time Complexity: O(n)
Space Complexity: O(1)
"""


def findDisappearedNumbers(nums):
    """
    We go to the (value-1)index of that value and mark it negative.
    If the value at the current pointer is negative, take the absolute values.
    If at that index, the value is already negative, it is already marked.
    Lastly, iterate over the list to find any positive values, if yes then return
    the numbers by incrementing 1 to each.
    """
    result = []

    # null case
    if nums is None:
        return result

    n = len(nums)

    for i in range(n):
        # get index
        index = abs(nums[i]) - 1
        if nums[index] > 0:
            nums[index] *= -1

    for i in range(n):
        if nums[i] > 0:
            result.append(i + 1)
        else:
            nums[i] *= -1

    return result


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    nums1 = [4, 3, 2, 7, 8, 2, 3, 1]
    print(findDisappearedNumbers(nums1))  # returns [5, 6]
    nums2 = [1, 1]
    print(findDisappearedNumbers(nums2))  # returns [2]


if __name__ == "__main__":
    main()
