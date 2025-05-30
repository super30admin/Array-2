# Time Complexity : O(n), where n is the length of nums
# Space Complexity : O(1), ignoring the output list (done in-place)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        # Loop through each number and mark the index it points to as negative
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -nums[index]
        
        res = []
        # All indices with positive values are the missing numbers
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)
        
        return res
    
        #Naive Approach
        # arr = [0] * len(nums)

        # for i in range(len(nums)):
        #     arr[nums[i] - 1] += 1

        # res = []
        # for i in range(len(nums)):
        #     if arr[i] == 0:
        #         res.append(i + 1)
        
        # return res

if __name__ == "__main__":
    sol = Solution()
    print(sol.findDisappearedNumbers([4,3,2,7,8,2,3,1]))  # Output: [5, 6]
    print(sol.findDisappearedNumbers([1,1]))              # Output: [2]
