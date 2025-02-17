# Approach : The function iterates through the array once, comparing each element to update min_value and max_value.
# Time Complexity: O(n)
# Space Complexity: O(1)
def get_min_max(self, a):
        max_value = a[0]
        min_value = a[0]

        for i in range(1, len(a)):
            if a[i] > max_value:
                max_value = a[i]
            if a[i] < min_value:
                min_value = a[i]
        return (min_value, max_value)
