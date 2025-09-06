## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

# Method1: Using Hashset
# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Adding given array into set. Then running loop from 1 to n inclusive to check which elements are not in the set. Add the missing
# elements in our result

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # method-1
        # using hash set
        givenSet = set(nums)
        missArr = []
        for i in range(1, len(nums) + 1):
            if(i not in givenSet):
                missArr.append(i)

        return missArr
    

sol = Solution()
print("Method1: Using Hashset")
print(sol.findDisappearedNumbers([4,3,2,7,8,2,3,1]))
print(sol.findDisappearedNumbers([1,1]))


# Method2: Using boolean array
# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Keeping a boolean array to note the elements present in the array. If an index remains false, it means the corresponding value is missing

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # method-2
        # using boolean array
        boolArr = [False] * (len(nums))
        missArr = []
        for i in range(len(nums)):
            boolArr[nums[i] - 1] = True

        for i in range(len(nums)):
            if(not boolArr[i]):
                missArr.append(i + 1)

        return missArr
    
sol = Solution()
print("Method2: Using boolean array")
print(sol.findDisappearedNumbers([4,3,2,7,8,2,3,1]))
print(sol.findDisappearedNumbers([1,1]))


# Method3: Using given array to keep value flags
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# For each value, we get its corresponding index would by abs(value) - 1. Make the element at that index = negative of its current 
# value if it is already not negative. This negative sign would help us identify that value exists in the array . 
# When we are passing through the array again, we are checking which index number are still positive. (Index + 1) would give us
# the numbers that are missing. If it is negative, the corresponding element exists in the array.


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # method-3
        # Using given array to keep value flags
        missArr = []
        for i in range(len(nums)):
            # as we are updating values to negative, so to get the index
            # we should take absolute. because it is possible that the current value has already been made negative
            if(nums[abs(nums[i]) - 1] > 0):
                # for each value, get the corresponding index, mark the value at that index as negative if it is already not negative
                nums[abs(nums[i]) - 1] = (-1) * nums[abs(nums[i]) - 1]

        
        # check which values at which indices are positive. The value corresponding to that index are the missing values. Also get the input array back
        for i in range(len(nums)):
            if(nums[i] > 0):
                # missing value
                missArr.append(i + 1)
            else:
                # get back the input array
                nums[i] = (-1) * nums[i]

        return missArr
    

sol = Solution()
print("Method3: Using given array to keep value flags")
print(sol.findDisappearedNumbers([4,3,2,7,8,2,3,1]))
print(sol.findDisappearedNumbers([1,1]))
print(sol.findDisappearedNumbers([4,3,2,7,8,6,5,1]))