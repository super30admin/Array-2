# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
## we have to find the numbers that are missing between 1-n 
# we do this inplace by maipulating the values. we go through the list and each value in the list is treated aas an index 
# ##nums[value-1] and we check if it is not -ve and make it negative.
# ## there were some number missing then the value in their coresponding index would be +ve.
# we traverse through the list again and check which element is positive and resturn those elements. 
class solution:
    def disappearedNumbers(self, nums):
        res = []

        for i in range(len(nums)):
            index = abs(nums[i])
            if nums[index-1] >0:
                nums[index-1] *=-1

        for i in range(1,len(nums)+1):  
            if nums[i-1]>0:
                res.append(i)

        return res


