#Time Complexity: O(n)
#Sapce Complexity: O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            num=abs(num)
            nums[num-1]=-abs(nums[num-1])
        return [i+1 for i,num in enumerate(nums) if num>0]