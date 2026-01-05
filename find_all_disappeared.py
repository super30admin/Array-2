'''
Docstring for find_all_disappeared
This is pretty straight forward soilution, and it is very optimal as well, the only caveat is, it does run with extra space, that's it.
'''

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        res = []
        for i in range(len(nums)):

            index = abs(nums[i])-1

            index_num = abs(nums[index])*-1

            nums[index] = index_num


        for i in range(len(nums)):

            if nums[i]>0:
                res.append(i+1)
        return res

'''
This is tricky, it involves making changes to the given array, and making it multiply with -1

At the end, you will figure out the elements which are greater than 0, and that's when you realize those are the elements you want.

You will want to put this logic on the paper for sure, for clarity.

If the input also contains negative integers, you solve it using a offset.




'''


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        res = []
        for i in range(len(nums)):

            index = abs(nums[i])-1

            index_num = abs(nums[index])*-1

            nums[index] = index_num


        for i in range(len(nums)):

            if nums[i]>0:
                res.append(i+1)
        return res






