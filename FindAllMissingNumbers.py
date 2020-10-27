#Time Complexity : O(n)
#Space Complexity : o(1) (Since output array is counted as auxilary space)

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Since all values in the problem are between 1 to N there can be no negative numbers in the array, plus the number has to be between 1 to N. So, iterating through the array  if we come across a number we just make that numbered index negative (if it's the first time we came across that number, since there can be repetitions). And then finally we go through the array and see if the number at that index is negative or not, if it is positive then that means the number is not present in the array and thus we append to result array.

#Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #optimized
        missing = []

        #All the numbers present, make that numbered index negative
        for i in range(len(nums)):
            #if number is not present
            if nums[abs(nums[i])-1] > 0:
                nums[abs(nums[i])-1] *= -1

        #find all numbers which are not present in the array
        for i in range(1, len(nums)+1):
            if nums[i-1] > 0:
                missing.append(i)

        return missing

        #using extra space
#         n = len(nums)
#         allNumbers = set(nums)
#         missing = []

#         for i in range(1,len(nums)+1):
#             if i not in allNumbers:
#                 missing.append(i)

#         return missing
