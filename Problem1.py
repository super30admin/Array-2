#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
#check the value in array and multiply -1 to the index(X-1 if X is value) of that value. return index+1 of values which are not negative

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n=len(nums)
        result=[]
        for i in range(n):
            index=abs(nums[i])-1
            if nums[index]>0:
                nums[index]=nums[index]*-1
        for i in range(n):
            if nums[i]>0:
                result.append(i+1)
            else:
                nums[i]=nums[i]*-1
        return result