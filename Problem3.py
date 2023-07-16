# Approach1: Sort 
# Time Complexity: O(nlogn)
# Space Complexity: O(1)
arr = [3,5,4,1,9]
arr.sort()
print("Minimum element", arr[0])
print("Maximum element", arr[-1])


# Approach2: using 2 variables  (2 comparisions(min,max) on each element)
# Time Complexity: O(n)
# Space Complexity: O(1)
arr = [4,8,1,-1,2,-3,0]
max = float('-inf')
min = float('inf')

for i in arr:
    if i < min:
        min = i
    elif i > max:
        max = i
print("Minimum element", min)
print("Maximum element", max)




# Approach3: lets reduce the comparisons from 2n to 3*(n/2) - by making use of 2 pointers
# n/2 pairs, each pair - 3 comparisions
# Time Complexity: O(n)
# Space Complexity: O(1)

arr = [4,8,1,-1,2,-3,0]
pointer1 = arr[0]
pointer2 = arr[1]

minimum = min(float('inf'), pointer1)
maximum = max(float('-inf'), pointer2)

for i in range(2,len(arr)-1):
    if arr[i] < arr[i+1]:                  
        minimum = min(maximum, arr[i])
        maximum = max(maximum, arr[i+1])
    else:
        minimum = min(maximum, arr[i+1])
        maximum = max(maximum, arr[i])
print("Minimum element", minimum)
print("Maximum element", maximum)