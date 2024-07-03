# // Time Complexity : O(n) 
# // Space Complexity : O(1)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : understanding the m=multiply by negative was a bit tricky.


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        ans = []
        for i in range(len(nums)):
            x = abs(nums[i])
            if nums[x - 1] > 0:
                nums[x-1] = -1 * nums[x-1]
        print(nums) 
        for i in range(len(nums)):
            if nums[i] > 0:
                ans.append(i+1)    
        return ans
    
    #Approach
    # I initially had done the hashset approach where i had the hashset and then i was iterating over the length of array and checking bit after that i did the approach
    # taught in the class