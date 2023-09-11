'''
1. We can traverse through the entire array keeping a track of minimum and maximum and updating them. Takes 2(N-2) comparisons
2. Instead we can sort the array inplace and choose the first value as min and the last as maximum.

Method 1:
TC: O(n)
SC: O(1)
Method 2:
TC: O(nlogn)
SC: O(1)
'''
import numpy as np
import time
arr = [1,2,3,4,5,6,7,8,9,0]
min_val = np.Inf
max_val = -np.Inf

start = time.time()
for i in range(len(arr)):
    min_val = min(arr[i],min_val)
    max_val = max(arr[i],max_val)
print(f'Time taken for completion {(time.time()-start)*10**6:0.2f}')
print(f'Maximum value {max_val}, Minimum value {min_val}')

start = time.time()
arr.sort()
print(f'min {arr[0]}, max {arr[-1]}')
print(f'Time taken for completion {(time.time()-start)*10**6:0.2f}')
