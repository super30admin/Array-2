# Time Complexity O(n). # comparisons for every pair
# Space Complexity O(1)
def getMinMax(arr):
    _len = len(arr)
    if _len == 1:
        pass
    if _len % 2 == 0:
        if arr[0] > arr[1]:
            _max = arr[0]
            _min = arr[1]
        else:
            _max = arr[1]
            _min = arr[0]
        i = 2
    else:
        _max = arr[0]
        _min = arr[0]
        i = 1

    while i < _len-1:
        if arr[i] > arr[i+1]:
            if _max < arr[i]:
                _max = arr[i]
            if _min > arr[i+1]:
                _min = arr[i+1]
        else:
            if _max < arr[i+1]:
                _max = arr[i+1]
            if _min > arr[i]:
                _min = arr[i]
        i += 2
    return _max, _min

