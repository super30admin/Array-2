class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums: 
            result =[]
        
            for i in range(len(nums)):
                if nums[abs(nums[i])-1] > 0:
                    nums[abs(nums[i])-1] *= -1

            for i in range(len(nums)):
                if nums[i] > 0:
                    result.append(i+1)


            return result
        
        else:
            return False
        
# Time complexity is O(2n) where n is the length of the array and we are going over the array twice
# Space complexity is O(1) since we are not using auxiliary data structure