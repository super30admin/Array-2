
# Time Complexity - O(n)
# Space Complexity - O(1)


class Solution:
    def findMinMax(self, nums):
        minVal = float('inf')
        maxVal = float('-inf')
        if len(nums) == 1 :
            minVal = nums[0]
            maxVal = nums[0]  
        else :
            if nums[0] > nums[1]:
                minVal = min(minVal,nums[1])
                maxVal = max(maxVal,nums[0]) 
            else :
                minVal = min(minVal,nums[0])
                maxVal = max(maxVal,nums[1]) 

            for i in range(2,len(nums)-1,2):
                if nums[i] > nums[i+1]:
                    minVal = min(minVal,nums[i+1])
                    maxVal = max(maxVal,nums[i]) 
                else :
                    minVal = min(minVal,nums[i])
                    maxVal = max(maxVal,nums[i+1]) 
            if len(nums) % 2 == 1:
                maxVal = max(maxVal, nums[-1])
                minVal = min(minVal, nums[-1])

        return minVal, maxVal




        

nums = [4, 3, 2, 7, 8, 2, 3, 1]
sol = Solution()
result = sol.findMinMax(nums)
print(result)

