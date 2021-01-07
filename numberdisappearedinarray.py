class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        '''
        Time: O(n)
        Space: O(1)
        '''
        for i in range(0,len(nums)):
            idx= abs(nums[i]) - 1
            if(nums[idx]>0):
                nums[idx] *= -1
        
        x = []
        for i in range(0,len(nums)):
            if(nums[i]>0):
                x.append(i+1)
        
        return x
