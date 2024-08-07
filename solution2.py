# find max and min in an array

# time: O(n)
# space: O(1)
# number of comparisons: O(1.5 n)

arr = [1,2,3,4,5,-1,100]

min, max = float('inf'), float('-inf')
# compare in pairs

for i in range(len(arr) - 1):
    first = arr[i]
    second = arr[i+1]
    if first > second:
        if first > max:
            max = first
        if second < min:
            min = second
    else:
        if first < min:
            min = first
        if second > max:
            max = second

print(min, max)