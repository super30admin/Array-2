class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # we can use set, binary search, create additional array

        # lets keep inplace temp change in nums to mark it as present (by marking it as -ve if positive)

        for num in nums:
            idx = abs(num)-1
            if nums[idx] > 0:
                nums[idx] *= -1
        
        # 2nd pass
        # if num in nums > 0; corresponding index +1 is missing
        res = []
        for i,num in enumerate(nums):
            if num > 0:
                # missing
                res.append(i+1)
            
        return res
# TC: O(n)
# SC: O(1)

            
