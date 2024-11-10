# // Time Complexity : O(n) for traveral twice
# // Space Complexity : O(1) for res output
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
# This problem can be solved in may ways. Best way was to multiply each item by -1 in original array.
# Since original array doesn't have negative values we can multiply by -1.
# for all indices positive we can get the missing no back. 

class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        n = len(nums)
        res = []
        # Let us assume the array is [4,2,3,1,7,8]
        for i in range(n):          # for 4 
            idx = abs(nums[i])-1    # at index location 3
            if nums[idx] > 0:       # if not already negative
                nums[idx] *= -1     # make negative

        for i in range(n):
            if nums[i] < 0:         # //not needed//get original array back
                nums[i] *= -1
            else:                   # our output
                res.append(i+1)
        return res            



# class Solution:
#     def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
#         n = len(nums)
#         res = []
#         # [4,2,3,1,7,8]
#         for i in nums:                                # for 4                    
#             nums[abs(i)-1] = -1* abs(nums[abs(i)-1])  # nums value keeps updating negative

#         for i in range(n):
#             if nums[i] > 0:
#                 res.append(i+1)
#         return res     