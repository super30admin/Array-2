class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        
        result = []
        
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            
            if nums[index]>0:
                nums[index] *= -1
        
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
            else:
                nums[i] *= -1
        
        return result


# TC: O(N) SC: O(1)
# mapping index to array and making it negative. in the end, if the value is positive, adding its index + 1 to the output array