# TC : O(n)
# SC : O(1)
# Approach : Goal is to minimize number of comparisons we make, so we process elements in pairs, change min and max 
# at every iteration. We reach end of list, we will have max and min. 

def getMinMax(arr):
     
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
     
if __name__ =='__main__':
     
    nums = [1000, 11, 445, 0, -1, -2, 8000, 50, 1, 330, 3000]
    Max, Min = getMinMax(nums)
    print("Minimum element is :", Min)
    print("Maximum element is :", Max)