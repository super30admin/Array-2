# Time Complexity: O(n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: Understnading the logic of the indexing and and marking the visited numbers

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if not nums:
            return []

        res = []

        for i in range(len(nums)):
            # Use the absolute value of the number as an index
            # Mark the number at that index as negative to indicate it has been seen
            # We subtract 1 from the absolute value to convert it to a zero-based index
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1

        for i in range(len(nums)):
            # If the number at index i is positive, it means the number i+1 was not seen
            # So we add i+1 to the result list
            # We add 1 to convert the zero-based index back to the original number
            if nums[i] > 0:
                res.append(i+1)

        return res