def missing_number_hashset(nums):
    num_set = set(nums)
    n = len(nums)
    
    for i in range(n + 1):
        if i not in num_set:
            return i

#space O(n)
#time O(n)
