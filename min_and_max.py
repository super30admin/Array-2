"""
Array-2

Problem2
Given an array of numbers of length N, find both the minimum and maximum. 
Follow up : Can you do it using less than 2 * (N - 2) comparison

Time Complexity : O(n/2) ~ O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Trick is comparing 2 elements at a time & keeping the track of current & global min & max which reduces the comparisions.
"""



def find_min_and_max(arr):
    if not arr or len(arr) == 0:
        return (None,None)

    if len(arr) == 1:
        return (arr[0], arr[0])
    elif len(arr) == 2:
        return (min(arr[0], arr[1]), max(arr[0], arr[1]))

    start_idx = 2
    if len(arr) % 2 != 0:
        max_ele = arr[0]
        min_ele = arr[0]
        start_idx = 1
    else:
        max_ele = max(arr[0], arr[1])
        min_ele = min(arr[0], arr[1])


    for i in range(start_idx, len(arr)-1, 2):
        if arr[i] < arr[i+1]:
            curr_min = arr[i]
            curr_max = arr[i+1]
        else:
            curr_min = arr[i+1]
            curr_max = arr[i]

        max_ele = max(max_ele, curr_max)
        min_ele = min(min_ele, curr_min)

    return (min_ele, max_ele)


def test_find_min_and_max():
    test_cases = [
        ([], (None, None)),
        ([5], (5, 5)),
        ([1, 9], (1, 9)),
        ([9, 1], (1, 9)),
        ([3, 5, 1], (1, 5)),
        ([10, 20, 5, 1, 8], (1, 20)),
        ([3, 5, 1, 2, 4, 8], (1, 8)),
        ([7, 2, 10, 4, 3, 6, 1, 9], (1, 10)),
        ([5, 5, 5, 5], (5, 5)),
        ([1, 1, 1], (1, 1)),
        ([10, 3, 6, 1, 9, 2, 8, 4, 7, 5], (1, 10)),
        ([-3, -1, -7, -4, -2, -6], (-7, -1)),
        ([-5, -5, -5, -5], (-5, -5)),
        ([-3, 2, 7, 5, -1, 0, 4, -6, 8, -2, 9], (-6, 9))
    ]

    for i, (input_data, expected_output) in enumerate(test_cases):
        result = find_min_and_max(input_data)
        assert result == expected_output, f"Test case {i+1} failed: expected {expected_output}, got {result}"
        print(f"Test case {i+1} passed: expected {expected_output}, got {result}")

# Run the test function
test_find_min_and_max()

