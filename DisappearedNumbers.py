class Solution(object):
    # Time Complexity is O(n)
    # Space Complexity is O(1)
    # We are using the array as a Hashmap and marking the indices of the array with visited numbers.
    # Indices that are not marked as negative are non visited, hence those numbers doesn't exist in Array
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for num in nums:
            i = abs(num) - 1
            if(nums[i] > 0):
                nums[i] = -nums[i]
        out = []
        #print(nums)
        for i in range(len(nums)):
            if(nums[i] > 0):
                out.append(i+1)
        return out