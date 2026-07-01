#Problem 448. FIND ALL NUMBERS DISAPPEARED IN AN ARRAY
# TIME COMPELXITY: O(N)  where N denotes the number of elements in a given array
# SPACE COMPLEXITY: O(1) as the given result array is being returned 


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n=len(nums)
        for i in range(n):
            index=abs(nums[i])-1
            if nums[index]>0:
                nums[index]=nums[index]*-1

        result=[]

        for i in range(n):
            if nums[i]>0:
                result.append(i+1)
        return result