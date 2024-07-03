# Time : O(N)
# Space: O(N)
def disappeared_nos(nums):
    n = len(nums)
    for i in range(0,n):
        cur_num= abs(nums[i])
        index = cur_num - 1
        if nums[index]>0:
            nums[index] *= -1

    res = []
    for i in range(0,n):
        if nums[i]>0:
            res.append(i+1)
    
    return res

nums = [4,3,2,7,8,2,3,1]
print(disappeared_nos(nums))
