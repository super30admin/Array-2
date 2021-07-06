class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for index,num in enumerate(nums):
            if nums[abs(num)-1]>0:
                nums[abs(num)-1] = -1*nums[abs(num)-1]
        ans = []
        print(nums)
        for index,num in enumerate(nums):
            if num>=0:
                ans.append(index+1)
        return ans
        
#Space Complexity O(1)
#Time Complexity O(n)