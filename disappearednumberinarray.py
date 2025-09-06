# Time Complexity : O(N)
# Space Complexity : O(N)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a set to store the elements present in the input array.
# Then, I iterate through the range from 1 to n. For each number in this range,
# I check if it is present in the set. If it is not present, I add it to the result list.
# Finally, I return the result list containing all the numbers that are missing from the input array.


from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        sets = set(nums)
        ans = []
        for i in range(1,len(nums)+1):
            if i not in sets:
                ans.append(i)
        return ans