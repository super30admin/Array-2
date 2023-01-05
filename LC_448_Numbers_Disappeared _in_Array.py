TC-> O(n) + o(n) -> o(n)
Sc->0(1)

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # [4,3,2,7,8,2,3,1]
        #  0 1 2 3 4 5 6 7


        if nums == [] or len(nums) == 0:
            return []
        
        result = []

        for i in range(len(nums)):
            idx = abs(nums[i])-1
            if nums[idx]>0:
                nums[idx] = nums[idx]* -1
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        return result
