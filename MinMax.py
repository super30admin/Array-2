#If n is odd : 3(n-1)/2 comparions
#If n is even : 1 + 3(n-2)/2 comparisons
def minMax(arr):
    
    if len(arr) % 2 == 0:
        least = arr[0]
        highest = arr[1]
        if(highest < least):
            temp = highest
            highest = least
            least = temp
        i = 2
    else:
        least = highest = arr[0]
        i = 1
        
    
    while(i < len(arr)-1):
        if arr[i] > arr[i+1]:
            highest = max(highest, arr[i])
            least = min(least, arr[i+1])
        else:
            highest = max(highest, arr[i+1])
            least = min(least, arr[i])
        i += 2
            
    return (highest,least)


print(minMax([1,2,31,230,0]))
