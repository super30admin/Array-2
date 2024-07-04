"""
Time complexity: o(n)
Space complexity: o(1)
"""

def minmax(arr):
    minvalue, maxvalue = arr[0], arr[0]
    
    if len(arr)% 2 == 0:
        i = 0
    else:   
        i = 1
    
    while(i < len(arr)-1):
        if(arr[i] < arr[i+1]):
            minvalue = min(minvalue, arr[i])
            maxvalue = max(maxvalue, arr[i+1])
        else:
            minvalue = min(minvalue, arr[i+1])
            maxvalue = max(maxvalue, arr[i])
            
        i += 2
            
    return [minvalue, maxvalue]
