# Brute Force: TC = O(n), SC = O(1)
# Comparisons = 2*(N) (2 because we compare for min and max in each case.)
nums = [3,7,1,-5,0,88,22,-223]
min_num = float('inf')
max_num = float('-inf')
for i in range(len(nums)):
    min_num = min(nums[i],min_num)
    max_num = max(nums[i],max_num)
print(min_num, max_num)

# Optimizing BF a little bit: Comparisons = 2*(N-1).
# -1 as we are keeping the first element as min and max initially and starting our loop from 2nd element.
n_min = nums[0]
n_max = nums[0]
for i in range(1, len(nums)):
    n_min = min(nums[i],n_min)
    n_max = max(nums[i],n_max)
print(n_min, n_max)

# Optimizing comparisons.
# If min is updated, max won't be updated and vice versa.
min_n = nums[0]
max_n = nums[0]
for i in range(1, len(nums)):
    if min_n > nums[i]:
        min_n = nums[i]
    elif max_n < nums[i]:
        max_n = nums[i]
print(min_n, max_n)