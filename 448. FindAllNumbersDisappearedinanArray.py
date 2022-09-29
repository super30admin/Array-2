## Passed in leet code
# O(N)
#O(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if len(nums)==0:
            return 0
        result_list=[]
        for i in range(len(nums)):
            if abs(nums[abs(nums[i])-1]) == nums[abs(nums[i])-1]:
                nums[abs(nums[i])-1]=-nums[abs(nums[i])-1]
        for i in range(len(nums)):
            if nums[i] == abs(nums[i]):
                result_list.append(i+1)
            else:
                nums[i] = abs(nums[i])
        return result_list            