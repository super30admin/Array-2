class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(len(nums)):
            print(nums[abs(nums[i])-1])
            nums[abs(nums[i])-1] = -1*(abs(nums[abs(nums[i])-1]))
        
        arr = []
        for i in range(len(nums)):
            if nums[i]>0:
                arr.append(i+1)
        return arr