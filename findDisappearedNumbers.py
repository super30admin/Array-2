class Solution:#time O(n) space O(1)
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            idx=abs(nums[i])-1
            if nums[idx]>0:
                nums[idx]*=-1
        lst=[]
        for i in range(len(nums)):
            if nums[i]>0:
                lst.append(i+1)
            else:
                nums[i]*=-1
        return lst
