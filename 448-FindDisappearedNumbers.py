class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        maxval = 0
        for i in nums:
            if i > maxval:
                maxval = i
                
        # print(maxval)
        
        maxval = max(maxval, len(nums))
        # print(maxval)
        
        
        nums = set(nums)
        
        for i in range(1, maxval+1):
            if i not in nums:
                result.append(i)
        
        return result
    
    # space: o(1)
    # time: o(n)
        