#find disappeared numbers

# // Time Complexity : O(N)
# // Space Complexity : O(1) because we are returning the  array we use
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def findDisappearedNumbers( nums):
    res=[]
    for i in range(len(nums)):
        index = abs(nums[i])-1
        if nums[index]>0:
            nums[index] = -nums[index]                      #change the index that exists to negative value
    for i in range(len(nums)):
        if nums[i]>0:                                       #if the index is not of negative value, we know that they do not exist
            res.append(i+1)
    return res

#testing
print(findDisappearedNumbers([4,3,2,7,8,2,3,1]))