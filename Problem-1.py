'''
    Time Complexity: O(2n)
    Space Complexity: O(1)
    Ran successfully on leetcode: 
    Approach: Iterate through the array to check the appearance of the numbers, if the number is present change the number at the corresponding index to negative. 
    Iterate the array again to convert the negative numbers to original and to return the index of positive numbers.
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []

        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
            
        for i in range(n):
            if nums[i] < 0:
                nums[i] *= -1
            else:
                result.append(i+1)

        return result