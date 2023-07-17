#Space Complexity O(1)
#Time Complexity O(n)

class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        for index,num in enumerate(nums):
            if nums[abs(num)-1]>0:
                nums[abs(num)-1] = -1*nums[abs(num)-1]
        ans = []
        print(nums)
        for index,num in enumerate(nums):
            if num>=0:
                ans.append(index+1)
        return ans
        

s = Solution()
input_nums = [4, 3, 2, 7, 8, 2, 3, 1]
output_nums = s.findDisappearedNumbers(input_nums)
print(output_nums)

