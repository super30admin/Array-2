"""448. Find All Numbers Disappeared in an Array
Time Complexity - O(n)
Space Complexity - O(1)
Using index to verify if that element is present in list the list or not
Iterating through entire list and finding out an index from number i.e. index = number[x] - 1 if value on that index is greater than 0 then put a negative value
Then iterating through the list and identifying indexes that has positive element and index+1 element is missing from list
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        output = []
        "Checking if number corresponds to an index"
        for x in nums:
            index = abs(x) - 1
            if nums[index] > 0:
                nums[index] *= -1
        
        "Verifying which elements are not present in list"
        for index in range(len(nums)):
            if (nums[index] > 0):
                output.append(index+1)
        return output
        