# APPROACH 1 : BRUTE FORCE
# Time Complexity : O(n), n: length of nums
# Space Complexity : O(n), size of hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Create a hashmap to store the count of all unique elements of nums
# 2. Go through hashmap and check for those elements whose count is 0 and store them in result

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if not nums:
            return []
        
        hashmap = {}
        
        for num in range(1, len(nums) + 1):
            hashmap[num] = 0
            
        for num in nums:
            hashmap[num] += 1
        
        result = []
        for key in hashmap:
            if hashmap[key] == 0:
                result.append(key)
                
        return result
        
        

# APPROACH  2: OPTIMAL SOLUTION
# Time Complexity : O(n), n: length of nums
# Space Complexity : O(1), excluding the space of result array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Initialise result array with elements from 1 to n
# 2. For each element of nums, set it's corresponding element in result to 0 -> indicates that element exists in nums
# 3. shift the non-zero elements to left of result and pop out all excess 0 valued elements

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if not nums:
            return []
        
        result = [i for i in range(len(nums) + 1)]
        
        for num in nums:
            result[num] = 0
            
        insert_ptr, curr_ptr = 0, 1
        while curr_ptr < len(result):
            if result[curr_ptr] == 0:
                curr_ptr += 1
            else:
                result[insert_ptr] = result[curr_ptr]
                curr_ptr += 1
                insert_ptr += 1
                
        while insert_ptr < len(result):
            result.pop(-1)
            
        return result
        



# APPROACH 3: BEST OPTIMAL SOLUTION
# Time Complexity : O(n), n: length of nums
# Space Complexity : O(1), excluding the space of result array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Modify the nums itself. For each element of the nums, indicate it's existence by negating the value at the corressponding index
# 2. CAREFUL -> elements in future (not seen yet) might be negated, so while processing them, take their absolute value. And already negated elements dont need to negate again
# 3. Go thru nums, and add all those indices that don't have negative values

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if not nums:
            return []
        
        for ind in range(len(nums)):
            if nums[ind] < 0:
                temp = nums[ind] * - 1
            else:
                temp = nums[ind]
             
            if nums[temp - 1] > 0:
                nums[temp - 1] *= -1
            
        result = []
        for ind in range(len(nums)):
            if nums[ind] > 0:
                result.append(ind + 1)
                
        return result        
        
