# Time: O(n^2)
# Space: O(1)
# Using nested loops check if the number is there
# have a i that loops from 1 to the length of nums + 1 so that every number is covered
# Then looping through the elements in nums check if i is present
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(1,len(nums)+1):
            is_there = False
            for num in nums:
                if i == num:
                    is_there = True

            if not is_there:
                result.append(i)
        return result

    
# Time: O(nlogn)
# Space: O(1)
# First sort the array then loop from 1 to len of the array and if the curr element is greater than the prev element+1 then add all the elements missing
# Consider the first and last element edge cases
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        my_arr = sorted(nums)
        result = []
        if my_arr[0] > 1:
            for x in range(1, my_arr[0]):
                result.append(x)
        for i in range(1,len(my_arr)):
            if my_arr[i] == my_arr[i-1]:
                continue
            if my_arr[i] > my_arr[i-1]+1:
                for j in range(my_arr[i-1] + 1,my_arr[i]):
                    result.append(j)
        if my_arr[-1] < len(my_arr):
            for x in range(my_arr[-1] + 1, len(my_arr) + 1):
                result.append(x)
        return result
    
# Time: O(n)
# Space: O(n)
# First add every element in the hashset
# Then loop through i from 1 to number of elements and find if that i is there in hashset if not append to result
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        my_set = set()
        result = []

        for num in nums:
            my_set.add(num)
        for i in range(1,len(nums)+1):
            if i not in my_set:
                result.append(i)
        return result
    
# Time: O(n)
# Space: O(1)
#   TEMPORARY STATE CHANGE
# First while looping through the numbers make the indexes associated with the number negative if not already negative
# Then in a second pass make all the negative elements positive and return the numbers that are associated with positive indexes
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            idx = abs(num)
            if nums[idx-1] > 0:
                nums[idx-1] *= -1
        result = []
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] *= -1
            else:
                result.append(i+1)
        return result