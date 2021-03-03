#Time_complexity: o(n)
#space_complexity: o(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):        
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] =  nums[index]*-1
        print(nums)
        for j in range(len(nums)):
            if nums[j] > 0:
                print(j)
                val = j + 1
                result.append(val)
        return result
