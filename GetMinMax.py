# // Time Complexity : o(n)  comparison 1.5n
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :faced issuues while getting intutition for reducing comparisons


# // Your code here along with comments explaining your approach
# idea is to take pairs and compare the two elements and then the low or high with either max or min and keep doing this handle cases for evn and odd lenght
def getMinMax(arr):
    n = len(arr)
    
    if(n % 2 == 0):
        
        if arr[0] < arr[1]:
            mn = arr[0]
            mx = arr[1]
        else:
            mn = arr[1]
            mx = arr[0]

        i = 2

    else:
        mx = mn = arr[0]
        i = 1

    while(i < n - 1):
        if arr[i] < arr[i + 1]:
            mx = max(mx, arr[i + 1])
            mn = min(mn, arr[i])
        else:
            mx = max(mx, arr[i])
            mn = min(mn, arr[i + 1])
        i += 2
    
    return (mx, mn)



arr = [1000, 11, 445, 1, 330, 3000]
arr_min, arr_max = getMinMax(arr)
print('Minimum element is ', arr_min)
print('nMaximum element is ', arr_max)