class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if(len(nums)==0):
            return []
        l = []
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if(nums[index] > 0):
                nums[index] = nums[index] * -1
            
        for i in range(len(nums)):
            if(nums[i] > 0):
                l.append(i+1)
            else:
                nums[i] = nums[i] * -1
            
        return l
        