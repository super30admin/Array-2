class Solution(object):
    def __init__(self):
        self.min = 0
        self.max = 0
    def findDisappearedNumbers(self, nums):
        a=Solution()
        length=len(nums)
        a.max=nums[0]
        a.min=nums[0]
        for i in range(1,len(nums)):
            #print(a.max)
            #print(a.min)
            if nums[i]<a.min:
                a.min=nums[i]
            if nums[i]>a.max:
                a.max=nums[i]
        print(a.max)
        print(a.min)
            
        """
        :type nums: List[int]
        :rtype: List[int]
        """
     
            