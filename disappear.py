class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        # TC O(n)
        # SC O(1)
        if nums is None or len(nums) ==0:
            return []
        res = []
        # 1st pass
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
                
        # 2nd pass
        for i in range(len(nums)):
           
            if nums[i] > 0:
                res.append(i+1)
            # else:
            #     nums[i] = nums[i] * -1
        return res
                
