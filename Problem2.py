## Problem2
# Given an array of numbers of length N, find both the minimum and maximum. 
# Follow up : Can you do it using less than 2 * (N - 2) comparison
# https://www.geeksforgeeks.org/dsa/maximum-and-minimum-in-an-array/
def findMinMax(nums: List[int]) -> None:
    return helper(nums, 0, len(nums) - 1)

def helper(arr, low, high):
    """
    Finds the minimum and maximum elements in an array using a Divide and Conquer approach.
    
    Logic:
    - Divide the array into two halves until reaching a base case (1 or 2 elements).
    - Conquer by directly finding the min and max of these small segments.
    - Combine the results by comparing the minimums and maximums of the left 
      and right halves to determine the overall min and max.
      
    Time Complexity: O(n)
    - The recurrence relation is T(n) = 2*T(n/2) + 2 comparisons for the combine step.
    - This resolves to O(n). Specifically, it makes roughly 3n/2 - 2 comparisons, 
      which is more efficient than a naive traversal that makes 2n comparisons.
      
    Space Complexity: O(log n)
    - While no extra arrays are created (O(1) auxiliary data structure space), 
      the recursive call stack reaches a maximum depth of log(n) frames.
    """
    result = [0, 0]
    
    # Base case 1: If the array segment has only one element.
    # No comparison needed; the single element is both the min and the max.
    if low == high:
        result[0] = arr[low]
        result[1] = arr[low]
        return result
    
    # Base case 2: If the array segment has exactly two elements.
    # Only 1 comparison is needed to determine the min and max.
    if high == low + 1:
        if arr[low] < arr[high]:
            result[0] = arr[low]
            result[1] = arr[high]
        else:
            result[0] = arr[high]
            result[1] = arr[low]
        return result
    
    # Divide step: Calculate the midpoint to split the array into two halves.
    mid = (low + high) // 2
    
    # Conquer step: Recursively find min and max for the left half.
    left = helper(arr, low, mid) 
    
    # Conquer step: Recursively find min and max for the right half.
    right = helper(arr, mid + 1, high)  
    
    # Combine step: The overall minimum is the smaller of the two half-minimums.
    result[0] = min(left[0], right[0])  
    
    # Combine step: The overall maximum is the larger of the two half-maximums.
    result[1] = max(left[1], right[1])  
    
    return result
    
print(findMinMax([3, 5, 1, 6, 8, 4]))