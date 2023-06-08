class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        Time complexity: O(n), where n --> length of nums. We iterate over the list twice.
        Space complexity: O(1), as the result list is the only additional space used, and it does not depend on the size of nums. Contains only the numbers that are missing in the given list.
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []  # List to store the missing numbers

        # Step 1: Iterate over the input list and mark the corresponding index as negative
        for i in range(len(nums)):
            # Get the absolute value of the current number and subtract 1 to get the index
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:  # If the number at the calculated index is positive, make it negative
                nums[idx] *= -1

        # Step 2: Iterate over the modified list and check for positive numbers
        for i in range(len(nums)):
            # If the number is positive, it means the corresponding index (i+1) is missing
            if nums[i] > 0:
                # Append the missing number to the result list
                result.append(i + 1)
            else:
                nums[i] *= -1  # Restore the negative value for future reference

        return result
