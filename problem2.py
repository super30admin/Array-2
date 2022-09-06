'''
MIN MAX IN AN ARRAY WITH LESS THAN (2N-2) COMPARISONS

TIME COMPLEXITY: For comparison (3n/2-2) comparisons
SPACE COMPLEXITY: O(1)
CUSTOM TEST CASES: Yes
DIFFICULTY: yes, it took a while to code without seeing the lecture
'''


import random

def driver(nums):

    min_ele, max_ele = None, None
    
    if nums[0] < nums[1]:
        min_ele, max_ele = nums[0], nums[1]
    else:
        min_ele, max_ele = nums[1], nums[0]
    
    n = len(nums)
    
    if n % 2 == 0:
        r  = n - 1
    else:
        r = n - 2
        
    for i in range(2, r, 2):
        t_min, t_max = None, None
        if nums[i] < nums[i+1]:
            t_min, t_max = nums[i], nums[i+1]
        else:
            t_max, t_min = nums[i], nums[i+1]
        
        if t_min < min_ele:
            min_ele = t_min
        if t_max > max_ele:
            max_ele = t_max
    
    if n % 2 != 0:
        if nums[n-1] < min_ele:
            min_ele = nums[n-1]
        
        if nums[n-1] > max_ele:
            max_ele = nums[n-1]
    
    return (min_ele, max_ele)

cnt = 0

for i in range(0, 100):
    nums = []
    for i in range(0, random.randint(2, 100000)):
        nums.append(random.randint(-1 * (2 ** 31), (2 ** 31)))
    a = ( min(nums), max(nums) )
    b = driver(nums)
    if a == b:
        cnt += 1
    

print('{} test cases passed out of 100'.format(cnt))


    
