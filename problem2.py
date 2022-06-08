# Time Complexity : O(n)
# Space Complexity : O(1)
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
#


def getMinMax(a, n):
    mini = 1000000000001
    maxi = -1
    for i in range(0, n, 2):
        if i != n-1:
            if a[i] > a[i+1]:
                mini = min(mini, a[i+1])
                maxi = max(maxi, a[i])
            else:
                mini = min(mini, a[i])
                maxi = max(maxi, a[i+1])
        # if i is the last element, when len(array) is odd.
        else:
            mini = min(mini, a[i])
            maxi = max(maxi, a[i])
    return [mini, maxi]


print(getMinMax([1, 345, 234, 21, 56789], 5))
