#Time Complexity :O(3n/2)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findMinMax(nums):
        n=len(nums)
        minVal=float("inf")
        maxVal=-float("inf")

        # Comparing 2 adjacent elements to find min and max value 
        # 3 comparisions: if statement,minVal and MaxVal 
        for i in range(0,n-1,2):
            if nums[i]<nums[i+1]:
                minVal=min(minVal,nums[i])
                maxVal=max(maxVal,nums[i+1])
                i+=2
            else:
                minVal=min(minVal,nums[i+1])
                maxVal=max(maxVal,nums[i])
                i+=2

        #if array length is odd
        if n%2!=0:
            if minVal>nums[n-1]:
                minVal=nums[n-1]
            if maxVal<nums[n-1]:
                maxVal=nums[n-1]      
        
        return [minVal,maxVal]
            
        
array=[4,8,1,-1,2,-3,100]
print(Solution.findMinMax(array))
        