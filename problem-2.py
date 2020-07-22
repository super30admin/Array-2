"""
Approach

1.we compare pair the elements of the array in a group of 2 and find the min and max from that pair. 
2. To find the min and max from the pair it will take one comparision and then it will take 2 comparision to update the min and max from the second pair onwards
3. it would take 3n/2 -2 in total
"""


# Time Complexity : O(n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

arr = [2,1,3,4,5,8,10,9]
def getMinMax(arr):
    n = len(arr)
    if (n % 2 == 0):
        mx = max(arr[0], arr[1])
        mn = min(arr[0], arr[1])
        i = 2
    else:
        mx = mn = arr[0]
        i = 1

    # In the while loop, pick elements in pair and
    # compare the pair with max and min so far
    while (i < n - 1):
        if arr[i] < arr[i + 1]:
            mx = max(mx, arr[i + 1])
            mn = min(mn, arr[i])
        else:
            mx = max(mx, arr[i])
            mn = min(mn, arr[i + 1])
        i += 2

    return (mx, mn)

print(getMinMax(arr))
                