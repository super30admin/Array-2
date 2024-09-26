#Time Complexity:O(n)

#Space Complexity:O(1)
Ran succerssfully on Leetcode:Yes
#For each number i in nums,
#we mark the number that i points as negative.
#Then we filter the list, get all the indexes
#who points to a positive number.
#Since those indexes are not visited.




class Solution:
    def findDisappearedNumbers(self, nums):
        ans = []
        for i in range(len(nums)):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] = -nums[idx]
        for i in range(len(nums)):
            if nums[i] > 0:
                ans.append(i + 1)
                #print(ret)
        return ans
