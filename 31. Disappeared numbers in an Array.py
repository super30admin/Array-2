class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Iterating through every number in nums
        for n in nums:
            # Converting the number into its index (since numbers are 1..n, subtract 1)
            i = abs(n) - 1  
            
            # Marking the number at index i as negative (if not already negative)
            # This is showing that the number (i+1) exists in the array
            nums[i] = -1 * abs(nums[i])

        # Creating an empty list to collect missing numbers
        result = []

        # Iterating through nums again with index i and value n
        for i, n in enumerate(nums):
            # If a number is still positive, it means its index+1 was never seen
            if n > 0:
                result.append(i + 1)   # Adding the missing number to result
        
        # Returning the final list of missing numbers
        return result

# Time Complexity: O(n) - We traverse the list a constant number of times.
# Space Complexity: O(1) - We use no extra space that scales with input size