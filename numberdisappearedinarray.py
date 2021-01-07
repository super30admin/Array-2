class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        '''
        Time: O(n)
        Space: O(n)
        '''
        n= len(nums)
        x = set([i for i in range(1,n+1)])
        for i in nums:
            if(i in x):
                x.remove(i)
            
        return x
