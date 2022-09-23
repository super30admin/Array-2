#Time Complexity: O(n)
#Space Complexity: O(1)
#Did it run on Leetcode: Yes

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        output = [i+1 for i in range(len(nums))]
        for num in nums:
            output[num-1]=0
        output = [i for i in output if i != 0]
        return output