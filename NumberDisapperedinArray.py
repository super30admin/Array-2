class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            if nums[abs(nums[i])-1]>0:
                nums[abs(nums[i])-1] = -1 * nums[abs(nums[i])-1]
        arr = []
        for i in range(len(nums)):
            if nums[i]>0:
                arr.append(i+1)
        return arr

        