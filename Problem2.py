# Here we use pair-wisse comparision which ensures we use 3*N/2 comparisions which is less than 2 * (N-2)
# TC: O(N)
# SC: O(1)

def find_min_and_max(arr):
    if not arr:
        return None, None
    
    n = len(arr)
    
    if n == 1:
        return arr[0], arr[0]
    
    if n % 2 == 0:
        if arr[0] < arr[1]:
            current_min, current_max = arr[0], arr[1]
        else:
            current_min, current_max = arr[1], arr[0]
        start_index = 2
    else:
        current_min, current_max = arr[0], arr[0]
        start_index = 1

    for i in range(start_index, n, 2):
        if i + 1 < n:
            if arr[i] < arr[i + 1]:
                current_min = min(current_min, arr[i])
                current_max = max(current_max, arr[i + 1])
            else:
                current_min = min(current_min, arr[i + 1])
                current_max = max(current_max, arr[i])
        else:
            current_min = min(current_min, arr[i])
            current_max = max(current_max, arr[i])
    
    return current_min, current_max