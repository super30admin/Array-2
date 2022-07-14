# Time Complexity : O(N) //As it would run for each number of elements in the array
#  Space Complexity : O(1) //As we are using the same array to return the result
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res=[]
        
        #Iterate over nums and subtract 1 from each value to jump to its index and make it negative
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
        #Check again to find the positive numbers and retrun their index +1 in a list
        for i in range(n):
            if nums[i] > 0:
                res.append(i+1)
            else:
                nums[i] = nums[i] * -1
        return res