# Time complexity - O(3n/2) (where n = length of the array)
# Space Complexity: O(1) 
# Problems faced while coding this:None
# Approach : Traverse in pairs and iterate over the array and compare max and min.

arr = [10, 1, 45, 30, 12]

def find_min_max(self):
    min_num = float('inf')
    max_num = -float('inf')

    i = 0
    while i + 1 < len(arr):
        #print(i)
        small, big = (arr[i], arr[i+1]) if arr[i] < arr[i+1] else (arr[i+1], arr[i])
        min_num = min(min_num, small)
        max_num = max(max_num, big)
        i += 2

    if i < len(arr):
        min_num = min(min_num, arr[i])
        max_mum = max(max_num, arr[i])

    return (min_num, max_num)

print(find_min_max(arr))