
# // Time Complexity :
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach





class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in nums:
            pos = abs(i) - 1
            if nums[pos] > 0 :
                nums[pos] *= -1
        
        for i in range(len(nums)):
            if nums[i] > 0 :
                result.append(i + 1)
            else:
                nums[i] *= -1
        return result

        
        