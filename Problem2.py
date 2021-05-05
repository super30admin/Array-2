#Given an array of numbers of length N, find both the minimum and maximum.
#  Follow up : Can you do it using less than 2 * (N - 2) comparison


def find_min_max(nums):
    min_val = float('inf')
    max_val = float('-inf')

    for i in range(0,len(nums),2):
       
        if i == len(nums)-1:
            min_val = min(min_val,nums[i])
            max_val = max(max_val,nums[i])
            return min_val,max_val
        if nums[i+1] > nums[i]:
            max_val = max(max_val,nums[i+1])
            min_val = min(min_val,nums[i])
        else:
             max_val = max(max_val,nums[i])
             min_val = min(min_val,nums[i+1])
 
    return min_val,max_val


nums = [5,9,10,2,1]
print(find_min_max(nums))



