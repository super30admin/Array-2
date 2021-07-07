#time comp- O(n) as we are traversing once
#space comp- O(1) no space used 
def min_max_array(arr):
  min_v=float('inf')
  max_v=float('-inf')
  for i in range(0,len(arr)):
    min_v=min(min_v,arr[i])
    max_v=max(max_v,arr[i])
  return min_v,max_v
arr=[1000, 11, 445, 1, 330, 3000]
min_v,max_v=min_max_array(arr)
print("min value is:",min_v)
print("max value is:",max_v)
