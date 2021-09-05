class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        res = [ 0 for i in range(len(nums)+1)]
        temp = []
            
        for x in nums:
            res[x] += 1
        
       # print(res)
        
        for i,val in enumerate(res):
            if i != 0 and val == 0:
                temp.append(i)
                
                
        return temp