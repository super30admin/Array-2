# 
# Time Complexity = O(n)
# Space Complexity = O(1) We are manipulating the input array
# 

def findDisappearedNumbers(nums):
    for i in nums:
        nums[abs(i)-1] = -abs(nums[abs(i)-1])
    res= []
    for i in range(len(nums)):
        if nums[i]>0:
            res.append(i+1)
    return res
