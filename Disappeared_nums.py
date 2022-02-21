# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def disappeared_nums(nums):
    i=0
    while i<len(nums):
        #to define correct index for value
        j= nums[i]-1
#basic idea is to put all nums at their correct index by swapping position and then check for elements which are not at correct index
        if nums[i]!=nums[j]:
            #swap
            nums[i],nums[j]=nums[j],nums[i]
        else:
            #num is at correct index 
            i=i+1
    
    res=[]

    for n in range(len(nums)):
        #n+1 because index starts from 0 
        if nums[n]!=n+1:
            res.append(n+1)
    return res

