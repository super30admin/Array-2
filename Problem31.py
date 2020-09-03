def findminandmax(array):

    print(max(array))
    print(min(array))

"""
Time complexity: O(n)

"""

"""

Divide and Conquer Approach to reduce the seach space by half which inturn reduces the TC

"""

INF = float('inf')


# Divide & Conquer solution to find minimum and maximum number in a list
def findMinAndMax(A, left, right, min=INF, max=-INF):

    # if list contains only one element

    if left == right:           # common comparison

        if min > A[right]:      # comparison 1
            min = A[right]

        if max < A[left]:       # comparison 2
            max = A[left]

        return min, max

    # if list contains only two elements

    if right - left == 1:       # common comparison

        if A[left] < A[right]:  # comparison 1
            if min > A[left]:   # comparison 2
                min = A[left]

            if max < A[right]:  # comparison 3
                max = A[right]

        else:
            if min > A[right]:  # comparison 2
                min = A[right]

            if max < A[left]:   # comparison 3
                max = A[left]

        return min, max

    # find mid element
    mid = (left + right) // 2

    # recur for left sublist
    min, max = findMinAndMax(A, left, mid, min, max)

    # recur for right sublist
    min, max = findMinAndMax(A, mid + 1, right, min, max)

    return min, max
