class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            #creating newindex positive
            new_index=abs(nums[i])-1
            #changing the elements to negative
            if nums[new_index]>0:
                nums[new_index]*=-1
        res=[]
        for i in range(1,len(nums)+1):
            #checking for positive elements
            if nums[i-1]>0:
                res.append(i)
        return res
#Time-Complexity: O(n)
#Space-Complexity: O(1)