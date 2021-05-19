class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        '''
        TC : O(N)
        SC : O(1)
        Approach : 
        for every elemet if
        
        '''
        res = []
        for num in nums:
            i = abs(num)
            if nums[i-1] > 0 :
                nums[i-1] *= -1

        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
        return res
            
        