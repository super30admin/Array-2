class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

      #mark array as negative
        i=0
        for n in nums:
            i = abs(n) - 1
            nums[i] = -1 * abs(nums[i])

        #get output
        out=[]
        for i,n in enumerate(nums):
            if n > 0:
                out = out.append(i+1)
            return out
                

    

    

    
        



        
