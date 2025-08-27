# We are parsing through all the nums and based on the value, we go to the particular index and if it’s not negative already, we update it to be negative. This way, if a number is positive then we can add the index with it to the result.
# Time complexity is O(n) and space complexity is O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for i,n in enumerate(nums):
            new_index = abs(nums[i])-1
            if nums[new_index] > 0:
                nums[new_index]*= -1
        for i,n in enumerate(nums):
            if n>0: # missing number
                res.append(i+1)    
            else: # restore the array
                nums[i]*=-1   
        return res    
        

# Another approach is to swap the elements to their correct index. For example, if we have 4 at index 0, we swap it with the element at index 3. We keep doing this until the element at the current index is equal to the index + 1. After this, we parse through the array and if the element is not equal to index + 1, we add index + 1 to the result.
# Time complexity is O(n) and space complexity is O(1)
# But, we can't retrive the original array
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for i,n in enumerate(nums):
            while nums[i]!= nums[n-1]:
                nums[i], nums[n-1] = nums[n-1], nums[i]
                n = nums[i]
        for i,n in enumerate(nums):
            if n!= i+1:
                res.append(i+1)
        return res
