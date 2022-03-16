#  Time Complexity : O(n) reduced comparision 3n/2-1
#  Space Complexity : O(1)
def getMinMax(arr):
    if(len(arr) % 2 == 0):
        max_el = max(arr[0], arr[1])
        min_el = min(arr[0], arr[1])
        i=2
    else:
        min_el = max_el = arr[0]
        i=1
    while(i < len(arr)-1):
        if arr[i] < arr[i+1]:
            min_el = min(min_el,arr[i])
            max_el = max(max_el,arr[i+1])
        else:
            min_el = min(min_el,arr[i+1])
            max_el = max(max_el,arr[i])
        i += 2
    
    return(min_el,max_el)
            
