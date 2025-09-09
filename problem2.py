
"""
Space Complexity: O(1) 

Time Complexity: O(N) -> Linear as we keep shrinking the two pointers

"""
def compare(arr): 

    left = 0
    right = len(arr)-1 
    minn = arr[0]
    maxx = arr[0]
    
    while left <= right: 
        
        if arr[left] < arr[right]: 
            minn = min(minn, arr[left])
            maxx = max(maxx, arr[right])
        else: 
            minn = min(minn, arr[right])
            maxx = max(maxx, arr[left])
            
        left +=1
        right-=1
        
    return minn, maxx


print(compare([1,2,3,4,5,6,7,8,9]))            
        
        
