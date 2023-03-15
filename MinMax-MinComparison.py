#Time Complexity - O(n)
#Space Complexity - O(1)

class Solution:
    def minimumDeletions(self, nums):
        i = 0
        max= 0
        min = 0
        length = len(nums)

        if length % 2 == 0:
            if nums[0] > nums[1]:
                max=nums[0]
                min=nums[1]
            else:
                min=nums[0]
                max=nums[1]       
            i += 2   
        else:
            min=nums[0]
            max=nums[0]  
            i += 1

        while(i < length ):
            if nums[i] > nums[i+1]:
                if nums[i] > max:
                    max=nums[i]
                if nums[i+1] < min:
                    min = nums[i+1]
            else:
                if nums[i+1] > max:
                    max=nums[i+1]
                if nums[i] < min:
                    min = nums[i]
            i += 2
            
        return min, max