#time complexity : O(n)
#space complexity :O(1)
#Submit on leetcode: yes

class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        n = len(nums)
        result = []

        for i in range(0,n):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1
        
        for i in range(0,n):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] *= -1
        
        return result

sol = Solution()
arr = [4,3,2,7,8,2,3,1]
res = sol.findDisappearedNumbers(arr)
print("Missing numbers in this list: ",res)