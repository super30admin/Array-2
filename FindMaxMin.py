# TC = O(n)
# SC = O(1)
# In linear search we are making approximately 2n comparisions. In order to reduce the number of comparisions we can compute in pairs. For each pair thereb are 3 comparisions- within themselves, with curr max, with curr min. There are n/2 pairs(~even). Hence 3n/2 comparisions which lower than prior methos.

def minMax(arr):
    n = len(arr)
    if(n % 2 == 0):
        mx = max(arr[0], arr[1])
        mn = min(arr[0], arr[1])
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
     
# Driver Code
arr = [1000, 11, 445, 1, 330, 3000]
mx, mn = minMax(arr)
print("Minimum element is", mn)
print("Maximum element is", mx)
     
# This code is contributed by Kaustav