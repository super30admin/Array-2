'''
Time Complexity: O(N), where N is length of list nums
Space Complexity: O(1)
Executed Successfully: Yes
Challenges faced: No
'''


#CODE
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            ind = abs(nums[i])-1
            if nums[ind] > 0:
                nums[ind] *= -1
        res = list()
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
        return res