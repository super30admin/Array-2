'''
https://www.geeksforgeeks.org/dsa/maximum-and-minimum-in-an-array/
Maximum and Minimum in an Array
Title: Maximum and minimum of an array using minimum number of comparisons
Given an array, the task is to find the maximum and the minimum element of the array using the minimum number of comparisons.

Examples:

Input: arr[] = {3, 5, 4, 1, 9}
Output: Minimum element is: 1
            Maximum element is: 9

Input: arr[] = {22, 14, 8, 17, 35, 3}
Output:  Minimum element is: 3
            Maximum element is: 35
'''

'''
Intuition and Approach:
Maximum and minimum of an array :
To solve the problem of finding the minimum and maximum elements in an array, you can follow these steps:

Step 1: Write functions to find the minimum (setmini) and maximum (setmaxi) values in the array.

Step 2: In the setmini function:

Initialize a variable (mini) to INT_MAX.
Iterate through the array, and if an element is smaller than the current mini, update mini to that element.
Return the final value of mini.
Step 3: In the setmaxi function:

Initialize a variable (maxi) to INT_MIN.
Iterate through the array, and if an element is larger than the current maxi, update maxi to that element.
Return the final value of maxi.
Step 4: In the main function:

Declare an array and its size.
Print the result ,Call the setminimum and setmaxi functions to find the minimum and maximum values.

'''

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, it runs successfully on GeeksforGeeks and for the test cases provided.
# Any problem you faced while coding this : Yes, I faced issues with handling edge cases where the array is empty or has only one element. I also had to ensure that the functions correctly return the minimum and maximum values without any errors.

def setmini(arr, n):
    mini = float('inf') # Initialize mini to a very large value
    for i in range(n):
        if arr[i] < mini: # If the current element is smaller than mini
            mini = arr[i] # Update mini to the current element
    return mini # Return the minimum value found

def setmaxi(arr, n):
    maxi = float('-inf') # Initialize maxi to a very small value
    for i in range(n):
        if arr[i] > maxi: # If the current element is larger than maxi
            maxi = arr[i] # Update maxi to the current element
    return maxi # Return the maximum value found

def main():
    arr = [3, 5, 4, 1, 9] # Example array
    n = len(arr) # Get the size of the array
    print("Minimum element is:", setmini(arr, n)) # Call setmini to find the minimum element
    print("Maximum element is:", setmaxi(arr, n)) # Call setmaxi to find the maximum element

if __name__ == "__main__":
    main() # Run the main function

# Using Sorting method

def find_min_max(arr):
    if not arr: # Check if the array is empty
        return None, None # Return None for both min and max if the array is empty
    arr.sort() # Sort the array
    return arr[0], arr[-1] # Return the first and last elements as min and max
def main_sorting():
    arr = [3, 5, 4, 1, 9] # Example array
    min_val, max_val = find_min_max(arr) # Call the function to find min and max
    print("Minimum element is:", min_val) # Print the minimum element
    print("Maximum element is:", max_val) # Print the maximum element

if __name__ == "__main__":
    main_sorting() # Run the main function for sorting methods