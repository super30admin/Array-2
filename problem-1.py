#Time Complexity: O(n)
#Space Complexity: O(1)
#Accepted successfully in leetcode: yes

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            p = abs(num)-1
            if nums[p]>0:
                nums[p] = -1*nums[p]
            else:
                pass
        return [i+1 for i,num in enumerate(nums) if num>0  ]