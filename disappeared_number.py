"Time Complexity is O(N)"
"Space Complexity is O(1)"

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []

        for i in range(len(nums)):
            value = abs(nums[i])

            if nums[value-1] > 0:
                nums[value-1] = -1 * nums[value-1]
            else:
                continue
        

        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
            else:
                continue
        
        return result
        