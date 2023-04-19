#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums==None or len(nums)==0:
            return []
        length=len(nums)
        result=[]
        for i in range(length):
            temp=abs(nums[i])
            if(nums[temp-1]>0):
                nums[temp-1]=-nums[temp-1]
        for i in range(length):
            if nums[i]>0:
                result.append(i+1)
        return result