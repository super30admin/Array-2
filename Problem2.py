class MinAndMax(object):
    def minAndMax(self, nums):
        """
        Finds the minimum and maximum elements in the list.
        Time complexity: O(n), where n is the length of the list.
        Space complexity: O(1).
        :param nums: List of numbers.
        :return: List containing the minimum and maximum elements.
        """
        # Check if the list is None or empty
        if nums is None or len(nums) == 0:
            return [-1, -1]

        # Variable to indicate if the list length is odd
        oddLength = 0
        if len(nums) % 2 != 0:
            oddLength = 1

        # Initialize variables to store the minimum and maximum elements
        finalMax = float('-inf')
        finalMin = float('inf')

        # Traverse the list in pairs of elements
        for i in range(0, len(nums) - 1, 2):
            # Compare the two elements of the pair
            if nums[i+1] > nums[i]:
                currentMax = nums[i+1]
                currentMin = nums[i]
            else:
                currentMax = nums[i]
                currentMin = nums[i + 1]

            # Update the overall maximum and minimum
            if currentMax > finalMax:
                finalMax = currentMax
            if currentMin < finalMin:
                finalMin = currentMin

        # Handle the odd-length case by considering the last element separately
        if oddLength:
            lastElement = nums[len(nums) - 1]
            if lastElement > finalMax:
                finalMax = lastElement
            if lastElement < finalMin:
                finalMin = lastElement

        # Return the minimum and maximum elements as a list
        return [finalMin, finalMax]
