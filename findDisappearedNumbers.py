#Time Complexity: O(n)
#Space Complexity: O(1)
def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result=[]
        for i in range(len(nums)):
            idx=abs(nums[i])-1
            if nums[idx]>0:
                nums[idx]*=-1
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
            else:
                nums[i]*=-1
        return result