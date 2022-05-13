#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        lst = []
        for i in range(len(nums)):
            idx = abs(nums[i])-1
            if nums[idx]>0:
                nums[idx] = nums[idx]*-1
                
        for i in range(len(nums)):
            if nums[i] > 0:
                lst.append(i+1)
            else:
                nums[i] = nums[i]*-1
        return lst