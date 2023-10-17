class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        """
        Time Complexity: O(n)
        Space Complexity: O(1)
        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this: No
        Your code here along with comments explaining your approach:
        The approach: 
            - Traverse the array 
            - check each element and see if (element - 1)th index is > 0:
                - if yes -> multiply it with -1 
                - if not -> don't do anything
                - by doing this we get a list where all the numbers which are present, the corresponding 
                index value is negative. The number which are not present, they are negative
                - We go through the loop again, we change all the negatives to positives and we get the index of the
                positive elements and add them by 1 and store it in a list
                - we return the list, that's the answer
        """
        for i in range(0, len(nums)):
            if nums[abs(nums[i]) - 1] > 0:
                nums[abs(nums[i]) - 1] *= -1
        res = list()
        for i in range(0, len(nums)):
            if nums[i] > 0:
                res.append(i+1)
            else:
                nums[i] *= -1
        return res
