class Solution:
    # getMinMax is taking an array and returning a tuple (min, max)
    # Iterating through the array and updating min and max accordingly
    def getMinMax(self, arr: list) -> tuple:
        n = len(arr)
        # Handling edge case when array is empty
        if n == 0:
            return None, None

        # Initializing min and max
        if n == 1:
            # If only one element, returning it as both min and max
            return arr[0], arr[0]

        if arr[0] > arr[1]:
            min_val = arr[1]
            max_val = arr[0]
        else:
            min_val = arr[0]
            max_val = arr[1]

        # Iterating from the third element to the end
        for i in range(2, n):
            if arr[i] > max_val:
                # Updating max if current element is greater
                max_val = arr[i]
            elif arr[i] < min_val:
                # Updating min if current element is smaller
                min_val = arr[i]

        # Returning min and max as a tuple
        return min_val, max_val

# Example usage
if __name__ == "__main__":
    arr = [1000, 11, 445, 1, 330, 3000]
    # Creating an instance of Solution
    sol = Solution()
    # Calling getMinMax and unpacking result
    min_elem, max_elem = sol.getMinMax(arr)
    print("Minimum element is", min_elem)
    print("Maximum element is", max_elem)

# Time Complexity (TC): O(n), where n is the number of elements in arr
# Space Complexity (SC): O(1), as only constant extra space is being used
