# Leetcode 448. Find All Numbers Disappeared in an Array

# Time Complexity : Hashmap & in place:  O(n) where n is the size of the array

# Space Complexity : O(1) for inplace and O(n) for hashmap

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Iterate over array with high and low pointers from the ends. If area is greater than maxx
# replace it.

# Your code here along with comments explaining your approach

class Solution:
    # Using additional hashmap for counting the elements Space Complexity O(n) length of hashmap
    def findDisappearedNumbers2(self, nums: List[int]) -> List[int]:
        size = len(nums)
        result = []
        counter = dict()

        # Adding the values into hashmap and ignoring duplicates
        for i in nums:
            counter[i] = 1

        # Checking the hashmap for every number in the range and appending them to result if absent
        for i in range(1, size+1):
            if i not in counter:
                result.append(i)

        return result

    # Using -1 as a way to mark a value as visited
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        size = len(nums)
        result = []

        # Getting index from the value and marking the value at that index as visited
        for i in range(size):
            index = abs(nums[i])-1
            nums[index] = abs(nums[index])*-1

        print(nums)
        # If the value is not marked as visited then return that index
        for i in range(size):
            if nums[i] > 0:
                result.append(i+1)

        return result
