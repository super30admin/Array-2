# Time Complexity :
# O(N)

# Space Complexity :  
# O(1)  , Since answer is expected in form of array, array size for "result" doen't count towards increasing space complexity 



# Approach:
# ===> The numbers range from 1 to N, while indexes range from 0 to N-1. 
# ===> So the idea is, iterate over each element in the array, go to index given by (abs(nums[i])-1), and make the number negative if it was positive.
# ===> Finally, again iterate over the array and if the number was positive, then this means that this (index+1) is the number which is missing in the array.
#      Else, we just negate the sign, to bring back the original elements in the array

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums or len(nums) == 0:
            return []
        
        result = []

        for i in range(0, len(nums)):
            index = abs(nums[i]) - 1

            #if num at this index is positive, make it negative
            if(nums[index]>0):
                nums[index] = nums[index] * -1
        
        for i in range(0, len(nums)):
            # if number is positive, this means that this (index+1) was the element not present in the array
            if nums[i] > 0:
                result.append(i+1)
            # else we just negate the sign to bring back the original elements in nums
            else:
                nums[i] = nums[i] * -1

        return result        