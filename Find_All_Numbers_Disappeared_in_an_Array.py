#TC: O(N) 
#SC: O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            temp = abs(nums[i]) - 1
            if nums[temp] > 0:
                nums[temp]*=-1
        print(nums)

        for j in range(len(nums)):
            if nums[j] > 0:
                result.append(j+1)

        return result
            
        