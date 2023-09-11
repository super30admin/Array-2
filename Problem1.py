'''
We can find the disappeared numbers in two ways.
1. Maintain a set of all numbers in the range 1 to the length of array. Subtract the unique elements of the array we have from it. We get missing values
2. We maintain an array of flags/nummbers of length = length of array. We traverse through given array and fill the flags at index num-1 for number num. The places that aren't filled are the uniques
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # return set(range(1,len(nums)+1)) - set(nums)

        arr = [0] * len(nums)
        for i in nums:
            arr[i-1] = i
        return [i for i in range(1,len(nums)+1) if arr[i-1]==0]