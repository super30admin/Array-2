# Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
# TC = O(n)
# SC = O(1)
#Did this code successfully run on Leetcode : Yes
# Use the array itself to mark which numbers exist: for each value seen, 
# flip the number at its corresponding index (value-1) negative, 
# then any index still positive after that means its corresponding number (index+1) was never found.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)  
        result = []  
        for i in range(n):             # marking pass: go through every index in the array
            index = abs(nums[i]) - 1   # convert this value into the index it "belongs to" (use abs() since it may already be flipped negative)
            if nums[index] > 0:        # check if that target index hasn't been marked yet
                nums[index] *= -1      # flip it negative to record "this number exists"

        for i in range(n):              # checking pass: go through every index one more time
            if nums[i] > 0:             # still positive means nothing ever pointed to this index
                result.append(i + 1)    # convert index back to value and mark it missing

        return result  