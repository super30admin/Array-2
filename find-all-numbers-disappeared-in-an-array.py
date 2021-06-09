# Time Complexity : O(n)
# Space Complexity : O(1) in the alternate approach
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english: 
#create an array of the same length as nums but index starting from 1 since the question mentions [1,n]
#make a set of the new array and the nums given so that we can do a set difference ooperation
#Convert it into a list since the return type is a list
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # nums.sort()
        arr = [i for i in range(1,len(nums)+1)]
        return list(set(arr) - set(nums))

#Alternative approach: Without extra space
#check if the index position of the nums element is positive
#make it negative to indicate that, that index exists
#traverse through the array and if any element is positive, its index is missing 
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        arr = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                arr.append(i+1)
            else:
                nums[i] *= -1
        return arr
                
        