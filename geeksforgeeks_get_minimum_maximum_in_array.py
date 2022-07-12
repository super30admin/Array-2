'''

## Problem: Find minimum and maximum in an array with minimum number of comparisons.

## Author: Neha Doiphode
## Date:   07-10-2022

## Description:
Write a function to return minimum and maximum in an array.
Your program should make the minimum number of comparisons.

## Examples:
     Input : arr = [1000, 11, 445, 1, 330, 3000]
     Output: [1, 3000]

## Time complexity: O(n), where n is length of array.
                         Total number of comparisons will be
                            If n is odd:    3 * (n-1)/2

                            If n is even:   1 Initial comparison for initializing min and max,
                                            and 3(n-2)/2 comparisons for rest of the elements

                                            =  1 + [3 * (n-2)/2] = 3n/2 -2

## Space complexity: O(1), no auxiliary array is used.

'''


from typing import List

def get_input():
    print("Enter the array of integers(with spaces): ", end = "")
    inp_list = input()
    inp_list = [int(value) for value in inp_list.split()]
    return inp_list


class Solution:
    def getMinMax(self, arr):
        minimum = float("inf")
        maximum = -float("inf")
        starting_index = 0

        if len(arr) % 2 != 0:
            minimum = maximum = arr[starting_index]
            starting_index = 1

        else:
            starting_index = 2
            minimum = min(arr[0], arr[1])  # 1
            maximum = max(arr[0], arr[1])  # 2

        for index in range(starting_index, len(arr) - 1, 2):
            if arr[index] < arr[index + 1]:   # 3
                minimum = min(minimum, arr[index]) # 4
                maximum = max(maximum, arr[index + 1]) # 5
            else:
                minimum = min(minimum, arr[index + 1])
                maximum = max(maximum, arr[index])

        return [minimum, maximum]

# Driver code
solution = Solution()
inp_array = get_input()
print(f"Input array: {inp_array}")
print(f"Min and Max in an array: {solution.getMinMax(inp_array)}")
