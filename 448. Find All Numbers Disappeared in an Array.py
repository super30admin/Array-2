"""
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        """
        Key : 1 to N elements.
        Loop through the elements and make value-1 index to negative.
        The index whose values are positive there we are missing numbers.
        """
        # Run Time Complexity : O(N)
        # Space Complexity : O(K) Assuming there will be K missing nmbers in a given array.
        for i in nums:
            if i < 0:
                pos = abs(i)
                if nums[pos-1] > 0:
                    nums[pos-1] = -1 * nums[pos-1]
            else:
                if nums[i-1] > 0:
                    nums[i-1] = -1 * nums[i-1]
        res = []
        print(nums)
        for i in range(len(nums)):
            if nums[i] < 0:
                continue
            else:
                res.append(i+1)
        return res
            
        