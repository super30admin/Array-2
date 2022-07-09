"""
Runtime Complexity:
O(n) - because we run a for loop and take the absolute of indices and subtract 1 from each element. Because array of length 8 contains
8 elements and if you subtract 8 with 1, we get 7 which is the last index in our array since it starts from 0 index. We traverse and subtract 1 with
every element and go to the particular index and set it to negative. We do this for 'n' elements and we finally run a for loop
to check the positive numbers and append it to result array. We then finally return the result.
Space Complexity: O(1) - because the array length is fixed and missing numbers are always less than 'n' so we append only few elements to it. Worst case can be O(N) if all elements are added to result array.
Yes, the code worked on leetcode.
"""


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums)==0:
            return []
        n = len(nums)
        result = []
        for i in range(0,n):
            index = abs(nums[i])-1      #we take abs to avoid previously converted negative values in nums.
            if nums[index]>0:           #if the value is positive, means we have not encountered this index yet so we turn it to negative.
                nums[index] = nums[index]*-1
            else:
                continue
        print(nums)
        for i in range(0,n):
            if nums[i]>0:               #append the positive elements to result. i+1 gives the exact element missing where i is the index.
                result.append(i+1)
            else:
                nums[i] = nums[i] *-1      #else we change the elements in num to negative.
        return result