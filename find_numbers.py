#time complexity: O(n)
#space complexity: O(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums==None or len(nums)==0: return []
        ans=[]
        
        for i in range(len(nums)):
            index=abs(nums[i])-1
            if nums[index]>0:
                nums[index]=-nums[index]
            
        for i in range(len(nums)):
            if nums[i]<0:
                nums[i]=-nums[i]
            else:
                ans.append(i+1)
        return ans