# // Time Complexity :O(n) 
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if(nums==[]):
            return []
        result=[]
        for i in nums:
            index=abs(i)-1
            if(nums[index]>0):
                nums[index]=-1*nums[index]
        for i in range(len(nums)):
            if(nums[i]>0):
                result.append(i+1)
                
        return result
                
    