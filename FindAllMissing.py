#Time Complexity : O(n)
#Space Complexity : O(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        output = []
        
        index = 0
        
        while(index < len(nums)):
            if nums[index] < 0:
                markIndex = -1 *nums[index]
            else:
                markIndex = nums[index]
            if nums[markIndex-1] > 0:
                nums[markIndex-1] = -nums[markIndex-1]
            index += 1
        
        for i in range(n):
            if nums[i] > 0:
                output.append(i+1)
        return output
                
