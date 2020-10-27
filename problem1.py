#timecomlexity O(n)
#spacecomplexity O(1)
# code didn't run in leet code
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums==[]: return []
        # creating list of all the number from 1 to len(nums)+1
        # if nums[i] value present in result array removing it
        # so at the end result left with the missing value
        result=[i for i in range(1,len(nums)+1)]
        for i in range(len(nums)):
            if nums[i] in result:
                result.remove(nums[i])
        return result