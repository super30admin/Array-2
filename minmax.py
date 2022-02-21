# // Time Complexity : O(n)
# // Space Complexity : o(1)
# // Three line explanation of solution in plain english:
# assign the min and max as the first two or first element according to the length of array.
# calculate each pairs of i and i+1 using while and change min and max and increment i twice for each iteration. 

def minmax(arr):

    n = len(arr)

    # set mx and mn as first two elements
    if n % 2 == 0:

        mx = max(arr[0], arr[1])
        mn = min(arr[0], arr[1])

        i = 2

    # if lenght is odd set mx and mn as first element
    else:

        mx = mn = arr[0]
        i = 1

    # iterates until end of array
    while i < (n-1):

        # if value of ith element is less than i+1th element
        if arr[i] < arr[i+1]:

            mx = max(mx, arr[i+1])
            mn = min(mn, arr[i])

        # if value of ith element is greater than i+1th element
        else:

            mx = max(mx, arr[i])
            mn = min(mn, arr[i+1])

        # increment in pairs
        i += 2

    return (mn, mx)