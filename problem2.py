#Time: O(n)
#space: O(1)
def find_min_max(arr):
    if(len(arr) == 0):
        return 'empty', 'empty'
    if(len(arr) == 1):
        return arr[0], arr[0]
    i=0
    j=1
    minimum = min(arr[i],arr[j])
    maximum = max(arr[i],arr[j])
    print(arr)
    while( i < len(arr)):
        # print('loop ->',i)
        if(i <= len(arr)-2):
            j=i+1
        else:
            minimum= min(arr[i], minimum)
            maximum= max(arr[i], maximum)
            # print('inside else')
            return minimum, maximum
        # print('i,j',i,j)
            
        if(arr[i] < arr[j]):
            # print('inside if')
            minimum= min(arr[i], minimum)
            maximum= max(arr[j], maximum)
        elif(arr[i] > arr[j]):
            # print('inside elif ')
            minimum= min(arr[j], minimum)
            maximum= max(arr[i], maximum)
        else:
            # print('inside else')
            minimum= min(arr[i], min(minimum,arr[j]))
            maximum= max(arr[i], max(maximum,arr[j]))

        i= i+2

    return minimum, maximum

# Driver code
if __name__ == "__main__":
    # Test cases
    test_cases = [
        ([3, 5, 1, 2, 4, 8, 7], "General case"),
        ([1], "Single element"),
        ([5, 2], "Two elements"),
        ([], "Empty array"),
        ([7, 7, 7, 7, 7], "All identical elements"),
        ([9, -1, 3, -8, 4, 0], "Mixed positive and negative"),
        ([10, 15, 5, 20, 25, 3], "Unsorted array"),
        ([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], "Sorted in ascending order"),
        ([10, 9, 8, 7, 6, 5, 4, 3, 2, 1], "Sorted in descending order"),
        ([1, -1, 0, 999, -1000], "Large range of values"),
    ]

    for arr, description in test_cases:
        minimum, maximum = find_min_max(arr)
        print(f"Test: {description}")
        print(f"Array: {arr}")
        print(f"Minimum: {minimum}, Maximum: {maximum}\n")
