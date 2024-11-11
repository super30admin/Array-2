"""
TC: O(n)
SC: O(1)
"""
def getMinMax(arr):
    min_ = arr[0]
    max_ = arr[0]
    for a in arr:
        min_ = min(a,min_)
        max_ = max(a, max_)
    return (min_, max_)

arr = [1000, 11, 445, 1, 330, 3000]
print(getMinMax(arr))
