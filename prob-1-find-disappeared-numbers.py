class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        """
        Time Complexity: O(n)
        Space Complexity: O(n)
        Did this code successfully run on Leetcode: Yes
    
        Any problem you faced while coding this: No
    
        """
        hash_table = {}
        # Store numbers to hash table
        for num in nums:
            hash_table[num] = 1

        print (hash_table)
        # Result array to contain missing numbers
        result = []

        # Iterate over 1..N
        for i in range(1, len(nums)+1):
            if i not in hash_table:
                result.append(i)

        return result
