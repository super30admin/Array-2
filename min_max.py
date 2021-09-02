# min_max
# time complexity: O(N)
# space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

def get_min_max(arr):
    i = 0
    n = len(arr)
    max_element = arr[i]
    min_element = arr[i]
    while (i < n - 1):
        if arr[i] < arr[i + 1]:
            max_element = max(max_element, arr[i + 1])
            min_element = min(min_element, arr[i])
        else:
            max_element = max(max_element, arr[i])
            min_element = min(min_element, arr[i + 1])

        i += 2

    return [max_element, min_element]


if __name__ =='__main__':
    arr = [2,5,-6,4,6,7,200,-1000]
    res = get_min_max(arr)
    print("Minimum element-->", res[1])
    print("Maximum element-->", res[0])