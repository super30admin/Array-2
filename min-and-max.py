#find min and max
#using two pointer method to reduce the # of steps
#Time Complexity : O(n)
#Space Complexity: O(1)
def find(arr):
    res = []
    maxNum = arr[0]
    minNum = arr[0]
    #edge cases
    if len(arr) == 2:
        return [min(arr[0], arr[1]), max([arr[0], arr[1]])]

    for i in range(1, len(arr)-1, 2):
        if arr[i] < arr[i+1]:
            minNum = min(minNum, arr[i])
            maxNum = max(maxNum, arr[i+1])
        else:
            minNum = min(minNum, arr[i+1])
            maxNum = max(maxNum, arr[i])
    res.append(minNum)
    res.append(maxNum)
    return res

ans = find([-1, 0])
print(ans)
