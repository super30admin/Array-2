# TC: O(N)
# SC: O(N) as we are using hashMap

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        hash1={}
        
        
        for num in nums:
            if num not in hash1:
                hash1[num]=1
            else:
                hash1[num]+=1
                
        res=[]
        for i in range(1,len(nums)+1):
            if i not in hash1:
                res.append(i)
        return res




####################################################################################################
# TC: O(n)
# SC:O(1)

#Approach 2
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            index=abs(nums[i])-1
            
            if nums[index]<0:
                continue
            nums[index]*=-1
            
        res=[]
        for i in range(len(nums)):
            if nums[i]<0:
                continue
            res.append(i+1)
        return res
            