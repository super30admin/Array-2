#Find minimum and maximum in an array
# Method 1
# No. of comparison 2N
def find_min_max(arr):
  Min, Max = arr[0], arr[0]
  for num in arr:
    if num < Min:
      Min = num
    if num > Max:
      Max = num
  return Min, Max

# Optimal Solution
# Number of comparison = 1.5N 
def find_min_max2(arr):  
  Min = float('inf')
  Max = float('-inf')
  i = 0
  while i < len(arr)-1:
    if arr[i]>=arr[i+1]:
      Max = max(arr[i],Max)
      Min = min(arr[i+1], Min)
    else:
      Max = max(arr[i+1],Max)
      Min = min(arr[i],Min)
    i += 1
  return Min, Max


# Example usage
arr = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
min_val, max_val = find_min_max2(arr)
print(f"Minimum: {min_val}, Maximum: {max_val}")
