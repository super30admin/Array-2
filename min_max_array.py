# Approach: Brute Force: Using 2N passes, we compare every element with every other element to update min & max
# Time Complexity : O(N)

# Optimized number of passes
# We use a pair to obtain min & max in both halves of array and further compare it
# Time: O(N)
# Space: O(1)


def min_max(array, left, right):

    if not array:
        return 0

    if left == right: # Only 1 element
        min_element = array[left]
        max_element = array[left]
        return (min_element, max_element)

    elif right == left + 1:

        if array[left] > array[right]:
            min_element = array[right]
            max_element = array[left]

        else:
            min_element = array[left]
            max_element = array[right]

    else:

        mid = (left + right) // 2
        min_element1, max_element1 = min_max(array, left, mid)
        min_element2, max_element2 = min_max(array, mid + 1, right)


    return (min(min_element1, min_element2), max(max_element1, max_element2))


        
# Driver code
arr = [1000, 11, 445, 1, 330, 3000]
n = len(arr)
print(minMax(arr, 0, n - 1))
