class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Idea:
        #1.Given Array contains only numbers between 1 to n(size of array). We can use a marking scheme to keep track of values that we see.
        #2. Iterate through array and use ith element as an index to mark it as negative.
        # 3. In the end, the array elements that are positive, that implies those indices were never present in the array.
        
        # Time Complexity: O(n)
        # Space Complexity: O(1)
        if not nums:
            return []
        nums = [0] + nums
        for i in range(1,len(nums)):
            if nums[abs(nums[i])] > 0:
                nums[abs(nums[i])] = -nums[abs(nums[i])]
        output = []
        for i in range(1,len(nums)):
            if nums[i] > 0:
                output.append(i)
        return output
