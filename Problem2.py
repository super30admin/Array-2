#https://www.geeksforgeeks.org/dsa/maximum-and-minimum-in-an-array/
# TC = O(n)
# SC = O(1)
# Process the array two elements at a time: compare each pair against each other first, 
# then only check the smaller one against mini and the larger one against maxi, 
# cutting comparisons from 4 to 3 per pair.

def find_min_max(arr):
    n = len(arr)  
    if n % 2 == 1:              # check if array length is odd
        mini = maxi = arr[0]    # seed both mini and maxi with the first element 
        i = 1                   # start pairing loop from index 1, since index 0 is already used
    else:  
        if arr[0] < arr[1]:     # compare the first two elements to seed mini/maxi
            mini = arr[0]       # arr[0] is smaller, so it becomes the initial min
            maxi = arr[1]       # arr[1] is larger, so it becomes the initial max
        else:
            mini = arr[1]       # arr[1] is smaller, so it becomes the initial min
            maxi = arr[0]       # arr[0] is larger, so it becomes the initial max
        i = 2                   # start pairing loop from index 2, since indices 0 and 1 are already used

    while i < n - 1:                 # loop while a full pair (i and i+1) still exists in bounds
        if arr[i] < arr[i + 1]:      # compare the pair against each other
            mini = min(arr[i], mini)  # arr[i] is the smaller one, check it against current min
            maxi = max(arr[i + 1], maxi)  # arr[i+1] is the larger one, check it against current max
        else:
            mini = min(arr[i + 1], mini)  
            maxi = max(arr[i], maxi)  
        i += 2                              # move forward by 2 to process the next pair

    return [mini, maxi]  


def main():
    arr = [3, 5, 4, 1, 9]  
    result = find_min_max(arr)  
    print(result[0], result[1])  

if __name__ == "__main__": 
    main()