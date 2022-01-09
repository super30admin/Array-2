class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        dissapeared =[]
        for i in range(len(nums)):
            ind = abs(nums[i]) -1
            if nums[ind]>0:
                nums[ind] = -1* nums[ind]
             
                    
    
        for i in range(1,1+len(nums)):
            if nums[i-1]>0:
                dissapeared.append(i)
                
        return dissapeared
        #return list(set(list(range(1,len(nums)+1))) - set(nums)) alternate solution

        #time complexity O(n)  Two pass
        #space complexity O(1) in place