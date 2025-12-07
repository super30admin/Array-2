# Loop through nums. If the element is >0 go to the elelment-1 th index and make the 
# element there negative if it is postive . Else if the element<0, go to the index of the 
# abs(element) and make the element negative if its positive.

# Loop through the nums array array and check if any element is > 0, if so append it to an 
# array and return the array

# Time complexity: O(n)
# Space complexity: O(1)

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        for i in nums:
            if i>0:
                nums[i-1]= -1*nums[i-1] if nums[i-1]>0 else nums[i-1]
            elif i<0:
                r=(-1*i)-1
                nums[r]=-1*nums[r] if nums[r]>0 else nums[r]
        arr=[]
        for ind, i in enumerate(nums):
            if i >0:
                arr.append(ind+1)
        return arr




        