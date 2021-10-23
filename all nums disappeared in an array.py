# TC-O(n)
# SC-O(1)if ouput not considered
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result =[]

        for i in range(len(nums)):
            if nums[abs(nums[i])-1] >0:
                nums[abs(nums[i])-1]*=-1
        # print(nums)
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        return result