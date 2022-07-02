# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Our return array
        retArr = []
        # A set to contain the unique numbers in the nums list that will give O(1) access time
        numsSet = set()
        # Add the num to the set
        for num in nums:
            numsSet.add(num)
        # Loop through 1 to n+1 to find the missing numbers
        for i in range(1, len(nums) + 1):
            # If not in the set, add to retArr
            if i not in numsSet:
                retArr.append(i)
        return retArr
