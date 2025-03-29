# Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

# TC : O(n) since we only need two passes through the array

# SC : O(1)

# Approach: 
    # Treating the array indices as our tracking mechanism
    # For each number in the input, we make the value at index (num-1) negative
    # Any index that still has a positive value after this pass 
    # represents a number that didn't appear in the array

# Did this code successfully run on Leetcode : YES

def findDisappearedNumbers(nums):
    # Use the array itself to mark numbers we've seen
    # For each number n, we'll mark the element at index (n-1) by negating it
    for num in nums:
        # Get absolute value since the number might already be negated
        index = abs(num) - 1
        # Mark as seen by making the value negative
        if nums[index] > 0:
            nums[index] = -nums[index]
    
    # Collect indices where values are still positive
    result = []
    for i in range(len(nums)):
        if nums[i] > 0:
            # If positive, it means (i+1) was not in the original array
            result.append(i + 1)
    
    return result