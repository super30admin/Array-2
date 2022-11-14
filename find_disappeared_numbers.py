class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        ## T.C = O(n)
        ## S.C = O(1)
        
        for i in nums:
            if nums[abs(i) - 1] > 0:
                nums[abs(i) - 1] *= -1
        

        return [i+1 for i,j in enumerate(nums) if j > 0]
        