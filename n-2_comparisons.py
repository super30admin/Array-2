'''

Inorder to find out the max and min of the array, we generally go over the array.
While going through the array, lets say array have n elements.
To make min and max comparison at every element, we make 2*n comparisons.

In the current approach.

We are taking two elements in one go, that is we. re reducing the number of comparisons
to n/2.

and at each step we are making 3 comparisons, which is totally equal to 3*n/2=1.5n

which means we are reducing the total comparison from 2*n to 1.5 n.

If the length is odd, we are making two extra comparison, which is 1.5n+2

Although the time complexity remains at O(n), we are reducing the comparisons to 1.5n+2

'''

## Example :[-12,4,-18,6,25]

# nums =[-12,4,-18,6,25]


nums=[-12, 4, -18, 6, 25, -204]



min_num = float('inf')
max_num  = float('-inf')

for i in range(0, len(nums)-1, 2):
  if nums[i]<nums[i+1]:
    min_num = min(min_num, nums[i])
    max_num = max(max_num, nums[i+1])
  else:
    min_num = min(min_num, nums[i+1])
    max_num = max(max_num, nums[i])


if(len(nums)%2==1):
  min_num = min(nums[-1], min_num)
  max_num = max(nums[-1], max_num)

print(min_num, max_num)


