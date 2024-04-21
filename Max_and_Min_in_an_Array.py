#TC: 3*(n/2)
#SC: O(1)

arr= [4,2,-1,0,8,7,3,-2]

min_no=float('inf')
max_no=float('-inf')

for i in range(len(arr)):
    if i <= len(arr)-2:
        if arr[i]>arr[i+1]:
            max_no=max(max_no,arr[i])
            min_no=min(min_no,arr[i+1])
        else:
            max_no=max(max_no,arr[i+1])
            min_no=min(min_no,arr[i])
    else:
        max_no=max(max_no,arr[i])
        min_no=min(min_no,arr[i])
    
print("Min: " + str(min_no) + " and Max:" + str(max_no))