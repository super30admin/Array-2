"""

MISSING ELEMENT WITH NO EXTRA SPACE

Brute force -  for all the numbers in the given range, we check the number is there at the corresponding index, 
if not, we append it to the soln
Or we can also use a set - but we need auz space
Time consuming

Optimum solution approach - for all elements in the array, we change the element at its position to negative
=> nums[i] = 4
required position of 4 = i=3
we change nums[3]i.e. 7 to -7

=> this way we are capturing that 4 is present in the array

input = [4,3,2,7,8,2,3,1]
op = [5,6]

TC = O(n)
SC = O(1)
"""

class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        op = []
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index]>0:
                nums[index]*=-1

        for i in range(1,len(nums)+1):
            if nums[i-1]>0:
                op.append(i)

        return op
object = Solution()
nums = [4,3,2,7,8,2,3,1]
op = object.findDisappearedNumbers(nums)
print(op)
