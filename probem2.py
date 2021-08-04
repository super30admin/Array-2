#get min and max of an array 
#Time complexity: O(n)

def getMinMax(arr):
    n = len(arr) #intitalize n as the len of arr
    if(n % 2 == 0): #check if array is even in size or odd in size
        mx = max(arr[0], arr[1])# if even set mx to a value comparing 0 and 1 values 
        mn = min(arr[0], arr[1])
         
        # set the starting index for loop
        i = 2 #set start as 2 
    else:
        mx = mn = arr[0] #if odd set value at 0 index 
        # set the starting index for loop
        i = 1# start at 1
    while(i < n - 1):
        if arr[i] < arr[i + 1]:
            mx = max(mx, arr[i + 1])
            mn = min(mn, arr[i])
        else:
            mx = max(mx, arr[i])
            mn = min(mn, arr[i + 1])
             
        # Increment the index by 2 as two
        # elements are processed in loop
        i += 2
     
    return (mx, mn)