class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        arr=[]
        for i in nums:
            if nums[abs(i)-1] > 0:
                nums[abs(i)-1] = -1 * nums[abs(i)-1]
                
        for i in range(0, len(nums)):
            if nums[i] > 0:
                arr.append(i + 1)
                
        return arr