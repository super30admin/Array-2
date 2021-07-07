#Time Complexity :  O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no



def minmax(arr):
    n = len(arr)
    if n==0:
        return (0,0)
    else:
        if n%2==0:
            min_ele = min(arr[0],arr[1])
            max_ele = max(arr[0],arr[1])
            i = 2
        else:
            min_ele = arr[0]
            max_ele = arr[1]
            i =1
        while (i<n-1):
            if arr[i]>arr[i+1]:
                max_ele = max(max_ele,arr[i])
                min_ele = min(arr[i+1],min_ele)
            else:
                max_ele = max(max_ele,arr[i+1])
                min_ele = min(min_ele,arr[i])
            i=i+2

        return min_ele,max_ele


arr = [1000, 1, 445, 1, 1, 3000]
mn, mx = minmax(arr)
print("Minimum element is", mn)
print("Maximum element is", mx)

    