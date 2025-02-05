# https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/


# Time Complexity : O(3n/2) ~ O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : GFG yes
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

# check if the length of the array is even or odd, even then assign the max value of 0 and 1 
#  to maxn and the min to minn and initiate i = 2, if its odd then assign nums[0] to both maxn and minn 
# and initiate i = 1 and then make pairwise comparison. the TC is 3 * (n-1)/2 for odd, 3 * (n-2)/2 + 1 for even.



class Solution:
    def getminmax(nums: List(int)) -> int:
        n = len(nums)
        if(n%2 == 0):
            if (nums[0] < nums[1]):
                maxn = nums[1]
                minn = nums[0]
            else:
                maxn = nums[0]
                minn = nums[1]
            i = 2
        else:
            maxn = nums[0]
            minn = nums[0]
        
            i = 1
        
        while(i < n - 1):
            if nums[i] < nums[i + 1]:
                maxn = max(maxn, nums[i + 1])
                minn = min(minn, nums[i])
            else:
                maxn = max(maxn, nums[i])
                minn = min(minn, nums[i + 1])

            i += 2

        return maxn, minn
            
